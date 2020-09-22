/*
Given an array Arr[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of Arr[i] <= Arr[j].

Example:

Input:
N = 9
Arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 6
Explanation: In the given array Arr[1] <
Arr[7]  satisfying the required condition
(Arr[i] <= Arr[j])  thus giving the
maximum difference of j - i which is
6(7-1).
Constraints:
1 ≤ N ≤ 10^3
0 ≤ Arr[i] ≤ 10^18
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.lang.*;
import java.io.*;

class GFG 
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new
        InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine());
        while(t-- >0)
	    {
	        int n = Integer.parseInt(br.readLine());
	        long arr[]=new long[n];
	        long min[]=new long[n];
	        long max[]=new long[n];
	        long min_val=0,max_val=0;
	        int dist=-1;
	        
	        StringTokenizer tk = new StringTokenizer(br.readLine());
	        
	        for(int i=0;i<n;i++)
	        {
	            arr[i]=Long.parseLong(tk.nextToken());
	        }
	        
	        min_val=arr[0];
	        max_val=arr[n-1];
	        
	        for(int i=0;i<n;i++)
	        {
	            if(arr[i]<=min_val)
	            {
	                min_val=arr[i];
	            }
	            min[i]=min_val;
	        }
	        
	        for(int i=n-1;i>=0;i--)
	        {
	            if(arr[i]>=max_val)
	            {
	                max_val=arr[i];
	            }
	            max[i]=max_val;
	        }
	        
	        int i=0,j=0;
	        while(i<n && j<n)
            {
                if(min[i]<=max[j])
                {
                    if(j-i > dist)
                        dist=j-i;
                    j++;
                }
                else
                    i++;
            }	        
	        System.out.println(dist);
	    }	        
	}
}
