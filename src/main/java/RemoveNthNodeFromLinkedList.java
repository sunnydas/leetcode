public class RemoveNthNodeFromLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (n > 0 && fastPtr != null) {
            fastPtr = fastPtr.next;
            n--;
        }
        ListNode prev = null;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }
        if (prev != null) {
            prev.next = slowPtr.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 3};
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.createList(input);
        addTwoNumbers.print(l1);
        RemoveNthNodeFromLinkedList removeNthNodeFromLinkedList = new RemoveNthNodeFromLinkedList();
        l1 = removeNthNodeFromLinkedList.removeNthFromEnd(l1, 3);
        addTwoNumbers.print(l1);
        input = new int[]{1, 2, 3, 4, 5};
        addTwoNumbers = new AddTwoNumbers();
        l1 = addTwoNumbers.createList(input);
        addTwoNumbers.print(l1);
        removeNthNodeFromLinkedList = new RemoveNthNodeFromLinkedList();
        l1 = removeNthNodeFromLinkedList.removeNthFromEnd(l1, 2);
        addTwoNumbers.print(l1);
        input = new int[]{1};
        addTwoNumbers = new AddTwoNumbers();
        l1 = addTwoNumbers.createList(input);
        addTwoNumbers.print(l1);
        removeNthNodeFromLinkedList = new RemoveNthNodeFromLinkedList();
        l1 = removeNthNodeFromLinkedList.removeNthFromEnd(l1, 1);
        addTwoNumbers.print(l1);
        input = new int[]{1,2};
        addTwoNumbers = new AddTwoNumbers();
        l1 = addTwoNumbers.createList(input);
        addTwoNumbers.print(l1);
        removeNthNodeFromLinkedList = new RemoveNthNodeFromLinkedList();
        l1 = removeNthNodeFromLinkedList.removeNthFromEnd(l1, 1);
        addTwoNumbers.print(l1);
    }

}
