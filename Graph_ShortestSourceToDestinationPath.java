/*
Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and if there is one path,
print the minimum no of steps needed to reach it, else print -1 if the destination is not reachable. You may move in only four direction ie up, down, left and right.
The path can only be created out of a cell if its value is 1.

Constraints:
1<=T<=100
1<=n,m<=20

Example:
Input:
2
3 4
1 0 0 0 1 1 0 1 0 1 1 1
2 3
3 4
1 1 1 1 0 0 0 1 0 0 0 1
0 3
Output:
5
3
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;

class Cell 
{ 
    int x, y; 
    int dis; 
  
    Cell(int x, int y, int dis) 
    { 
        this.x = x; 
        this.y = y; 
        this.dis = dis; 
    } 
}

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
            int m = Integer.parseInt(str1[1]);
            
            int arr[][] = new int[n][m];
            Boolean visited[][] = new Boolean[n][m];

            int start_row = 0, start_col = 0;
            
            String str2[] = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    arr[i][j] = Integer.parseInt(str2[i*m+j]);
                    visited[i][j] = false;
                }
            }
            
            String str3[] = br.readLine().trim().split(" ");
            int desx = Integer.parseInt(str3[0]);
            int desy = Integer.parseInt(str3[1]);
            
            int posbleDirX[] = {0, 1, 0, -1}; 
            int posbleDirY[] = {1, 0, -1, 0}; 

            Queue<Cell> q = new LinkedList<>();
	    
	        q.add(new Cell(0, 0, 0));
	        visited[0][0] = true; 
	        
	        if(arr[0][0] == 0)
	        {
	            System.out.println(-1);
	            continue;    
	        }
	        
	        Cell c; 
            int x, y, res = -1;

            while(!q.isEmpty()) 
            {
                c = q.remove();
 
                if(c.x == desx && c.y == desy) 
                {
                    res = c.dis;
                    break;
                }
                
                for (int i = 0; i < 4; i++) 
                {
                    x = c.x + posbleDirX[i]; 
                    y = c.y + posbleDirY[i]; 
  
                    if(isInside(x, y, n, m) && !visited[x][y] 
                    && arr[x][y] != 0)
                    { 
                        visited[x][y] = true; 
                        q.add(new Cell(x, y, c.dis+1)); 
                    }
                }
            }
            
            System.out.println(res);
        }
	}
	
	static boolean isInside(int x, int y, int n, int m) 
    { 
        if (x >= 0 && x < n && y >= 0 && y < m) 
            return true;
        return false; 
    } 

}
