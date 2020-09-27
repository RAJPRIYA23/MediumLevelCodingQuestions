/*
Given a Directed Graph. Check whether it contains any cycle or not.

Input: The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines.
Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'M'  which denotes the no of vertices and no of edges respectively. 
The Second line of each test case contains 'M'  space separated pairs u and v denoting that there is an uni-directed  edge from u to v .

Constraints:
1 <= T <= 1000
1<= N,M <= 1000
0 <= u,v <= N-1

Example:
Input:
3
2 2
0 1 0 0
4 3
0 1 1 2 2 3
4 3
0 1 2 3 3 2
Output:
1
0
1

Explanation:
Testcase 1: In the above graph there are 2 vertices. The edges are as such among the vertices.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

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
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

/*
ArrayList<ArrayList<Integer>> adj: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int v)
    {
        boolean[] visited = new boolean[v]; 
        boolean[] rstack = new boolean[v]; 
          
        Arrays.fill(visited, false); 
        Arrays.fill(rstack, false);
        
        for (int i = 0; i < v; i++)
        {
            if(isCyclicCheck(adj, i, visited, rstack)) 
                return true; 
        }
    
        return false;
    }
    
    boolean isCyclicCheck(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, boolean[] rstack) 
    {
        if(rstack[i])
            return true; 
  
        if(visited[i])
            return false;
              
        visited[i] = true; 
        rstack[i] = true; 
        
        for(int j = 0; j < adj.get(i).size(); j++)
        {
 			if (isCyclicCheck(adj, adj.get(i).get(j), visited, rstack)) 
 				return true; 
        }
        
        rstack[i] = false; 
        return false;
        
    } 
    
    
}
