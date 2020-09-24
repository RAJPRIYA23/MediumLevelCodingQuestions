/*
Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

Constraints:
1<=T<=100
1<=N<=100
1<=K<=N

Example:
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56
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
            String str1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str1[0]);
            int k = Integer.parseInt(str1[1]);
            
            int arr[] = new int[n];
            String str2[] = br.readLine().trim().split(" ");
             
            for(int i = 0; i < n; i++)
            {
                arr[i] = Integer.parseInt(str2[i]);
            }
            
            
            PriorityQueue<Integer> q = new PriorityQueue<>(); 
            
            for(int i = 0; i < k; i++) 
            { 
                q.add(arr[i]); 
            } 
            
            int index = 0;
            
            if(k != n)
            {
                q.add(arr[k]);
            
                for(int i = k+1; i < n; i++)  
                { 
                    arr[index] = q.poll();
                    index++;
                    q.add(arr[i]); 
                }
            
            }
                
            Iterator<Integer> itr = q.iterator(); 
  
            while(itr.hasNext())  
            { 
                arr[index] = q.poll();
                index++;
            }
                
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < n; i++)
            {
                sb.append(arr[i]+" ");
            }
            
            System.out.println(sb);
        }
	}
}
