/*
	Write a program to solve a Sudoku puzzle by filling the empty cells.
	Empty cells are indicated by the character '.'
	You may assume that there will be only one unique solution.
		
 */

import java.util.*;

public class P11{

	public static void main(String[] args){
	
	
	}


	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
    
        helper(a);
        
    }
    
    public boolean isSafe(ArrayList<ArrayList<Character>> a,int row,int col,Character x){
        
        // row wise check
        for(int i=0;i<a.get(row).size();i++){
            
            if(a.get(row).get(i)==x) return false;
            
        }
        
        
        
        // column wise check
        for(int i=0;i<a.size();i++){
            
            if(a.get(i).get(col)==x) return false;
            
        }
        
        //grid wise
        int n  = (int) Math.sqrt(a.size());
        row = row - row % n;
        col  = col - col % n;
        
        for(int i=row;i<row+n;i++){
            for(int j=col;j<col+n;j++){
                if(a.get(i).get(j)==x) return false;
            }
        }
        
        return true; //safe
    }
    
    
    public boolean helper(ArrayList<ArrayList<Character>> a){
        
        //base case
        Pair p = available(a);
        if(p.r == null && p.c == null){
            return true; // done
        }
        
        
        for(int i=1;i<=a.size();i++){
                
                char c = (char)(i+'0');
                if(isSafe(a,p.r,p.c,c)){
                    
                    a.get(p.r).set(p.c,c); //try       
                    if(helper(a)) return true;
                    a.get(p.r).set(p.c, '.'); //backtrack
                    
            }            
            
        }
        
        return false;
    }
    
    public Pair available(ArrayList<ArrayList<Character>> a){
        
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.get(i).size();j++){
                if(a.get(i).get(j)=='.') return new Pair(i,j);
            }
        }
        
        return new Pair(null,null); // success
    }
    
    
    
    
    class Pair{
        
        Integer r,c;
        Pair(Integer r,Integer c){
            
            this.r = r;
            this.c = c;
            
        }
        
    }
    


}