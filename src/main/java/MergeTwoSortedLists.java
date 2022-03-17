public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode head = null;
        ListNode prev = null;
        while (current1 != null
                && current2 != null) {
            ListNode node = new ListNode();
            if (current1.val > current2.val) {
                node.val = current2.val;
                current2 = current2.next;
            } else if (current1.val < current2.val) {
                node.val = current1.val;
                current1 = current1.next;
            } else {
                node.val = current1.val;
                ListNode node1 = new ListNode();
                node1.val = current1.val;
                node.next = node1;
                current1 = current1.next;
                current2 = current2.next;
            }
            if (prev != null) {
                prev.next = node;
                if (node.next != null) {
                    prev = node.next;
                } else {
                    prev = node;
                }
            } else {
                head = node;
                if (node.next != null) {
                    prev = node.next;
                } else {
                    prev = node;
                }
            }
        }
        while (current1 != null) {
            ListNode node = new ListNode();
            node.val = current1.val;
            if (prev != null) {
                prev.next = node;
                prev = node;
            } else {
                head = node;
                prev = node;
            }
            current1 = current1.next;
        }
        while (current2 != null) {
            ListNode node = new ListNode();
            node.val = current2.val;
            if (prev != null) {
                prev.next = node;
                prev = node;
            } else {
                head = node;
                prev = node;
            }
            current2 = current2.next;
        }
        return head;
    }


    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.createList(new int[]{1, 2, 4});
        ListNode l2 = addTwoNumbers.createList(new int[]{1, 3, 4});
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        addTwoNumbers.print(l);
        l1 = addTwoNumbers.createList(new int[]{});
        l2 = addTwoNumbers.createList(new int[]{0});
        mergeTwoSortedLists = new MergeTwoSortedLists();
        l = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        addTwoNumbers.print(l);
    }

}
