/*
Given a number N, the task is to find the largest prime factor of that number.

Example :
Input:
N = 5
Output:
5
Explanation:
5 has 1 prime factor 
i.e 5 only.
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
	        long n=sc.nextLong();
	        int k=0;
	        int temp=(int)Math.sqrt(n);
	        long arr[]=new long[temp];
          
	        if(n%2==0)
	        {
	            arr[k]=2;
	            k++;
	        }
	        while (n%2==0) 
            { 
                n /= 2; 
            } 
            for(int j=3;j<=(int)Math.sqrt(n);j+=2) 
            { 
                if(n%j==0)
	            {
	                arr[k]=j;
	                k++;
	            }
                while (n%j==0) 
                { 
                    n /= j; 
                } 
            }
            if (n>2) 
                {
                    arr[k]=n;
                    k++;
                }
            System.out.println(arr[k-1]);
	    } 
	}
}
