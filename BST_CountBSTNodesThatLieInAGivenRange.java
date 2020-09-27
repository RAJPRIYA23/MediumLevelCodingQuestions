/*
Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.

The values smaller than root go to the left side
The values greater and equal to the root go to the right side
Example 1:

Input:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the
range

Your Task:
This is a function problem. You don't have to take input. You are required to complete the function getCountOfNode() that takes root,
l ,h as parameters and returns the count.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    Node root=null;
		    int sizeOfArray=sc.nextInt();
		    int arr[]=new int[sizeOfArray];
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        int x=sc.nextInt();
		        arr[i]=x;
		    }
		   
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        root=Geeks.newNode(root,arr[i]);
		    }
		    int l,h;
		    l=sc.nextInt();
		    h=sc.nextInt();
		    System.out.println(Geeks.getCountOfNode(root,l,h));
		
		}
	}
}


class Geeks
{
    public static Node createNewNode(int value)
    {
        Node temp=new Node(value);
        
        return temp;
    }
    static public Node newNode(Node root,int data)
    {
        if(root==null)
        root=createNewNode(data);
        else if(data<root.data)
        root.left=newNode(root.left,data);
        else
        root.right=newNode(root.right,data);
        
        return root;
    }
  
    
 // } Driver Code Ends


// A Binary Search Tree node
/*

class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

*/
//Complete this function


public static int getCountOfNode(Node root,int low, int high)
{
    if(root == null)
        return 0;
        
    if(low <= root.data && root.data <= high)
    {
        return 1 + getCountOfNode(root.left, low, high) +
        getCountOfNode(root.right,low,high);  
    }
    
    else if(low > root.data)
        return getCountOfNode(root.right,low,high);  
        
    else
        return getCountOfNode(root.left,low,high);  
}


// { Driver Code Starts.

    
}
  // } Driver Code Ends
