import java.util.ArrayList;
import java.util.List;

/**
 * @author Ernest Chen
 * @date 2021/2/2.
 */
public class Main {

    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    
   public static void getNewNode(Node head1, Node head2) {
        String str1 = "";
       String str2 = "";
       while (head1 != null) {
            str1 += head1.val;
            head1 = head1.next;
        }

       System.out.println(str1);
       while (head2 != null) {
           str2 += head2.val;
           head2 = head2.next;
       }
       System.out.println(str2);
       String res = String.valueOf(Integer.valueOf(str1) + Integer.valueOf(str2));

       System.out.println(res);
//
//       1234/10 = 123 ----- 4
//               123/10 = 12 -------3
//                       12/10 = 1 -----2
//                               1/10 = 0 break;


//       int[] items <- res;
//       int count = 1;
//       Node newHead = new Node(items[0]);
//       Node pre = newHead;
//
//       while (count != res.length()) {
//           Node node = new Node(items[count]);
//            newHead.next = node;
//            newHead = node;
//           count++;
//       }
//       return pre;
   }

    public static void main(String[] args) {
        Node node = new Node(9);
        Node node1 = new Node(3);
        Node node2 = new Node(7);
        node.next = node1;
        node1.next = node2;

        Node node3 = new Node(6);
        Node node4 = new Node(3);
        node3.next = node4;

        getNewNode(node, node3);
    }
}
