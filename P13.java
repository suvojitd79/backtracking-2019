/*
    Subsets II
    Given a collection of integers that might contain duplicates, S, return all possible subsets.
     Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    The subsets must be sorted lexicographically.
    Example : If S = [1,2,2], the solution is:
    [
    [],
    [1],
    [1,2],
    [1,2,2],
    [2],
    [2, 2]
    ]	
*/


import java.util.*;

public class P11{

	public static void main(String[] args){
	
	
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Collections.sort(A);
        f(A,0,new ArrayList<Integer>(),list);
        return list;
    }
    
    public void f(ArrayList<Integer> A, int start, ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> cache){
        
        cache.add(new ArrayList<>(ans));
        
        for(int i=start;i<A.size();i++){
            
            if(A.subList(start,i).contains(A.get(i))) continue;
            
            ans.add(A.get(i));
            f(A,i+1,ans,cache);
            ans.remove(ans.size()-1);
        }
        
    }

}