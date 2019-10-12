/*
 * 
	Kth Permutation Sequence	

	The set [1,2,3,…,n] contains a total of n! unique permutations.

	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3 ) :

	1. "123"
	2. "132"
	3. "213"
	4. "231"
	5. "312"
	6. "321"
	Given n and k, return the kth permutation sequence.

	For example, given n = 3, k = 4, ans = "231"

 * 
 */

import java.util.*;

public class P5{

	public static void main(String[] args){

		

	}

	public String getPermutation(int A, int B) {
        // not valid
       if(B > fact(A)) return "";
    
        ArrayList<Integer> list = new ArrayList();
        for(int i=1;i<=A;i++) list.add(i);
        
        return getPermutation(list, B-1);
        
        
    }
    
    public String getPermutation(ArrayList<Integer> list, int B) {
    
        int n = list.size();
        
        if(n==0) return "";
        
        int fact_n = fact(n-1);
        int index = B / fact_n;
        int data = list.get(index);
        list.remove(index);
        B %= fact_n;
        return data + getPermutation(list, B);
    }
    
    
    
    public int fact(int n){
        
        if(n>12) return Integer.MAX_VALUE;    
        
        int fact = 1;
        
        for(int i=2;i<=n;i++) fact *= i;
        
        return fact;
    }
    
    

}