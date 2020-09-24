/*
Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2.
For the elements not present in A2, append them at last in sorted order. 
It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.

Constraints:
1 ≤ T ≤ 100
1 ≤ N,M  ≤ 106
1 ≤ A1[], A2[] <= 106

Example:
Input:
2
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3
8 4
2 6 7 5 2 6 8 4 
2 6 4 5
Output:
2 2 1 1 8 8 3 5 6 7 9
2 2 6 6 4 5 7 8

Explanation:
Testcase 1: After sorting the resulted output is 2 2 1 1 8 8 3 5 6 7 9.
Testcase 2: After sorting the resulted output is 2 2 6 6 4 5 7 8.
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
        int t = Integer.parseInt(br.readLine().trim()); 
        
	    while(t-- >0)
	    {
	        String st[] = br.readLine().trim().split(" ");
	        int n1 = Integer.parseInt(st[0]);
	        int n2 = Integer.parseInt(st[1]);
	        int arr1[] = new int[n1];
	        int arr2[] = new int[n2];
	        
	        String str1[] = br.readLine().trim().split(" ");
	        for(int i=0; i < n1; i++)
	            arr1[i] = Integer.parseInt(str1[i]);
	            
	        String str2[] = br.readLine().trim().split(" ");
	        for(int i=0; i < n2; i++)
	            arr2[i] = Integer.parseInt(str2[i]);
	            
	        Map<Integer, Integer> map = new TreeMap<>();
	        for(int i=0; i < n2 ; i++)
	        {
	            map.put(arr2[i],0);
	        }
	        
	        for(int i=0; i < n1 ; i++)
	        {
	            if(map.containsKey(arr1[i]))
	                map.put(arr1[i],map.get(arr1[i])+1); 
	            else if(map.containsKey(1000001+arr1[i]))
	                map.put(1000001+arr1[i],map.get(1000001+arr1[i])+1);
	            else
	                map.put(1000001+arr1[i],1);
	        }
	        
	        StringBuffer sb = new StringBuffer();
	        for(int i=0; i<n2; i++)
	        {
	            for(int j=0; j < map.get(arr2[i]); j++)
	                sb.append(arr2[i]+" ");
	        }
	        
	        
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
            {
                if(entry.getKey() >= 1000001)
                {
                    for(int i=0; i< entry.getValue(); i++)
                        sb.append((entry.getKey()-1000001)+" ");
                }
            }
            
	        System.out.println(sb);
	    }
	}
}
