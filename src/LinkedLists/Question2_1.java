package LinkedLists;

//QUESTION 2.1: Write code to remove duplicate nodes from an unsorted linked list
//EXAMPLE: Given Linked List: 5 -> 1 -> 5 -> 3 -> 1 -> null
//         New Linked List:   5 -> 1 -> 3 -> null

//IMPORTANT POINTS IN APPROACH TAKEN:
// ~ A HashSet to keep found values found
// ~ Check if current node is already in the HashSet
//      - if already present then delete the node
//      - otherwise all newly found value to the HashSet

import java.util.HashSet;
import java.util.Set;

public class Question2_1 {

    //Method to remove all duplicates in an unsorted linked list
    static void removeDuplicates(Node head){
        Set<Integer> found = new HashSet<Integer>();//Keeps a set of values of all nodes that we have encountered till now
        Node ptr = head; //Pointer used to traverse the linked ist
        Node last = null; //Pointer used to keep track of the last traversed node, needed to delete the current node

        //Traverse the whole linked list
        while(ptr!=null){
            //If this node has duplicate value
            if(found.contains(ptr.data)){
                last.next = ptr.next;   //Delete the current node
                ptr = last.next;        //Change current pointer to the next node for next iteration
            }
            //Otherwise if a value is found found
            else{
                found.add(ptr.data);    //Add the newly found value to the set of found values
                last = ptr;             //Update the last pointer to point to the current node for next iteration
                ptr = ptr.next;         //Update the current pointer to point to next node for the next iteration
            }
        }
    }

    static void removeDuplicatesWithoutBuffer(Node head){
        Node pivot = head;
        while(pivot.next!=null){
            Node previous = pivot;
            Node ptr = pivot.next;
            while(ptr!=null){
                if(ptr.data==pivot.data){
                    previous.next = ptr.next;
                    ptr = ptr.next;
                }else{
                    previous = ptr;
                    ptr = ptr.next;
                }
            }
            pivot = pivot.next;
        }
    }

    //Method to print all nodes of the linked list
    private static void printList(Node head) {
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data);
            System.out.print((ptr.next!=null)?"->":"\n");
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        //Create an unsorted linked list with duplicate nodes
        Node head = new Node(5);
        Node second = new Node(1);
        head.next = second;
        Node third = new Node(5);
        second.next = third;
        Node fourth = new Node(3);
        third.next = fourth;
        Node fifth = new Node(1);
        fifth.next = null;

        removeDuplicatesWithoutBuffer(head);

        printList(head);
    }

}
