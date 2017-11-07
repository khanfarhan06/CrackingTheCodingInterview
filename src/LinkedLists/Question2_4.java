package LinkedLists;

//QUESTION 2.4: You have two numbers represented by a linked list, where each node contains a single digit.
//              The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
//              Write a function that adds the two numbers and returns the sum as a linked list.
//EXAMPLE:      Input: (3 -> 1 -> 5 -> null), (5 -> 9 -> 2 -> null)
//              Output: 8 -> 0 -> 8 -> null

//IMPORTANT POINTS IN APPROACH TAKEN:
// ~When we have heads of two list, add them to find their sum and corresponding carry
// ~The head of the sum for these list will be the sum%10
// ~Next node of this node will be the sum for the rest of the lists, hence recursive call can be used here

public class Question2_4 {

    //Method called by user which calls the overloaded method which does actual work
    public static Node addLists(Node head1, Node head2){
        return addLists(head1, head2, 0);
    }

    private static Node addLists(Node head1, Node head2, int carry) {
        //Calculate sum of both the heads and the carry. If heads data is null we take it as 0
        int sum = ((head1==null)?0:head1.data)+((head2==null)?0:head2.data)+carry;

        //If both the heads are null and the sum comes zero, we have reached the end of the addition and null is returned.
        if(head1==null && head2==null & sum==0) return null;

        //The head node of the summed linked list will be the units digit of the sum
        Node head = new Node(sum%10);

        //The next node of the summed linked list will be found by the recursive call with carry = sum/10
        Node nextNode = addLists((head1==null)?null:head1.next, (head2==null)?null:head2.next, sum/10);

        //Set next node of the head as the nextNode
        head.next = nextNode;

        //Return the head
        return head;
    }

    //Method to create a linked list from an int value
    public static Node createLinkedList(int n){
        //Base condition: If n==0, we have created the whole linked list and the last node will be null, so null value is returned
        if(n==0) return null;
        //Head node will be the units digit of the integer n i.e. n%10
        Node head = new Node(n%10);
        //Node next to head is found recursively by passing the value n/10, meaning the numbers units digit is extarcted and rest digits are to be extracted now
        Node nextnode = createLinkedList(n/10);
        //Set the next node of the head to nextNode
        head.next = nextnode;
        //return the head node
        return head;
    }

    public static void printListReverse(Node head){
        if(head==null)
            return;
        printListReverse(head.next);
        System.out.print(head.data+" ");
    }

    public static void main(String[] args) {
         Node num1 = createLinkedList(9000);
         Node num2 = createLinkedList(2000);
         Node sum = addLists(num1, num2);
         printListReverse(sum);
    }
}
