/*
Given a Undirected Graph. Check whether it contains a cycle or not. 
Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= M <= (N*(N-1))/2
0 <= u, v <=  N-1
Graph doesn't contain multiple edges and self loops.

Example:
Input:
3
2 1
0 1
4 3
0 1 1 2 2 3
5 4
0 1 2 3 3 4 4 2

Output:
0
0
1

Explanation:
Testcase 1: There is a graph with 2 vertices and 1 edge from 0 to 1. So there is no cycle.
Testcase 2: There is a graph with 3 vertices and 3 edges from 0 to 1, 1 to 2 and 2 to 3.
Testcase 3: There is a cycle in the given graph formed by vertices 2, 3 and 4.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int v)
    {
        Boolean visited[] = new Boolean[v];
        
        for(int i = 0; i < v; i++)
        {
            visited[i] = false;
        }
        
        int parent[] = new int[v]; 
        Arrays.fill(parent, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        
        visited[0] = true;
        q.add(0);
        
        int cnt = 0;
        while(!q.isEmpty())
        {
            int x = q.remove();
            cnt++;
            for(int j = 0; j < g.get(x).size(); j++)
            {
                int data = g.get(x).get(j);
                if(visited[data] == false)
                {
                    visited[data] = true;
                    q.add(data);
                    parent[data] = x;
                }
                else if(parent[x] != data) 
                    return true;
            }
            
            if(q.isEmpty() && cnt != v)
            {
                for(int i = 0; i < v; i++)
                {
                    if(visited[i] == false)
                    {
                        visited[i] = true;
                        q.add(i);
                        break;
                    }
                }
            }
        }
        
        return false;
    }
}
