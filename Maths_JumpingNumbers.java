/*
Given a positive number X. Find all Jumping Numbers smaller than or equal to X. 
Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1. All single digit numbers are considered as Jumping Numbers. 
For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Constraints:
1 <= T <= 100
1 <= N <= 109

Example:
Input:
2
10
50
Output:
0 1 2 3 4 5 6 7 8 9 10
0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = sc.nextInt();
            List<Integer> answers = new LinkedList<Integer>();
            int temp1 = 0, temp2 = 0, num_till_now = 0;
            String str;
            System.out.print("0 ");
            for (int j = 1; j <= 9; j++) 
            {
                answers.add(j);
                num_till_now = answers.get(answers.size()-1);
                if (num_till_now <= n) 
                {
                    System.out.print(num_till_now + " ");
                } 
                else 
                {
                    answers.remove(answers.size()-1);
                    break;
                }
            }
            while (num_till_now <= n)
            {
                temp1 = answers.remove(0);
                temp2 = temp1%10;
                if (temp2 > 0)
                {
                    str = Integer.toString(temp1) + Integer.toString(temp2 - 1);
                    answers.add(Integer.parseInt(str));
                    num_till_now = Integer.parseInt(str);
                    if (num_till_now <= n)
                    {
                        System.out.print(num_till_now + " ");
                    } 
                    else 
                    {
                        answers.remove(answers.size()-1);
                        break;
                    }
                }
                if (temp2 < 9)
                {
                    str = Integer.toString(temp1) + Integer.toString(temp2 + 1);
                    answers.add(Integer.parseInt(str));
                    num_till_now = Integer.parseInt(str);
                    if (num_till_now <= n) 
                    {
                        System.out.print(num_till_now + " ");
                    } 
                    else 
                    {
                        answers.remove(answers.size()-1);
                        break;
                    }
                }
                
            }
            System.out.println();
        }
    }
}
