package com.algorithm.z_二叉树.寻找重复的子树;

import com.algorithm.z_二叉树.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Ernest Chen
 * @date 3/9/21 2:24 PM.
 */
public class FindDuplicateSubtrees {
    private Map<String, Integer> countMap = new HashMap<>();
    private List<TreeNode> ans = new LinkedList<>();;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serializable(root);
        return ans;
    }

    /**
     * 深度优先遍历 + 返回当前子树序列化结果
     * @param root 每个节点作为子树root
     * @return 序列化
     */
    public String serializable(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String str = root.val + "," + serializable(root.left) + "," + serializable(root.right);
        countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        if (countMap.get(str) == 2) {
            ans.add(root);
        }
        return str;
    }
}
