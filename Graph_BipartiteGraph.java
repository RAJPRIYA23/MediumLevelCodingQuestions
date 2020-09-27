/*
Given an adjacency matrix representation of a graph g having 0 based index your task is to complete the function isBipartite 
which returns true if the graph is a bipartite graph else returns false.

Constraints:
1<=T<=100
1<=v<=15
0<=g[][]<=1

Example(To be used only for expected output):
Input:
2
4
0 1 0 1 1 0 1 0 0 1 0 1 1 0 1 0
3
0 1 0 0 0 1 1 0 0
Output:
1
0
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

// Java program to find out whether a given graph is Bipartite or not
import java.util.*;
import java.lang.*;
import java.io.*;

class Bipartite
{ 
	public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
        int V = sc.nextInt();
		int[][] G = new int[V][V];
		for(int i = 0; i < V; i++)
			for(int j = 0; j < V; j++)
				G[i][j] = sc.nextInt();
		GfG b = new GfG();
        if (b.isBipartite(G, V))
           System.out.println("1");
        else
           System.out.println("0");
		}
    }
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	boolean isBipartite(int G[][], int V)
    {
        int color[] = new int[V];
            
        for (int i = 0; i < V; i++)
        {
            color[i] = -1;
        }
                
        color[0] = 1;
            
        Queue<Integer> q = new LinkedList<Integer>(); 
        q.add(0);
            
        while(!q.isEmpty()) 
        {
            int u = q.remove();
                
            if (G[u][u] == 1) 
                return false;
            
            int cnt = 0;
            for(int v = 0; v < V; v++) 
            {
                if(G[u][v] == 1 && color[v] == -1) 
                { 
                    color[v] = 1-color[u]; 
                    q.add(v);
                }
                    
                else if(G[u][v] == 1 && color[v] == color[u]) 
                    return false;
                
                else if(G[u][v] == 0)
                {
                    cnt++;
                }
                
                if(cnt == V-1 && u+1 < V)
                {
                    color[u+1] = 1;
                    q.add(u+1);
                    cnt = 0;
                }
            }
        }
        
        return true; 
    }
}
