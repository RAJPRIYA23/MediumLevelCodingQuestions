/*
Given a preorder traversal of a BST, print the leaf nodes of the tree without building the tree.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
5
890 325 290 530 965 
3
3 2 4

Output:
290 530 965
2 4
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;

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
            
            leafNodes(arr);
            
        }
	}
	
	static void leafNodes(int arr[])
	{
	    Stack<Integer> s = new Stack<Integer>(); 
	    StringBuffer sb = new StringBuffer();
	    
	    
	    for(int i = 0; i < arr.length-1; i++)
        {
            Boolean found = false;
            
            if(arr[i+1] < arr[i])
            {
                s.push(arr[i]);
            }
            
            else
            {
                while(!s.isEmpty() && arr[i+1] > s.peek())
                {
                    found = true;
                    s.pop();
                }
            }
            
            if(found)
                sb.append(arr[i]+" ");
        }
        
        sb.append(arr[arr.length-1]);
        System.out.println(sb);
	}
	
}
