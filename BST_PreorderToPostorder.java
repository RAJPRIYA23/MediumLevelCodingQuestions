/*
Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.

Constraints:
1 <= T <= 100
1 <= N <= 103
1 <= arr[i] <= 104

Example:
Input:
3
5
40 30 35 80 100
8
40 30 32 35 80 90 100 120

Output:
35 30 100 80 40
35 32 30 120 100 90 80 40
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node left = null;
    Node right = null;
    
    Node(int data)
    {
        this.data = data;
    }
}

class GFG 
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader
		(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            
            String str[] = br.readLine().trim().split(" ");
            
            for(int i = 0; i < n; i++)
            {
                arr[i] = Integer.parseInt(str[i]);
            }
            
            Node root = null;
            
            for(int i = 0; i < arr.length ; i++)
            {
                root = construct(root, arr[i]);
            }
            
            postOrder(root);
            
            System.out.println();
        }
	}
	
	static Node construct(Node root, int num)
    {
        if(root == null)
        {
            Node temp = new Node(num);
            return temp;
        }
        
        if(num < root.data)
        {
            root.left = construct(root.left, num);
        }
        
        else
        {
            root.right = construct(root.right, num);
        }
        
        return root;
    }
    
    static void postOrder(Node root)
	{
	    if(root != null)
	    {
	        postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
	    }
	}
    
}
