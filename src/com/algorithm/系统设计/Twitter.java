package com.algorithm.系统设计;

import java.util.*;

/**
 * create by Ernest on 2020/4/11.
 */
public class Twitter {

    private static int timestamp = 0;

    public static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    public static class User {
        private int userId;
        private Tweet head;
        private Set<Integer> followedSet;

        public User(int userId) {
            this.userId = userId;
            followedSet = new HashSet<>();
            this.head = null;
            //关注自己
            followedSet.add(userId);
        }

        public void followed(int userId) {
            followedSet.add(userId);
        }

        public void unFollowed(int id) {
            if (userId != id) {
                followedSet.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            //新推文插入头部
            //越靠近头部 timestamp 值越大
            tweet.next = head;
            head = tweet;
        }
    }

    //保证已经创建存在的user 不需要在new
    Map<Integer, User> userMap = new HashMap<>();

    /**
     * user 发表一条 tweet 动态
     *
     * @param userId
     * @param tweetId
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    /**
     * follower 关注 followee
     *
     * @param followerId
     * @param followeeId
     */
    public void follower(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).followedSet.add(followeeId);
    }

    /**
     * follower 取关 followee，如果 Id 不存在则什么都不做
     *
     * @param followerId
     * @param followeeId
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        userMap.get(followerId).unFollowed(followeeId);
    }

    /**
     * 返回该 user 关注的人（包括他自己）最近的动态 id，
     * 最多 10 条，而且这些动态必须按从新到旧的时间线顺序排列。
     * <p>
     * 算法分析：
     * 合并有序的K个有序链表 -> （优先队列）PriorityQueue 二叉堆
     * 对插入元素进行自动排序
     *
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeeds(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        Set<Integer> followers = userMap.get(userId).followedSet;
        //优先队列 默认小根堆 -> 大根堆
        PriorityQueue<Tweet> queue = new PriorityQueue<>(followers.size(), (a, b) -> (b.time - a.time));

        for (int uid : followers) {
            Tweet tweet = userMap.get(uid).head;
            if (tweet == null) {
                continue;
            }
            //添加所有关注者头部节点，即各个关注者最新的时间
            queue.add(tweet);
        }

        while (!queue.isEmpty()) {
            if (res.size() == 10) {
                break;
            }
            //弹出 time 值最大的（最近发表的）
            Tweet tweet = queue.poll();
            res.add(tweet.id);
            while (tweet.next != null) {
                queue.offer(tweet.next);
            }
        }
        return res;
    }
}
