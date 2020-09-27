/*
Given an integer N, how many structurally unique binary search trees are there that store values 1...N?

Constraints:
1<=T<=15
1<=N<=11

Example:
Input:
2
2
3
Output:
2
5

Explanation:

Testcase1:
for N = 2, there are 2 unique BSTs
     1               2  
      \            /
       2         1

Testcase2:
for N = 3, there are 5 possible BSTs
  1              3        3         2      1
    \           /        /           /    \      \
     3        2         1        1    3      2
    /       /                \                      \
   2      1               2                        3
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
        
        for(int i = 0; i < t; i++)
        {
            int n = Integer.parseInt(br.readLine());
            long res = 0;
            
            System.out.println(catalan(n));
        }
	}
	
    static long catalan(int n)
	{
	    long res = 0;
	    
	    if(n <= 1)
	        return 1;
	        
	    for (int i = 0; i < n; i++) 
	    { 
            res += catalan(i) * catalan(n - i - 1); 
        }    
	   
	   return res;
	}
}
