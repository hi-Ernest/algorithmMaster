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


}
