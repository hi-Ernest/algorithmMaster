package com.algorithm.剑指offer.删除链表中重复的结点;

import com.sun.javafx.font.directwrite.DWGlyph;

import java.util.ArrayList;

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
        if (pHead == null) {
            return pHead;
        }
        //记录前置位置A 记录后置B
        //进行连接 = 删除之间结点
        ListNode item = pHead = new ListNode(0);
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode res = pre;

        while (item != null) {
            if (item.next != null && item.val == item.next.val) {
                while (item != null && item.val == item.next.val) {
                    item = item.next;
                }
                item = item.next;
                pre.next = item;
            }else {
                item = item.next;
                pre = pre.next;
            }
        }
        return res.next == null ? new ListNode(0).next : res.next;
    }


    public ListNode deleteDuplication_(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(1);
        index.next = pHead;
        result = index;
        while(temp!=null) {
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


    public ListNode test(ListNode pHead) {
        if (pHead==null || pHead.next==null){return pHead;}
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre  = Head;
        ListNode last = Head.next;
        while (last!=null){
            if(last.next!=null && last.val == last.next.val){
                // 找到最后的一个相同节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
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
