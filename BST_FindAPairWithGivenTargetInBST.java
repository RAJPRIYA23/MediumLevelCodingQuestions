/*
Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 

Example 1:

Input:
        2
      /   \
     1     3
sum = 5
Output: 1

Your Task:
You don't need to read input or print anything. Your task is to complete the function isPairPresent() that takes a root node and a target value as a parameter and returns 1 
if there's a pair of Nodes in the BST with values summing up to the target sum, else returns 0. 
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> inorder = new ArrayList<Integer>();
        
    void inOrder(Node root)
    {
        if(root != null)
        {
            inOrder(root.left);
            inorder.add(root.data);
            inOrder(root.right);
        }
    }
    
    public int isPairPresent(Node root, int target)
    {
        inorder.clear();
        inOrder(root);
        
        int start = 0, end = inorder.size()-1;
  
        int res = 0;
        while(start <= end)
        {
            
            if(target < inorder.get(start) + inorder.get(end))
            {
               end--;
            }
            
            else if(target > inorder.get(start) + inorder.get(end))
            {
                start++;
            }
            
            else
            {
                res = 1;
                break;
            }
        }
        
        return res;
        
    }
}
