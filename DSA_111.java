public class DSA_111 {
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }

        public static ListNode partition(ListNode head, int x){
            ListNode smallDummy = new ListNode(0);
            ListNode largeDummy = new ListNode(0);
            ListNode small = smallDummy;
            ListNode large = largeDummy;
            ListNode curr = head;
            while(curr != null){
                if(curr.data < x){
                    small.next = curr;
                    small = small.next;
                }
                else{
                    large.next = curr;
                    large = large.next;
                }
                curr = curr.next;
            }
            large.next = null;
            small.next = largeDummy.next;
            return smallDummy.next;

        }

        public static void printList(ListNode head){
            ListNode temp = head;
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args){
        ListNode node = new ListNode(12);
        node.next = new ListNode(18);
        node.next.next = new ListNode(17);
        node.next.next.next = new ListNode(15);
        node.next.next.next.next = new ListNode(10);
        node.next.next.next.next.next = new ListNode(9);

        System.out.println("----Original linked list---");
        ListNode.printList(node);

        System.out.println("------Parttion linked list-----");
        
        ListNode.printList(ListNode.partition(node, 15));

    }
}
