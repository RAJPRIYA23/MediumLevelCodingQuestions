/*
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
Example:
A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE 1: If there is a tie, then compare with segment's length and return segment which has maximum length.
NOTE 2: If there is still a tie, then return the segment with minimum starting index.
Example 1:
Input:
N = 3
A[] = {1, 2, 3}
Output: 1 2 3
Explanation: In the given array every
element is non-negative.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = 
		new BufferedReader (new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine().trim());
		while(t-- > 0)
		{
		    int n= Integer.parseInt(br.readLine().trim());
		
		    int arr[]=new int[n];
		    int sum[]=new int[n];
		    int min[]=new int[n];
		    int max[]=new int[n];
		    int max_ind[]=new int[n];
		    int min_ind[]=new int[n];
		    
		    Boolean mini=false;
		    int cnt=0,max_sum=0,max_cnt=0;
		    int curr=0,last=0,cn=0;
		    
		    StringTokenizer tk = new StringTokenizer(br.readLine());
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=Integer.parseInt(tk.nextToken());
		    }
		    
		    int temp=0; 
		    
		    for(int i=0;i<n;i++)
		    {
		        if(arr[i]>=0)
		        {
		            temp=i;
		            break;
		        }
		    }
		    
		    min[0]=temp;
		    
		    for(int i=temp;i<n;i++)
		    {
		        if(i>0)
		        {
		            curr=arr[i];
		            last=arr[i-1];
		        }
		        
		        if(curr >=0 && last< 0 && i!=temp)
		        {
		            cnt++;
		        }
		            
		        if(arr[i]>=0)
		        {
		            sum[cnt]=sum[cnt]+arr[i];
		            max[cnt]=i;
		            if(mini==true)
		            {   
		                min[cnt]=i;
		                mini=false;
		            }
		        }
		        
		        else
		            mini=true;
		    }
		    
		    for(int i=0;i<=cnt;i++)
		    {
		        if(sum[i]>=max_sum)
		        {
		            max_sum=sum[i];
		        }
		    }
		    
		    for(int i=0;i<=cnt;i++)
		    {
		        if(max_sum==sum[i])
		        {
		            if((max[i]-min[i])>=max_cnt)
		            {
		                max_cnt=max[i]-min[i];
		                max_ind[cn]=max[i];
		                min_ind[cn]=min[i];
		                cn++;
		            }
		        }
		    }
		    
		    int i;
		    for(i=0;i<cn;i++)
		    {
		        if((max_ind[i]-min_ind[i])==max_cnt)
		            break;
		    }
		    
		    for(int j=min_ind[i];j<=max_ind[i];j++)
		    {
		        System.out.print(arr[j]+" ");
		    }
		    
		    System.out.println();
		}
	}
}
