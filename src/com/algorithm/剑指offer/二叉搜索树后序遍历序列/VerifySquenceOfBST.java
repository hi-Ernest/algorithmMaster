package com.algorithm.剑指offer.二叉搜索树后序遍历序列;

/**
 * @author Ernest Chen
 * @date 2020/7/28.
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    public boolean isTreeBST(int[] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }

        int i = start;
        while (i < end) {
            if (sequence[i] > sequence[end]) {
                break;
            }
            i++;
        }

        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return isTreeBST(sequence, start, i - 1) && isTreeBST(sequence, i, end - 1);
    }
}
