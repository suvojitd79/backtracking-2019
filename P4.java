/*
 * 
Unique Paths III


Given a matrix of integers A of size N x M. There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square,
that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Input Format

The first argument given is the integer matrix A.
Output Format

Return the number of 4-directional walks from the starting square to the ending square, 
that walk over every non-obstacle square exactly once.
Constraints

2 <= N * M <= 20
-1 <= A[i] <= 2
For Example

Input 1:
    A = [   [1, 0, 0, 0]
            [0, 0, 0, 0]
            [0, 0, 2, -1]   ]
Output 1:
    2
Explanation 1: We have the following two paths: 
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Input 2:
    A = [   [0, 1]
            [2, 0]    ]
Output 2:
    0

 * 
 */

import java.util.*;

public class P4{
    
    int row,col,sx,sy,count;
    int[] x = {0,-1,0,1};
    int[] y = {1,0,-1,0};
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
    
        row = A.size();
        col = A.get(0).size();
        count = 0;
        helper(A);
        return count;
    }
    
    
    public void count(ArrayList<ArrayList<Integer>> A){
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A.get(i).get(j)==0) return;
            }
        }
        count++;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> A){
        
        Haha: 
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A.get(i).get(j)==1){
                    
                    sx = i;
                    sy = j;
                    break Haha;
                }
            }
        }
        
        f(A,sx,sy);
    }
    
    public void f(ArrayList<ArrayList<Integer>> A, int sx,int sy){
        
        for(int i=0;i<4;i++){
            
            int x1 = sx + x[i];
            int y1 = sy + y[i];
            
            if(x1>=0 && x1<row && y1 >=0 && y1<col && Math.abs(A.get(x1).get(y1))!=1){
                
                if(A.get(x1).get(y1)==2) count(A);   
                else{
                    
                    A.get(x1).set(y1, 1); 
                    f(A,x1,y1);
                    A.get(x1).set(y1, 0); // backtracking
                }
                
            }
            
        }
        
    }
     
}