package com.algorithm.剑指offer.删除链表中重复的结点;

import com.sun.javafx.font.directwrite.DWGlyph;

/**
 * @author Ernest Chen
 * @date 2020/7/25.
 *
 * 在一个排序的链表中，存在重复的结点
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * */
public class DeleteDuplication {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        //记录前置位置A 记录后置B
        //进行连接 = 删除之间结点
        int tmp = pHead.val;
        ListNode tmpNode = pHead;
        int count = 1;
        while (pHead.next != null) {
            pHead = pHead.next;
            if (count >= 2) {
                tmpNode.next = pHead;
            }
            if (tmp == pHead.val) {
                count++;
            }else {
                tmpNode = pHead;
            }
        }
        return pHead;
    }


    public ListNode deleteDuplication_(ListNode pHead)
    {
        ListNode result;
        ListNode temp=pHead;
        ListNode index=new ListNode(1);
        index.next=pHead;
        result=index;
        while(temp!=null){
            if(temp.next!=null&&temp.next.val==temp.val){
                while(temp.next!=null&&temp.next.val==temp.val){
                    temp=temp.next;
                }
                temp=temp.next;
                index.next=temp;
            }
            else{
                index=index.next;
                temp=temp.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);

//        pHead.next = first;
//        first.next = second;

//        while (pHead != null) {
//            System.out.println(pHead.val);
//            pHead = pHead.next;
//        }

        pHead.next = second;

        while (pHead != null) {
            System.out.println(pHead.val);
            pHead = pHead.next;
        }

    }
}
