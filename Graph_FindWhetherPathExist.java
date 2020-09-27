/*
Given a N X N matrix (M) filled with 1, 0, 2, 3. The task is to find whether there is a path possible from source to destination, while traversing through blank cells only. You can traverse up, down, right and left.

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Blank Wall.
Note: there is only single source and single destination.

Constraints:
1 <= T <= 20
1 <= N <= 20

Example:
Input:
2
4
3 0 0 0 0 3 3 0 0 1 0 3 0 2 3 3 
3
0 3 2 3 0 0 1 0 0

Output:
1
0

Explanation:
Testcase 1: The matrix for the above given input is:
3 0 0 0
0 3 3 0
0 1 0 3
0 2 3 3
From the matrix we can see that there exists a path from to reach destination 2 from source 1.
Testcase 2: The matrix for the above given input is:
0 3 2
3 0 0
1 0 0
From the matrix we can see that there does not exists any path to reach destination 2 from source 1.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

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
            int n = Integer.parseInt(br.readLine()); 
            
            int arr[][] = new int[n][n];
            Boolean visited[][] = new Boolean[n][n];

            int start_row = -1, start_col = -1;
            
            String str[] = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    arr[i][j] = Integer.parseInt(str[i*n+j]);
                    visited[i][j] = false;
                    if(arr[i][j] == 1)
                    {
                        start_row = i;
                        start_col = j;
                    }
                }
            }
            
            Boolean tf = dfs(arr, start_row, start_col, n, visited);
            
            if(tf)
                System.out.println(1);
            else
                System.out.println(0);
        }
	}
	
	static Boolean dfs(int arr[][], int row, int col, int n, Boolean visited[][])
    {
        
        if(row < 0 || row >= n || col < 0 || col >= n || visited[row][col]==true || arr[row][col] == 0 )
            return false;
    
        visited[row][col] = true;
    
        if(arr[row][col] == 2)
            return true;
    
        if(dfs(arr, row-1, col, n, visited) ||  dfs(arr, row, col-1, n, visited) || dfs(arr, row, col+1, n, visited) || dfs(arr, row+1, col, n, visited))
            return true;
       
        return false;     
    }
}
