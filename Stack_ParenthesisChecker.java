/*
Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader
		(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine().trim()); 
        
	    while(t-- >0)
	    {
	        MyStack obj = new MyStack(); 
	       
	        String str = br.readLine().trim();
	        
	        for(int i=0; i < str.length(); i++)
	        {
	            if(obj.top != -1 && obj.arr[obj.top] == '{' && str.charAt(i) == '}')
	                obj.pop();
	               
	            else if(obj.top != -1 && obj.arr[obj.top] == '(' && str.charAt(i) == ')')
	                obj.pop();
	                
	            else if(obj.top != -1 && obj.arr[obj.top] == '[' && str.charAt(i) == ']')
	                obj.pop();
	                
	            else
	                obj.push(str.charAt(i));
	        }
	        
	        if(obj.top == -1)
	            System.out.println("balanced");
	        else
	            System.out.println("not balanced");
	    }
	}
}

class MyStack
{
    int top;
	char arr[] = new char[100000];

    MyStack()
	{
		top = -1;
	}
	
	
    void push(char a)
	{
	    top++;
	    arr[top] = a;
	} 
	
    
	void pop()
	{
        if(top != -1)
            top--;
    }
    
}
