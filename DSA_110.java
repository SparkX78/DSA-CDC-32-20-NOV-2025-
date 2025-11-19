public class DSA_110 {
    static class ListNode{
        ListNode next;
        int data;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }

        public static ListNode remove_LastNode(ListNode head, int n){
            int len = 0;
            ListNode temp = head;
            while(temp != null){
                len++;
                temp = temp.next;
            }
            
            if(len == n){
                return head.next;
            }
            temp = head;
            for(int i =1; i < len-n; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;

        }

        public static void printList(ListNode head){
            ListNode curr = head;
            while(curr != null){
                System.out.print(curr.data+"->");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args){
        ListNode node = new ListNode(12);
        node.next = new ListNode(13);
        node.next.next = new ListNode(14);
        node.next.next.next = new ListNode(15);
        node.next.next.next.next = new ListNode(16);
        node.next.next.next.next.next = new ListNode(17);
        node.next.next.next.next.next.next = new ListNode(18);

        System.out.println("------ORIGINAL LINKED LIST-------");
        ListNode.printList(node);

        System.out.println("-----AFTER REMOVING N ELEMENT FROM END-----");
        
        ListNode.printList(node.remove_LastNode(node, 3));
    }
}
