/*
 * 
    Number of Squareful Arrays   
    

    Given an array of integers A, the array is squareful if for every pair of adjacent elements,
    their sum is a perfect square.

    Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ
    if and only if there is some index i such that A1[ i ] != A2[ i ].



    Input Format

    The only argument given is the integer array A.
    Output Format

    Return the number of permutations of A that are squareful.
    Constraints

    1 <= length of the array <= 12
    1 <= A[i] <= 10^9 
    For Example

    Input 1:
        A = [2, 2, 2]
    Output 1:
        1

    Input 2:
        A = [1, 17, 8]
    Output 2:
        2
     

 * 
 */

import java.util.*;

public class P8{
    
    int ans = 0;

    public int solve(ArrayList<Integer> a){
        
        if(a.size()<2) return 0;
        boolean[] flag = new boolean[a.size()];
        int[] A = new int[a.size()];
        for(int i=0;i<a.size();i++) A[i] = a.get(i);
        Arrays.sort(A);
        f(A,flag,new ArrayList<Integer>());
        return ans;   
    }
    
    
    public void f(int[] a, boolean[] flag, ArrayList<Integer> list){
        
        if(list.size()==a.length) {
            ans++;
            return;
        }
        
        for(int i=0;i<a.length;i++){
            
            if(flag[i] || (i!=0 && a[i]==a[i-1] && !flag[i-1]))
                    continue;
            if(!list.isEmpty() && !isSquare(list.get(list.size()-1), a[i]))
                   continue;
                   
            flag[i] = true;
            list.add(a[i]);
            f(a,flag,list);
            flag[i] = false;
            list.remove(list.size()-1);
        }
        
    }
    
    
    public boolean isSquare(int x,int y){
        
        int v = (int) Math.sqrt(x+y);
        return v * v == x + y;
        
    }
    
}

