package com.algorithm.剑指offer.二叉搜索树后序遍历序列;

/**
 * @author Ernest Chen
 * @date 2020/7/28.
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 *
 */
import java.util.*;
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     * @param sequence 输入数组
     * @param left 数组左边指针
     * @param right 数组右边指针
     * @return
     */
    public boolean isTreeBST(int[] sequence, int left, int right) {
        //节点小于1个 return
        if (left >= right) {
            return true;
        }
        int point = left;
        while (sequence[point] < sequence[right]) {
            point++;
        }
        int mid = point;
        while (sequence[point] > sequence[right]) {
            point++;
        }
        //此树是否为二叉查找树
        //左子树是否为二叉查找树
        //右子树是否为二叉查找树
        return (point == right) && isTreeBST(sequence, left, mid - 1)
                && isTreeBST(sequence, mid, right - 1);
    }

    /**
     * 使用单调栈
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param sequence 二叉树（数组表示）
     * @return 是否为二叉查找树
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int parentNode = Integer.MAX_VALUE;
        for (int i = sequence.length - 1; i >= 0; i--) {
            if (sequence[i] > parentNode) {
                return false;
            }
            while (!stack.isEmpty() && sequence[i] < stack.peek()) {
                parentNode = stack.pop();
            }
            stack.push(sequence[i]);
        }
        return true;
    }
}
