/*
Given a number N, check if a number is perfect or not. A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number.

Example :

Input:
N = 6
Output:
1 
Explanation:
Factors of 6 are 1, 2, 3 and 6.
Excluding 6 their sum is 6 which
is equal to N itself. So, it's a
Perfect Number.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

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
		    long n= sc.nextLong(); 
		    long sum=1;
		    for (long j=2; j<=Math.sqrt(n); j++) 
            { 
                if (n%j == 0) 
                { 
                    if (n/j == j) 
                        sum=sum+j; 
                    else 
                        sum=sum+j+(n/j); 
                } 
             } 
            if(n==sum)
                System.out.println("1"); 
            else
                System.out.println("0");
		}
	}
}
