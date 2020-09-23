/*
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array.
Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.

Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N
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
        
	    while(t-- >0)
	    {
	        int n = Integer.parseInt(br.readLine());
	        int arr[]=new int[n+1];
	        int temp=0, rep=0, miss=0;
	        
	        StringTokenizer tk = new StringTokenizer(br.readLine());
	        
	        for(int i=1;i<=n;i++)
	        {
	            temp=Integer.parseInt(tk.nextToken());
	            if(arr[temp]!=temp)
	            {
	                arr[temp]=temp; 
	            }
	            else
	                rep=temp;
	        }
	        for(int i=1;i<=n;i++)
	        {
	            if(arr[i]==0)
	            {
	              miss=i;
	              break;
	            }
	        }
	        System.out.println(rep+" "+miss);
	    }
	}
}
