/*
    Letter Phone    

    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters is just like on the telephone buttons.

    The digit 0 maps to 0 itself.
    The digit 1 maps to 1 itself.

    Input: Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


		
*/


import java.util.*;

public class P11{

	public static void main(String[] args){
	
	
	}

    public ArrayList<String> letterCombinations(String A) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map.put("0",new ArrayList<>(Arrays.asList("0")));
        map.put("1",new ArrayList<>(Arrays.asList("1")));
        map.put("2",new ArrayList<>(Arrays.asList("a","b","c")));
        map.put("3",new ArrayList<>(Arrays.asList("d","e","f")));
        map.put("4",new ArrayList<>(Arrays.asList("g","h","i")));
        map.put("5",new ArrayList<>(Arrays.asList("j","k","l")));
        map.put("6",new ArrayList<>(Arrays.asList("m","n","o")));
        map.put("7",new ArrayList<>(Arrays.asList("p","q","r","s")));
        map.put("8",new ArrayList<>(Arrays.asList("t","u","v")));
        map.put("9",new ArrayList<>(Arrays.asList("w","x","y","z")));
        
        ArrayList<String> cache = new ArrayList<>();
        helper(A,"",cache,map);
        return cache;
    }
    
    public void helper(String A, String ans, ArrayList<String> cache,HashMap<String, ArrayList<String>> map){
        
        if(A.length()==0) {
            
            cache.add(new String(ans));
            return;
        }
        
        for(String x: map.get(A.charAt(0)+"")){
            
            ans = ans + x;
            helper(A.substring(1), ans, cache, map);
            ans = ans.substring(0,ans.length()-1);
        }
    

}