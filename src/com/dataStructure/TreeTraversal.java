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
     * 二叉树最大深度 -> 自底向上
     * @param root
     * @return
     */
    public int maxDepth_bottom_up(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth_bottom_up(root.left);
        int right = maxDepth_bottom_up(root.right);
        return Math.max(left, right) + 1;
    }

    private int answer;

    public void maxDepth_top_down(TreeNode root, int maxDepth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            answer = Math.max(answer, maxDepth);
        maxDepth_top_down(root.left, maxDepth + 1);
        maxDepth_top_down(root.right, maxDepth + 1);
    }

    public static int maxDepth_bfs(TreeNode root) {
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
                TreeNode cur = queue.pollFirst();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 判断是否为对称树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 是否存在指定target的树路径和
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return checkPathSum(root, 0, sum);
    }

    private boolean checkPathSum(TreeNode root, int sum, int target) {
        if (root == null)
            return false;
        sum += root.val;

        if (sum == target && root.left == null && root.right == null)
            return true;
        return checkPathSum(root.left, sum, target) || checkPathSum(root.right, sum, target);
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
//
//        for (int i = 0; i < inorder.length; i++) {
//            inorderIdxMap.put(inorder[i], i);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int j = 0; j < preorder.length; j++) {
//            queue
//        }
//
//    }


    /**
     * 前序遍历 + 中序遍历 -> build tree
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderIdxMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }

        Queue<Integer> preorderQueue = new LinkedList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderQueue.add(preorder[i]);
        }

        return buildTree(preorderQueue, 0, preorder.length - 1, inorderIdxMap);
    }

    public TreeNode buildTree(Queue<Integer> preorderQueue, int left, int right, Map<Integer, Integer> inorderIdxMap) {

        if (left > right || preorderQueue.isEmpty()) {
            return null;
        }

        int root = preorderQueue.poll();
        TreeNode node = new TreeNode(root);
        int inorderIdx = inorderIdxMap.get(root);
        node.left = buildTree(preorderQueue, left, inorderIdx - 1, inorderIdxMap);
        node.right = buildTree(preorderQueue, inorderIdx + 1, right, inorderIdxMap);

        return node;
    }

    /**
     * 后序遍历 + 中序遍历 -> build tree
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree_2(int[] postorder, int[] inorder) {

        Map<Integer, Integer> inorderIdxMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }

        Stack<Integer> postorderStack = new Stack<>();
        for (int i = 0; i < postorder.length; i++) {
            postorderStack.push(postorder[i]);
        }

        return buildTree(postorderStack, 0, postorder.length - 1, inorderIdxMap);
    }

    public TreeNode buildTree(Stack<Integer> postorderStack, int left, int right, Map<Integer, Integer> inorderIdxMap) {

        if (left > right || postorderStack.isEmpty()) {
            return null;
        }

        int root = postorderStack.pop();
        TreeNode node = new TreeNode(root);
        int inorderIdx = inorderIdxMap.get(root);
        node.right = buildTree(postorderStack, inorderIdx + 1, right, inorderIdxMap);
        node.left = buildTree(postorderStack, left, inorderIdx - 1, inorderIdxMap);

        return node;
    }
}
