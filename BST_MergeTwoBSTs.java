/*
Given two BST, Return elements of both BSTs in sorted form.

Example 1:

Input:
BST1:
       5
     /   \
    3     6
   / \
  2   4  
BST2:
        2
      /   \
     1     3
            \
             7
            /
           6
BST2 = 2 1 3 N N N 7 6
Output: 1 2 2 3 3 4 5 6 6 7
Explanation: After merging and sorting the
two BST we get 1 2 2 3 3 4 5 6 6 7

Your Task:
You don't need to read input or print anything. Your task is to complete the function merge() which takes roots of both the BSTs as its input and returns an array of integers
denoting the node values of both the BSTs in a sorted order.
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
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
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

class Solution
{
    // Return a integer of integers having all the nodes in both the BSTs in a sorted order.
    
    Node newnode = new Node(-1);
    Node temp = newnode;  

    public List<Integer> merge(Node root1, Node root2)
    {
        if(newnode.right != null)
        {
            newnode.right = null;
            temp = newnode;
        }   
        
        inorder(root1);
        
        Node temp1 = newnode.right;
        newnode.right =null;
        temp = newnode;
        inorder(root2);
 
        Node temp2 = newnode.right;
        
        List<Integer> arr = new ArrayList<>();
        
        while(temp1 != null && temp2 != null)
        {
            int num1 = temp1.data;
            int num2 = temp2.data;
            
            if(num1 <= num2)
            {
                arr.add(temp1.data);
                temp1 = temp1.right;
            }
            
            else 
            {
                arr.add(temp2.data);
                temp2 = temp2.right;
            }
            
        }
        
        while(temp1 != null)
        {
            arr.add(temp1.data);
            temp1 = temp1.right;
        }
        
        while(temp2 != null)
        {
            arr.add(temp2.data);
            temp2 = temp2.right;
        }
        
        return arr;
    }
    

    void inorder(Node root)
    {
        if(root == null)
            return;
            
        inorder(root.left);
        
        temp.right = root;
        temp = root;
        
        inorder(root.right);

    }
    
}
