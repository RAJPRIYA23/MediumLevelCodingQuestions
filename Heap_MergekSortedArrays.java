/*
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.

Example:
Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends

//-------------------------------------------------------------------------------------

class Node 
{ 
    int elem; 
    int i, j; 

    public Node(int elem, int i, int j) 
    { 
        this.elem = elem; 
        this.i = i; 
        this.j = j; 
    }
}

class NodeComparator implements Comparator<Node>
{
    public int compare(Node n1, Node n2) 
    { 
        if(n1.elem < n2.elem) 
            return -1;
            
        else if(n1.elem > n2.elem)
            return 1;
            
        return 0;
    }
} 
        
/*Complete the function below*/
class Solution
{
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) 
    {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        PriorityQueue<Node> q = new PriorityQueue<>(new NodeComparator()); 
            
        for(int i = 0; i < k; i++)
        {
            q.add(new Node(arr[i][0], i, 0)); 
        }
        
        for(int i = k; i < k*k; i++) 
        { 
            Node temp = q.poll();
            arrlist.add(temp.elem);
            if(temp.j != k-1)
                q.add(new Node(arr[temp.i][(temp.j)+1], 
                temp.i, (temp.j)+1));
            else
                i--;
        }
        
        Iterator<Node> itr = q.iterator(); 
  
        while(itr.hasNext())  
        {
            Node temp = q.poll();
            arrlist.add(temp.elem);
        }

        return arrlist;
        
    }
}
