package leetcode.list;

/**
 * 递归翻转单链表
 * Created by blank on 2015-08-27 下午3:46.
 */
public class ReverseList {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = node1;
        System.out.println(node);
        node = reverse(node1);
        System.out.println(node);

    }

    static ListNode reverse(ListNode listNode) {
        ListNode nHead = new ListNode(0);
        return helper(listNode, nHead);
    }

    static ListNode helper(ListNode list, ListNode nHead) {
        if (list == null) {
            return nHead.next;
        }
        ListNode tmp = list.next;
        list.next = nHead.next;
        nHead.next = list;
        return helper(tmp, nHead);
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
