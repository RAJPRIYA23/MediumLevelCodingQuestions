/*
Given an array arr of size n, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.

Constraints:
1 <= T<= 100
1 <= n <= 103
1 <= arr[i] <= 103

Example:
Input:
3
5
40 30 35 80 100
8
40 30 32 35 80 90 100 120
8
7  9 6 1 4 2 3 40

Output:
1
1
0
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
            
            Boolean check = checkBst(arr);
            
            if(check)
                System.out.println(1);
            else
                System.out.println(0);
                
        }
	}
	
	static Boolean checkBst(int arr[])
	{
	    Stack<Integer> s = new Stack<Integer>(); 
	    
	    Boolean tf = true;
	    
	    s.push(arr[0]);
	    int temp = -1;
	    
	    for(int i = 1; i < arr.length; i++)
        {
            if(temp > arr[i])
            {
                tf = false;
                break;
            }
            if(arr[i] < arr[i-1])
            {
                s.push(arr[i]);
            }
            
            else
            {
                //int j = i;
                while(!s.isEmpty() && arr[i] > s.peek())
                {
                    temp = s.pop();
                    //j--;
                }
                
            }
        }
        
        return tf;
	}
	
	
}
