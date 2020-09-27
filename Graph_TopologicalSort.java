/*
Given a Directed Graph. Find any Topological Sorting of that Graph.

Constraints:
1 <= T <= 100
2 <= V <= 104
1 <= E <= (N*(N-1))/2
0 <= u, v <= N-1
Graph doesn't contain multiple edges, self loops and cycles.
Graph may be disconnected.

Example:
Input
2
6 6
5 0 5 2 2 3 4 0 4 1 1 3
3 4
3 0 1 0 2 0

Output:
1
1

Explanation:
Testcase 1: The output 1 denotes that the order is valid.  So, if you have implemented your function correctly, then output would be 1 for all test cases.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for (int i = 1; i <= edg; i++) {
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);
            }

            int[] res = new TopologicalSort().topoSort(list, nov);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class TopologicalSort 
{
    static int arr[];
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n) 
    {
        arr = new int[n];
        Stack<Integer> stack = new Stack<Integer>();  
      
        boolean visited[] = new boolean[n];  
        Arrays.fill(visited, false);  
    
    
        for(int i = 0; i < n; i++)
        {
            if(visited[i] == false)  
                topologicalSort(adj, i, visited, stack);
        }
            
        int i = 0;     
        while(!stack.isEmpty())
        { 
            arr[i] = stack.pop();
            i++;
        }
        
        return arr;
    }
    
    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v, 
    boolean visited[], Stack<Integer>stack)
    {
        visited[v] = true;  
        Integer i;  

        Iterator<Integer> it = adj.get(v).iterator();
        
        while(it.hasNext())  
        {  
            i = it.next(); 
            if(!visited[i])  
                topologicalSort(adj, i, visited, stack);  
        }
        
        stack.push(new Integer(v));
    }
    
}
