package zz;

import java.util.*;

/**
 * @author Ernest Chen
 * @date 2/22/21.
 */
public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println();
        }
    }

    public void test(String s, char[] a) {
        s = "1234";
        a[0] = 'o';
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode a = new TreeNode(2);
//        TreeNode b = new TreeNode(3);
//        TreeNode c = new TreeNode(4);
//        root.left = a;
//        root.right = b;
//        a.right = c;
//
//        new Main().print(root);

//        Main m = new Main();
//        String s = "weerttt";
//        char[] chars = {'1','2','3'};
//        chars.length
//        m.test(s, chars);
//        System.out.println(s + " and " + chars.toString());
//        Object o = new Object();
//        o.equals();
//        o.hashCode();
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put();
    }
}
