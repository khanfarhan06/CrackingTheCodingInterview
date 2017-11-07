package LinkedLists;

//QUESTION 2.2: Implement an algorithm to find the nth to last element of a singly linked list.
//EXAMPLE: Given Linked List: 5 -> 4-> 3 -> 2 -> 1 -> null
//         Value of N:        2
//OUTPUT:  2th node from last: 2

//IMPORTANT POINTS IN APPROACH TAKEN:
// ~Take two pointers - ahead and follow
// ~Initialise both by the head pointer
// ~Move the ahead pointer n-1 times forward in the linked list
// ~Now the distance between both pointers is n, i.e. follow pointer is n - 1 places behind the ahead pointer
// ~Now move both pointers simultaneously until the ahead pointer becomes the last node i.e. ahead.next = null
// ~The follow pointer being n-1 behind the ahead pointer is the nth node from last in the linked list

public class Question2_2 {

    public static Node nthFromLast(Node head, int n) {
        //For invalid values of n (i.e. less than 1) return null to show that no such node could be found
        if(n<1)
            throw new UnsupportedOperationException();
        //Initialize both pointers with the head
        Node ahead = head;
        Node follow = head;

        //move the ahead pointer forward n-1 times
        for(int i=1; i<n; i++){
            //If ahead pointer becomes null, it means the list contains less than n nodes, so return null to show that no such node could be found
            if(ahead == null)
                return null;
            ahead = ahead.next;
        }

        //Move both pointers forward simultaneously untill ahead pointer is the last node i.e ahead.next = null
        while(ahead.next!=null){
            ahead = ahead.next;
            follow = follow.next;
        }

        //follow pointer is n-1 nodes behind the last node, i.e it is the nth node from last, so return it
        return follow;
    }

    public static void main(String[] args) {
        //Create a linked list
        Node head = new Node(5);
        Node second = new Node(4);
        head.next = second;
        Node third = new Node(3);
        second.next = third;
        Node fourth = new Node(2);
        third.next = fourth;
        Node fifth = new Node(1);
        fourth.next = fifth;
        fifth.next = null;

        Node nth = nthFromLast(head, 5);

        System.out.println(nth.data);
    }
}
