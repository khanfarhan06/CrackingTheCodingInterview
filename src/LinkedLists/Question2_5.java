package LinkedLists;

//QUESTION 2.5: Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
//DEFINITION:   Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
//EXAMPLE:      Input: A -> B -> C -> D -> E -> C [the same C as earlier]
//              Output: C

//TODO: Add approach details
import java.util.HashSet;
import java.util.Set;

public class Question2_5 {

    //TODO: Add comments on working of findLoopNodeWithExtraSpace method
    private static Node findLoopNodeWithExtraSpace(Node head) {
        Set<Node> found = new HashSet<>();
        Node ptr = head;
        while(ptr!=null){
            if(found.contains(ptr))
                return ptr;
            found.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }

    //TODO: Add comments on working of findLoopNodeWithoutExtraSpace method
    private static Node findLoopNodeWithoutExtraSpace(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast))
                break;
        }
        if(fast==null || fast.next==null)
            return null;
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        //creating an unsorted linked list with duplicate nodes
        Node head = new Node(5);
        Node second = new Node(4);
        head.next = second;
        Node third = new Node(3);
        second.next = third;
        Node fourth = new Node(2);
        third.next = fourth;
        Node fifth = new Node(1);
        fourth.next = fifth;
        fifth.next = third;

        Node loop = findLoopNodeWithoutExtraSpace(head);

        System.out.print(loop.data);
    }

}
