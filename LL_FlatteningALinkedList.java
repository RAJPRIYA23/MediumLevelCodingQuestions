/*
Given a Linked List of size N, where every node represents a linked list and contains two pointers of its type:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.

Note: The flattened list will be printed using the bottom pointer instead of next pointer.

Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.

Note: | represents the bottom pointer.
Your Task:
You need to complete the function flatten() that takes head of the list as parameter and returns the root of flattened list. The printing is done by the driver code.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
        if(root.next == null)
            return root;
            
        Node newnode = new Node(-1);
        Node newnode2 = new Node(-1);
        Node temp = newnode;
        
        Node horzontl1 = root;
        Node horzontl2 = root.next;
        
        Node firstList = horzontl1;
        Node secondList = horzontl2;
        
        while(horzontl2 != null)
        {
            while(firstList != null && secondList != null)
            {
                if(firstList.data < secondList.data)
                {
                    temp.bottom = firstList;
                    firstList = firstList.bottom;
                }
                else
                {
                    temp.bottom = secondList;
                    secondList = secondList.bottom;
                }
                
                temp = temp.bottom;   
            }
            
            while(firstList != null)
            {
                temp.bottom = firstList;
                firstList = firstList.bottom;
                temp = temp.bottom; 
            }
            
            while(secondList != null)
            {
                temp.bottom = secondList;
                secondList = secondList.bottom;
                temp = temp.bottom; 
            }
            
            temp = newnode;
            horzontl1 = newnode.bottom;
            newnode2.bottom = newnode.bottom;
            newnode.bottom = null;
            horzontl2 = horzontl2.next;
            
            firstList = horzontl1;
            secondList = horzontl2;
        }
        
	    return newnode2.bottom;
    }
}
