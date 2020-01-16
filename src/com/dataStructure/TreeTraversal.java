package com.dataStructure;

import java.util.*;

/**
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 */
public class TreeTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        return preorderTraversal(root, res);
    }

    private List<Integer> preorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null)
            res.add(root.val);
        if (root.left != null)
            preorderTraversal(root.left, res);
        if (root.right != null)
            preorderTraversal(root.right, res);
        return res;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        return inorderTraversal(root, res);
    }

    public List<Integer> inorderTraversal(TreeNode root, List<Integer> res) {
        if (root.left != null)
            inorderTraversal(root.left, res);
        if (root != null)
            res.add(root.val);
        if(root.right != null)
            inorderTraversal(root.right, res);
        return res;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        return postorderTraversal(root, res);
    }

    private List<Integer> postorderTraversal(TreeNode root, List<Integer> res) {
        if (root.left != null)
            postorderTraversal(root.left, res);
        if (root.right != null)
            postorderTraversal(root.right, res);
        if (root != null)
            res.add(root.val);
        return res;
    }


    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    /**
     * BFS遍历
     * @param root
     * @param res
     */
    private void bfs(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
        }
    }

    /**
     * 二叉树最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //BFS的层次遍历思想，记录二叉树的层数，
        //遍历完，层数即为最大深度
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }

//    private static int maxDepth2(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        stack.push(new Pair<>(root, 1));
//        int maxDepth = 0;
//        //DFS实现前序遍历，每个节点记录其所在深度
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> pair = stack.pop();
//            TreeNode node = pair.first;
//            //DFS过程不断比较更新最大深度
//            maxDepth = Math.max(maxDepth, pair.second);
//            //记录当前节点所在深度
//            int curDepth = pair.second;
//            //当前节点的子节点入栈，同时深度+1
//            if (node.right != null) {
//                stack.push(new Pair<>(node.right, curDepth + 1));
//            }
//            if (node.left != null) {
//                stack.push(new Pair<>(node.left, curDepth + 1));
//            }
//        }
//        return maxDepth;
//    }

}
