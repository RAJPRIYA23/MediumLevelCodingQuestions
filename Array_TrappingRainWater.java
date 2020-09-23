/*
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. 
Compute how much water can be trapped in between blocks after raining. Structure is like below:
| |
|_|

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.
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
	        int arr[] = new int[n];
	        int max_left[] = new int[n];
	        int max_right[] = new int[n];
	        int max=0;
	        long sum=0;
	        
	        StringTokenizer tk = new StringTokenizer(br.readLine());
	        for(int i = 0; i < n ; i++)
	        {
	            arr[i] = Integer.parseInt(tk.nextToken());
	        }
	   
	        max_left[0]=arr[0];
	        max_right[n-1]=arr[n-1];
	        
	        max=arr[0];
	        for(int i=1;i<n;i++)
	        {
	            if(arr[i]>max)
	                max=arr[i];
	            max_left[i]=max;
	        }
	       
	       
	        max=arr[n-1];
	        for(int i=n-2;i>=0;i--)
	        {
	            if(arr[i]>max)
	                max=arr[i];
	            max_right[i]=max;
	        }
	        
	        for(int i=0;i<n;i++)
	        {
	            if(max_left[i]>max_right[i])
	                sum=sum+(max_right[i]-arr[i]);
	            else
	                sum=sum+(max_left[i]-arr[i]);
	        }
	        
	        System.out.println(sum);
	    }
	}
}
