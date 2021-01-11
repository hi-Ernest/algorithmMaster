package firstweek.list1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: chenhuarui
 * @date: 2020/11/23 08:19
 */
public class NextGreaterNode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> nums = new LinkedList<>();
        int index = 0;
        ListNode cur = head;

        while (cur != null)  {
            nums.add(cur.val);
            while (!stack.isEmpty() && nums.get(stack.peek()) < cur.val) {
                nums.set(stack.poll(), cur.val);
            }
            stack.push(index);
            cur = cur.next;
            index++;
        }

        if (!stack.isEmpty()) {
            nums.set(stack.pop(), 0);
        }

        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterNode ngn = new NextGreaterNode();

    }
}
