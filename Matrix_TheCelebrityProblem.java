/*
You are in a party of N people, where only one person is known to everyone. Such a person may be present in the party, 
if yes, (s)he doesn’t know anyone in the party. Your task is to find the stranger (celebrity) in party.

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: The matrix will look like
0 1 0 
0 0 0
0 1 0
Here,  the celebrity is the person with
index 1 ie id 1 

Your Task:
You will be given a square matrix M[][] where if an element of row i and column j  is set to 1 it means ith person knows jth person. You need to complete the function getId() which finds the id of the celebrity if present else return -1. The function getId() takes two arguments, the square matrix M and its size N.

Note: 
M[i][i] will be equal to zero always.
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

class Celebrity_Problem
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					M[i][j] = sc.nextInt();
				}
			}
		System.out.println(new Celebrity().getId(M,N));
		t--;
		}
	}
}
// } Driver Code Ends


class Celebrity
{
   
    int getId(int M[][], int n)
    {
        int res = -1;
        int count = 0;
        
        for(int i=0; i<n; i++)
        {
            int sum = 0;
            
            for(int j=0; j<n; j++)
            {
                sum = sum + M[i][j];
            }
            
            if(sum == 0)
            {
                res = i;
                break;
            }
        }
        
        if(res == 0 && n > 1)
        {
            int sum = 0;
            for(int j=0; j<n; j++)
            {
                sum = sum + M[res+1][j];
            }
            
            if(sum == 0)
            {
                res = -1;
            }
        }
        
        return res;
    }
}
