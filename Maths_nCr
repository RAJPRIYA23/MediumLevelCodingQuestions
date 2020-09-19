/*
Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 10^9+7.

Example:

Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG 
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new
        InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        while(t-- >0)
        {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int r = Integer.parseInt(tk.nextToken());
            Comb c= new Comb();
            long result = c.ncr(n,r);
            System.out.println(result);
        }
	}
}

class Comb
{
    static HashMap<Integer, Long> list1 = new HashMap<Integer, Long>();
    public long ncr(int n, int r)
    {
        long res=0, p=1000000007l;
        if(n<r)
            return 0;
        else if(r==0 || r==n)
            return 1;
        else
        {
            Boolean key_exist=list1.containsKey(n*10000+r);
            
            if(key_exist)
            {
                res=list1.get(n*10000+r); 
            }
            else
            {
                res = ( ncr(n-1,r-1)%p + ncr(n-1,r)%p ) %p ;
                list1.put(n*10000+r,res);
            }
        }
        return res;
    }
}
