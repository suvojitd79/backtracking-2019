/*
 * All Unique Permutations
 * 
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example : [1,1,2] have the following unique permutations:
 * 
 * [1,1,2] [1,2,1] [2,1,1]
 * 
 */

import java.util.*;

public class P1{

	public static void main(String[] args){

		ArrayList<Integer> list = new ArrayList(Arrays.asList(1,1,2));

		System.out.println(permute(list));	

	}

	private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
    	
		ArrayList<ArrayList<Integer>> ans = new ArrayList();
		permute(A, 0, ans);
		return ans;
    }

    // branch & bound technique
	private static void permute(ArrayList<Integer> A, int start,ArrayList<ArrayList<Integer>> cache) {
    	

			if(start == A.size()-1) {
				cache.add(new ArrayList<>(A));
				return;
			}


			for(int i=start;i<A.size();i++){

					// handle the duplicates
					if (A.subList(start,i).contains(A.get(i))) {
						continue;
					}

					swap(A, start, i);
					permute(A, start+1, cache);
					swap(A, start, i); // backtracking
			}
	
    }


    private static void swap(ArrayList<Integer> list,int i,int j){

    		int val = list.get(i);
    		list.set(i, list.get(j));
    		list.set(j, val);
    }

}