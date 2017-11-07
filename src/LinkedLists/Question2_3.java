package LinkedLists;

//QUESTION 2.3: Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
//EXAMPLE:  Input:  the node ‘c’ from the linked list a->b->c->d->e
//          Result: nothing is returned, but the new linked list looks like a->b->d->e
//NOTE:     This method only works when the given node is any node in the linked list but the tail node

//IMPORTANT POINTS IN THE APPROACH TAKEN:
// ~ The current node cannot be deleted directly because we don have access to the previous node in order to delete it
//   So we take a different approach. Point to see here is that we can delete the next node because we have access to its previous node i.e the given node.
//   So work is done as follows
//      ~ Copy the data of the next node to this node
//      ~ Delete the next node
public class Question2_3 {

    private static boolean deleteNode(Node node){
        //If the node passed is null or it is the last node, then this deletion operation cannot be carried out
        //Hence, we return a false value showing that the deltion could not be performed
        if(node==null || node.next==null)
            return false;

        //Copy the data of the next node into the data of this node
        node.data = node.next.data;
        //Delete the next node
        node.next = node.next.next;
        //As deletion was performed, return a true value
        return true;
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

        deleteNode(third);

        printList(head);
    }

    private static void printList(Node head) {
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data);
            System.out.print((ptr.next!=null)?"->":"\n");
            ptr = ptr.next;
        }
    }
}
