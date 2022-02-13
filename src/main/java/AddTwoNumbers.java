class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumNode = null;
        ListNode rootSum = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode currentSum = new ListNode();
            carry = getSUm(sum, currentSum);
            l1 = l1.next;
            l2 = l2.next;
            if (sumNode == null) {
                sumNode = currentSum;
                rootSum = sumNode;
            } else {
                sumNode.next = currentSum;
                sumNode = currentSum;
            }
        }
        if (l1 != null || l2 != null) {
            ListNode remaining = l1 != null ? l1 : l2;
            while (remaining != null) {
                int sum = remaining.val + carry;
                ListNode currentSum = new ListNode();
                carry = getSUm(sum, currentSum);
                sumNode.next = currentSum;
                sumNode = currentSum;
                remaining = remaining.next;
            }
        }
        if (carry > 0) {
            ListNode currentSum = new ListNode(carry);
            sumNode.next = currentSum;
        }
        return rootSum;
    }

    private int getSUm(int sum, ListNode currentSum) {
        int carry;
        if (sum / 10 > 0) {
            currentSum.val = sum % 10;
            carry = 1;
        } else {
            currentSum.val = sum;
            carry = 0;
        }
        return carry;
    }

    public ListNode createList(int[] input) {
        ListNode root = null;
        ListNode previous = null;
        for (int i = 0; i < input.length; i++) {
            ListNode current = new ListNode(input[i]);
            if (previous != null) {
                previous.next = current;
            } else {
                root = current;
            }
            previous = current;
        }
        return root;
    }

    public void print(ListNode root) {
        System.out.println();
        while (root != null) {
            System.out.print(root.val);
            if (root.next != null) {
                System.out.print("->");
            }
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 3};
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.createList(input);
        addTwoNumbers.print(l1);
        int[] input1 = new int[]{5, 6, 4};
        ListNode l2 = addTwoNumbers.createList(input1);
        addTwoNumbers.print(l2);
        ListNode rootSum = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.print(rootSum);
        input = new int[]{0};
        l1 = addTwoNumbers.createList(input);
        input1 = new int[]{0};
        l2 = addTwoNumbers.createList(input1);
        rootSum = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.print(rootSum);
        System.out.println("-----");
        input = new int[]{9, 9, 9, 9, 9, 9, 9};
        l1 = addTwoNumbers.createList(input);
        input1 = new int[]{9, 9, 9, 9};
        l2 = addTwoNumbers.createList(input1);
        rootSum = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.print(rootSum);
    }

}