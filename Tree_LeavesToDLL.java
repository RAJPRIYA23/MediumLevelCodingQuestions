/*
Given a Binary Tree of size N, extract all its leaf nodes to form a Doubly Link List strating from the left most leaf. Modify the original tree to make the DLL thus removing the leaf nodes from the tree. Consider the left and right pointers of the tree to be the previous and next pointer of the DLL respectively.

Example 1:

Input :
        1
      /   \
     2     3
    / \   / \
   4   5 6   7    

Output: 
Modified Tree :
        1
      /   \
     2     3

Doubly Link List :
4 <-> 5 <-> 6 <-> 7

Explanation:
The leaf nodes are modified to form the DLL 
in-place. Thus their links are removed from 
the tree.

Your Task:  
You dont need to read input or print anything. 
Complete the function convertToDLL() which takes root of the given tree as input parameter and returns the head of the doubly link list.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
    
            while(t-- > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                Tree g = new Tree();
                Node head = g.convertToDLL(root);
                printInorder(root);
                System.out.println();
                Node curr = head;
                Node last = head;
                while(curr!=null){
                    System.out.print(curr.data+" ");
                    last = curr;
                    curr = curr.right;
                }
                System.out.println();
                curr = last;
                while(curr!=null){
                    System.out.print(curr.data+" ");
                    curr = curr.left;
                }
                System.out.println();    
            }
    }
}// } Driver Code Ends


//User function Template for Java

/*
Node is as follows:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tree
{
    // return the head of the DLL and remove those node from the tree as well.
    
    Node head = new Node(-1);
    Node temp = head;
    
    public Node convertToDLL(Node root)
    {
        if(root == null)
            return null;
            
        if(head.right != null)
        {
            temp = head;
            head.right.left = null;
            head.right = null;
        }
        
        root = solve(root);
        
        head.right.left = null;
        return head.right; 
    }
    
    Node solve(Node root)
    {
        if(root == null)
            return null;
        
        if(root.left == null && root.right == null)
        {
            convert(root);
            root = null;
            return root;
        }
        
        root.left = solve(root.left);
        root.right = solve(root.right);
        
        return root;
        
    }
    
    void convert(Node curr)
    {
        temp.right = curr;
        curr.left = temp;
        temp = curr;
    }
}

