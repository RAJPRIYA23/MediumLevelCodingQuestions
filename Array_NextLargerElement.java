/*
Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
If no such element exists, output -1 

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1018
Example:
Input
2
4
1 3 2 4
4
4 3 2 1
Output
3 4 4 -1
-1 -1 -1 -1

Explanation:
Testcase1: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? since it doesn't exist hence -1.
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
	        StringBuffer sb = new StringBuffer();
	        int n = Integer.parseInt(br.readLine());
	        long arr[] = new long[n];
            
	        String str[] = br.readLine().trim().split(" ");
	        
	        for(int i = 0 ;  i < n ; i++)
	        {
	            arr[i] = Long.parseLong(str[i]);
	        }  
	            
	       for(int i = 0 ;  i < n-1 ; i++)
	       {
	           Boolean inside = false;
	           for(int j = i+1 ;  j < n ; j++)
	           {
	                if(arr[j] > arr[i])
	                {
	                    sb.append(arr[j]+" ");
	                    inside = true;
	                    break;
	                }
	           }
	           if(!inside)
	                sb.append(-1 +" ");
	       }
	       sb.append(-1 +" ");
	       
	       System.out.println(sb);
	    }
	}
}
