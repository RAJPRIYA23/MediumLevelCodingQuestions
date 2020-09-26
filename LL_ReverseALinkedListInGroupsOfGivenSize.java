/*
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5
Example 2:

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4
Your Task:
The task is to complete the function reverse() which should reverse the linked list in group of size k and return the head of the modified linked list.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            GfG gfg = new GfG();
            Node res = gfg.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class GfG
{
    public static Node reverse(Node node, int k)
    {
        if(k==1)
            return node;
          
        Boolean first = true;  
        Node temp = node, next = node , head = node, cycleptr = head;
        int count=0;
        
        while(temp != null)
        {
            count++;
            if(count == k)
            {
                next = temp.next;
                temp.next = null;
                
                Node temp2 = head;
                head = reverseList(head);
                
                temp2.next = next;
                
                if(first)
                {
                    node = head;
                    first = false;
                }
                
                 
                else
                {
                    cycleptr.next = head;    
                }
               
                
                head = next;
                temp = temp2;
                
                
                cycleptr = temp2;
                count = 0;
            }
            temp = temp.next;
        }
        
        if(count!=0)
        {
            temp = cycleptr.next;
            head = reverseList(temp);
            cycleptr.next = head;
        }
        
       return node;
    }
    
    static Node reverseList(Node head)
    {
        Node curr=head, prev=null, next;
        
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

