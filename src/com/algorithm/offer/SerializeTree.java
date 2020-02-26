package com.algorithm.offer;

/**
 * create by Ernest on 2020/2/26.
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class SerializeTree {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }

    private void Serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }


    TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strs = str.split(",");
        return Deserialize(strs);
    }

    int index = -1;
    private TreeNode Deserialize(String[] strs) {
        index++;
       if (!strs[index].equals("#")) {
           TreeNode root = new TreeNode(0);
           root.val = Integer.parseInt(strs[index]);
           root.left = Deserialize(strs);
           root.right = Deserialize(strs);
           return root;
       }
       return null;
    }
}
