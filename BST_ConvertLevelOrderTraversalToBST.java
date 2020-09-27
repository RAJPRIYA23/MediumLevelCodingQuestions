/*
Given an array of size N containing level order traversal of a BST. The task is to complete the function constructBst(), that construct the BST (Binary Search Tree) from its given level order traversal.

Example 1:

Input:
N = 9
BST[] = {7,4,12,3,6,8,1,5,10}
Output: 7 4 3 1 6 5 12 8 10
Explanation: After constructing BST, the
preorder traversal of BST is
7 4 3 1 6 5 12 8 10.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java

/*
The structure of the Node is as follows:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class GFG
{
    
    public Node constructBST(int[] arr)
    {
        Node root = new Node(arr[0]);
        
        for(int i = 1; i < arr.length ; i++)
        {
            root = construct(root, arr[i]);
        }
        return root;
    }
    
    Node construct(Node root, int num)
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
    
}
