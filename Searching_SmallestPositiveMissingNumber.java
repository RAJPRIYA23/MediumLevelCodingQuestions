/*
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
Note: Expected solution in O(n) time using constant extra space.

Constraints:
1 <= T <= 100
1 <= N <= 106
-10^6 <= arr[i] <= 10^6

Example:
Input:
2
5
1 2 3 4 5
5
0 -10 1 3 -20
Output:
6
2

Explanation:
Testcase 1: Smallest positive missing number is 6.
Testcase 2: Smallest positive missing number is 2.
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
        int t = Integer.parseInt(br.readLine().trim()); 
        
	    while(t-- >0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        int arr[] = new int[n];
	        boolean[] present = new boolean[1000001]; 
	        String st[] = br.readLine().trim().split(" ");
	        for(int i=0; i< n; i++)
	        {
	            arr[i] = Integer.parseInt(st[i]);
	        }
	        
	       for(int i=0; i<n; i++)
	       {
	           if(arr[i]>0)
	               present[arr[i]]=true;
	       }
	       
	       int num=0;
	       
	       for(int i=1; i<1000001; i++)
	       {
	           if(present[i]==false)
	           {
	               num = i; 
	               break;
	           }
	       }
	       System.out.println(num);
	    }
	}
}
