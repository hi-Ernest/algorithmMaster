package com.algorithm.z_链表.复杂链表的复制;

/**
 * @author Ernest Chen
 * @date 3/12/21 12:00 AM.
 */

import java.util.*;

public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param head 链表头节点
     * @return 返回新链表头节点
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //创建新链表 （深拷贝）
        //新老链表串联
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
            // cur = newNode;
            // cur = cur.next;
        }
        //根据老链表引用 -> 新链表引用random
        cur = head;
        while (cur != null) {
            //判断 否则空指针
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //新老链表拆分断开
        // 3. 拆分两链表
        cur = head.next;
        Node prev = head;
        Node res = head.next;
        while (cur.next != null) {
            prev.next = prev.next.next;
            cur.next = cur.next.next;
            prev = prev.next;
            cur = cur.next;
        }
        //关键 处理原链表
        prev.next = null;
        return res;
    }


    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param head 链表头节点
     * @return 返回新链表头节点
     */
    public Node Clone(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        //将新旧节点映射关系存储在Map
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //根据Map映射关系来构建next 和 random指向
        cur = head;
        while (cur != null) {
            //新节点.next指向 旧节点指向的地址
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
