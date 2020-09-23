/*
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
3
7
100 180 260 310 40 535 695
4
100 50 30 20
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
No Profit
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
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
	        int last_num=-1,start=0,end=0;
	        
	        StringTokenizer tk = new StringTokenizer(br.readLine());
	        for(int i = 0; i < n ; i++)
	        {
	            arr[i] = Integer.parseInt(tk.nextToken());
	        }
	        
	        last_num=arr[0];
	        for(int i = 1; i < n ; i++)
	        {
	            if(arr[i]>last_num)
	            {
	                end=i;
	            }
	            else
	            {
	                if(i!=1 && arr[end]==last_num)
	                    System.out.print("("+start+" "+end+") ");
	                start=i;
	            }
	            last_num=arr[i];
	        }
	        if(start<end) 
	            System.out.print("("+start+" "+end+") ");
	        else if(end==0)
	            System.out.print("No Profit");
	        System.out.println();   
	    }
	}
}
