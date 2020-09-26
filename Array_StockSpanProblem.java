/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the
current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 200
1 ≤ C[i] ≤ 800

Example:
Input:
2
7
100 80 60 70 60 75 85
6
10 4 5 90 120 80

Output:
1 1 1 2 1 4 6
1 1 2 4 5 1
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
	        int arr[] = new int[n];

	        String str[] = br.readLine().trim().split(" ");
	        
	        for(int i = 0 ;  i < n ; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
	            
	            if(i == 0)
	            {
	                sb.append(1+" ");
	            }
	            
	            else if(arr[i] < arr[i-1])
	            {
	                sb.append(1+" ");
	            }
	            
	            else
	            {
	                int count = 1;
	                int j = i;
	                while(arr[i] >= arr[j-1])
	                {
	                    count++;
	                    j--;
	                    if(j == 0)
	                        break;
	                }
	                sb.append(count+" ");
	            }
	        }
	        
	        System.out.println(sb);
	    }
	}
}
