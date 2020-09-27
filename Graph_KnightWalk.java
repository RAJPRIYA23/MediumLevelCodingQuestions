/*
Given a chess board of order N x M and source points (s1, s2) and destination points (d1, d2). 
The task to find minimum number of moves required by the Knight to go to the destination cell.
Note: The chess board consists of rows numbered (1 to N) and columns (1 to M).

Constraints:
1 <= T <= 100
1 <= N, M <= 25

Example:
Input:
2
4 7
2 6 2 4
7 13
2 8 3 4

Output:
2
3

Explanation:
Testcase 1: One possible move for Knight is from 2, 6 to 4, 5 and then to 2, 4 which is our destination.]
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
            
            String str2[] = br.readLine().trim().split(" ");
            
            int source[] = new int[2];
            int dest[] = new int[2];
            
            source[0] = Integer.parseInt(str2[0]);
            source[1] = Integer.parseInt(str2[1]);
            
            dest[0] = Integer.parseInt(str2[2]);
            dest[1] = Integer.parseInt(str2[3]);
            
            System.out.println(minSteps(source, dest, n, m));
        }
	}
	
	static boolean isInside(int x, int y, int n, int m) 
    { 
        if (x >= 1 && x <= n && y >= 1 && y <= m) 
            return true;
        return false; 
    } 
    
	static int minSteps(int pos[], int dest[], int n, int m)
	{
	    int posbleDirX[] = {-1, 1, 2, 2, -1, 1, -2, -2};
	    int posbleDirY[] = {2, 2, 1, -1, -2, -2, 1, -1};
	    
	    boolean visited[][] = new boolean[n + 1][m + 1]; 
	    
	    for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                visited[i][j] = false; 
            }
        }
        
	    Queue<Cell> q = new LinkedList<>();
	    
	    q.add(new Cell(pos[0], pos[1], 0));
	    visited[pos[0]][pos[1]] = true; 
	    
	    Cell t; 
        int x, y;

        while (!q.isEmpty()) 
        {
            t = q.remove(); 
 
            if (t.x == dest[0] && t.y == dest[1]) 
                return t.dis; 
  
            for (int i = 0; i < 8; i++) 
            {
                x = t.x + posbleDirX[i]; 
                y = t.y + posbleDirY[i]; 
  
                if(isInside(x, y, n, m) && !visited[x][y])
                { 
                    visited[x][y] = true; 
                    q.add(new Cell(x, y, t.dis+1)); 
                }
            }
        }
        
        return -1;
	}
}
