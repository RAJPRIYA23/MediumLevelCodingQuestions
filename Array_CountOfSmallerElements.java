/*
Given an sorted array A of size N. Find number of elements which are less than or equal to given element X.

Constraints:
1 <= T <= 105
1 <= N <= 105
1 <= Ai <= 105
0 <= X <= 105

Example:
Input:
2
6
1 2 4 5 8 10
9
7
1 2 2 2 5 7 9
2
Output:
5
4
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static void main (String[] args) 
	{
		Scanner sc= new Scanner(System.in);  
	    int t= sc.nextInt();  
	    for(int i=1;i<=t;i++)
	    {
	        int n= sc.nextInt(); 
	        int arr[]=new int[n];
	        int cnt=0;
	        
            for(int j=0;j<n;j++)
            {
                arr[j]= sc.nextInt(); 
            }
            int x= sc.nextInt(); 
            
            for(int j=0;j<n;j++)
            {
                if(arr[j]<=x)
                cnt++;
            }
            System.out.println(cnt);
	    }
	}
}
