/*
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
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
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
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
        
                  // Create the right child for the curr node
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
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Info 
{ 
    int sz = 0; 
    int min = Integer.MAX_VALUE; 
    int max = Integer.MIN_VALUE;
    int ans = 0; 
    Boolean isBST = true;
    
    Info(int sz, int min, int max, int ans, Boolean isBST)
    {
        this.sz = sz;
        this.min = min;
        this.max = max; 
        this.ans = ans;
        this.isBST = isBST; 
    }
}

class Solution
{
    static int largestBst(Node root)
    {
        Info res = result(root);
        return res.ans;
    }
    
    static Info result(Node root) 
    { 
        if(root == null) 
        {
            Info ret = new Info(0,Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
            return ret;
        }
        
        if(root.left == null && root.right == null) 
        {
            Info ret = new Info(1,root.data,root.data,1,true);
            return ret;
        }
  
    
        Info l = result(root.left); 
        Info r = result(root.right); 
  
    
        Info ret = new Info(0,Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        ret.sz = 1 + l.sz + r.sz; 

        
        if(l.isBST && r.isBST && 
        l.max < root.data  && r.min > root.data) 
        { 
            ret.min = Math.min(l.min,Math.min(r.min, root.data)); 
            ret.max = Math.max(r.max,Math.max(l.max, root.data)); 
  
            ret.ans = ret.sz;
            ret.isBST = true; 
  
            return ret; 
        } 
  
        ret.ans = Math.max(l.ans, r.ans); 
        ret.isBST = false; 
  
        return ret; 
    }
    
}
