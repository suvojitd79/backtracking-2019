/*
	
	Generate all Parentheses II	
		
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

	For example, given n = 3, a solution set is:

	"((()))", "(()())", "(())()", "()(())", "()()()"
	Make sure the returned list of strings are sorted.


		
 */

import java.util.*;

public class P01{

	public static void main(String[] args){
	}

	public ArrayList<String> generateParenthesis(int A) {
        
        ArrayList<String> cache = new ArrayList();
        helper("",A,A,cache);
        return cache;
    }
    
    public void helper(String ans,int l,int r, ArrayList<String> cache){
        
        if(l==0 && r==0){
            cache.add(new String(ans));
            return;
        }
        
        if(l > 0) helper(ans+"(",l-1,r,cache);
        if(l < r) helper(ans+")",l,r-1,cache);
    }
    

}