/*
Given two polynomial numbers represented by a linked list. The task is to complete the  function addPolynomial() that adds these lists meaning adds the coefficients
who have same variable powers.

Example:
Input:
LinkedList1:  (1,x2) 
LinkedList2:  (1,x3)
Output:
1x^3 + 1x^2
Explanation: Since, x2 and x3 both have
different powers as 2 and 3. So, their
coefficient can't be added up.

Your Task:
The task is to complete the function addPolynomial() which should add the polynomial with same powers return the required polynomial in decreasing order of the power 
in the form of a linked list.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;
import java.io.*;
class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}
class GFG2
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node start1=null,cur1=null,start2=null,cur2=null;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start1==null)
                {
                    start1=ptr;
                    cur1=ptr;
                }
                else{
                    cur1.next=ptr;
                    cur1=ptr;
                }
            }
            n=sc.nextInt();
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start2==null)
                {
                    start2=ptr;
                    cur2=ptr;
                }
                else{
                    cur2.next=ptr;
                    cur2=ptr;
                }
            }
            GFG obj=new GFG();
            Node sum = obj.addPolynomial(start1,start2);
            for(Node ptr=sum ; ptr != null; ptr=ptr.next  )
            {
                // printing polynomial
                System.out.print(ptr.coeff + "x^" + ptr.pow);
                if(ptr.next != null)
                System.out.print(" + ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

//Print the polynomial formed by adding both LL in the function itself.
class GFG
{
    public static Node addPolynomial(Node p1,Node p2)
    {
        Node node = new Node(0,0);
        Node temp = node;
        Node curr1 = p1, curr2 = p2;
        
        while(curr1 != null && curr2 != null)
        {
            if(curr1.pow == curr2.pow)
            {
                curr1.coeff = curr1.coeff + curr2.coeff;
                temp.next = curr1;
                temp = curr1;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            
            else 
            {
                if(curr1.pow > curr2.pow)
                {
                    temp.next = curr1;
                    temp = curr1;
                    curr1 = curr1.next;
                }
                
                else
                {
                    temp.next = curr2;
                    temp = curr2;
                    curr2 = curr2.next;
                }
            }
        }
        
        while(curr1 != null)
        {
            temp.next = curr1;
            temp = curr1;
            curr1 = curr1.next;
        }
    
        while(curr2 != null)
        {
            temp.next = curr2;
            temp = curr2;
            curr2 = curr2.next;
        }
        
        node = node.next;   
        return node;
    }
    
}
