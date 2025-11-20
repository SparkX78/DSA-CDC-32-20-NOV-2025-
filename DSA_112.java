public class DSA_112 {
    static class ListNode{
        ListNode next;
        int data;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
        public static void reordering(ListNode head){
            if(head == null || head.next == null) return;
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode second = reverse(slow.next);
            slow.next = null;

            ListNode first = head;
            while(second != null){
                ListNode temp1 = first.next;
                ListNode temp2 = second.next;

                first.next = second;
                second.next = temp1;
                first = temp1;
                second = temp2;
            }
        }
        private static ListNode reverse(ListNode head){
            ListNode prev = null;
            while(head != null){
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next; 
            }
            return prev;
        }

        public static void printList(ListNode head){
            ListNode temp = head;
            while(temp != null){
                System.out.print(temp.data +"->");
                temp = temp.next;
            }
            System.out.println("null");
        }

    }
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        System.out.println("-----original linked list --- ");
        ListNode.printList(node);

        System.out.println("-----reorder linked list --- ");
        node.reordering(node);
        ListNode.printList(node);
    }

}
