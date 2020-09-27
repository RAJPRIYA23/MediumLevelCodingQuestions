/*
Given a graph with N nodes and M directed edges. Your task is to complete the function kosaraju() 
which returns an integer denoting the number of strongly connected components in the graph.

Constraints:
1 <= T <= 100
1 <= N <= 5000
0 <= M <= (N*(N-1))
0 <= u, v <= N-1
Sum of M over all testcases will not exceed 25*106

Example:
Input:
2
5 5
1 0 0 2 2 1 0 3 3 4
3 3
0 1 1 2 2 0

Output:
3
1

Explanation:
Testcase 1:
There is a connected subgraph that includes 0-1-2 which satisfy the condition of strongly connecting components i.e each node is reachable from every other nodes.

Another subgraph includes individual nodes 4 and 3. That gives us a total of 3 subgraphs satisfying the condition of strongly connected components. 
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            
            int vertices = Integer.parseInt(sc.next());
            int edges = Integer.parseInt(sc.next());
            
            for(int i =0; i < vertices; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edges; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 list.get(u).add(v);
            }
            
            Solution T = new Solution();
            System.out.println(T.kosaraju(list, vertices));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

// adj : Adjacency list representing the graph
// N: No of vertices


class Solution
{
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        Stack<Integer> stack = new Stack<>(); 
        boolean visited[] = new boolean[N];
        int res = 0;
        
        Arrays.fill(visited, false);
        
        for (int i = 0; i < N; i++)
        {
            if (visited[i] == false) 
                filwidfinish(adj, i, visited, stack);
        }
     
        ArrayList<ArrayList<Integer>> adjTrans = getTranspose(adj, N); 
  
        Arrays.fill(visited, false); 
  
        while(!stack.isEmpty()) 
        { 
            int v = stack.pop(); 
  
            if (visited[v] == false) 
            {
                dfs(adjTrans, v, visited); 
                res++;
            } 
        } 
        return res;
    }
    
    void filwidfinish(ArrayList<ArrayList<Integer>> adj, int v,
    boolean visited[], Stack<Integer> stack) 
    { 
        visited[v] = true; 
        
        Iterator<Integer> i = adj.get(v).iterator();
        
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if(!visited[n]) 
                filwidfinish(adj, n, visited, stack); 
        }
        stack.push(v); 
    }
    
    ArrayList<ArrayList<Integer>> getTranspose
    (ArrayList<ArrayList<Integer>>adj, int N)
    {
        ArrayList<ArrayList<Integer>> adjTrans = new ArrayList<ArrayList<Integer>>();
            
        for(int i = 0; i < N; i++) 
        {
            adjTrans.add(new ArrayList<Integer>());
        }
        
        for (int v = 0; v < N; v++) 
        {
            Iterator<Integer> i = adj.get(v).listIterator(); 
            while(i.hasNext()) 
                adjTrans.get(i.next()).add(v); 
        } 
        return adjTrans;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean visited[]) 
    {
        int res = 0;
        
        visited[v] = true; 
        
        int n; 
  
        Iterator<Integer> i =adj.get(v).iterator(); 
        while (i.hasNext()) 
        { 
            n = i.next(); 
            if ( !visited[n]) 
                dfs(adj, n, visited); 
        }
    }
    
}
