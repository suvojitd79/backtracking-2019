/*

	Combination Sum II	
	Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	Each number in C may only be used once in the combination.

	 Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	The solution set must not contain duplicate combinations.
	Example :

	Given candidate set 10,1,2,7,6,1,5 and target 8,

	A solution set is:

	[1, 7]
	[1, 2, 5]
	[2, 6]
	[1, 1, 6]

  
 */

import java.util.*;

public class P2{

	public static void main(String[] args){

		System.out.println(new P2().combinationSum(new ArrayList<>(Arrays.asList( 8, 10, 6, 11, 1, 16, 8 )),28));

	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    

		ArrayList<ArrayList<Integer>> cache = new ArrayList();
	    Collections.sort(a);
		combinationSum(a,b,0,new ArrayList<Integer>(),cache);
		return cache;

    }


	public void combinationSum(ArrayList<Integer> a, int sum,int start,ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> cache) {
	    
				
			if(sum==0){
				cache.add(new ArrayList(ans));
				return;
			} 

			if(start==a.size()) return;

			for(int i=start;i<a.size();i++){

				if(a.get(i) >  sum || a.subList(start,i).contains(a.get(i))) continue;

				ans.add(a.get(i)); 
				combinationSum(a,sum-a.get(i),i+1,ans,cache);
				ans.remove(a.get(i)); // backtrack 
			}

	}

}