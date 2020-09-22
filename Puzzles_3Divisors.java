/*
Given a value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Input:
The first line contains integer T, denoting number of test cases. Then T test cases follow. The only line of each test case contains an integer N.

Constraints :
1 <= T <= 103
1 <= N <= 1012

Example:
Input :
3
6
10
30
Output :
1
2
3
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader
		(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        Map<Long, Integer> list1 = new TreeMap<Long, Integer>();
        Map<Integer, Long> list2 = new TreeMap<Integer, Long>();
        for(int i=0;i<t;i++)
	    {
	        list1.put(Long.parseLong(br.readLine()),i);
	    }
	    long init_num=2;
	    long sum=0,count=0;
	    for (Map.Entry<Long, Integer> entry : list1.entrySet()) 
        { 
	        long n=entry.getKey();
	        for(long k=init_num;k<=(long)Math.sqrt(n);k++)
	        {
	            long temp=(long)Math.sqrt(k);
	            if(k%2==0 && k!=2) 
                { 
                    continue;
                } 
                else
                {
                    long j;
                    for(j=3;j<=temp;j+=2) 
                    { 
                        if(k%j==0) 
                        { 
                        break;
                        } 
                    }
                    if(j>temp)
                    {
                        count=count+1;
                        if(((long)Math.floor((Math.pow(k,2))))<= n)
                        {
                            sum = sum + 1;
                        }
                    }
                }
	        }
	        init_num=(long)Math.sqrt(n)+1;
	        list2.put(entry.getValue(),sum);
	    }
	    for (Map.Entry<Integer, Long> entry : list2.entrySet()) 
      {
            System.out.println(entry.getValue());
      }
	}
}
