public class DSA_109 {
    static class ListNode{
        ListNode next;
        int data;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    
        public static boolean check_Pallindrome(ListNode head ){
            if(head == null || head.next == null) return true;
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                
            }
            ListNode second = reverse(slow);
            ListNode first = head;
            while(second!= null){
                if(first.data != second.data) return false;
                first = first.next;
                second = second.next;
            }
            return true;
            

        }
        private static ListNode reverse(ListNode Head){
            ListNode prev = null;
            ListNode next = null;
            while(Head != null){
                next = Head.next;
                Head.next = prev;
                prev = Head;
                Head = next;

            }
            return prev;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(ListNode.check_Pallindrome(head));
    }
}
