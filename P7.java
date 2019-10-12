/*
 * 
    Palindrome Partitioning 

    Given a string s, partition s such that every string of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["a","a","b"]
        ["aa","b"],
      ]

     Ordering the results in the answer : Entry i will come before Entry j if :
    len(Entryi[0]) < len(Entryj[0]) OR
    (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
    *
    *
    *
    (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
    In the given example,
    ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")


 * 
 */

import java.util.*;

public class P7{
    
public ArrayList<ArrayList<String>> partition(String a) {
    
        return helper(a);  
    }
    
    public ArrayList<ArrayList<String>> helper(String a){
        
        ArrayList<ArrayList<String>> cache = new ArrayList<>();
        
        if(a.length()==0){
            cache.add(new ArrayList<String>());
            return cache;   
        }
        
        for(int i=1;i<= a.length();i++){
            
            if(isPalindrome(a.substring(0, i))){
                
             ArrayList<ArrayList<String>> ans = helper(a.substring(i));
             for(int j=0;j<ans.size();j++){
                 
                 ans.get(j).add(0, a.substring(0, i));
                 cache.add(ans.get(j));
             }
                
        }
            
    }
        
        return cache;
    }
    
    
    public boolean isPalindrome(String a){
            
        if(a.length()==1) return true;
        
        for(int i=0,j=a.length()-1;i<j;i++,j--){
            
            if(a.charAt(i) != a.charAt(j)) return false;
            
        }
        
        return true;
        
    }


}