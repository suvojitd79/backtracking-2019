/*

	NQueens
 
	Given an integer n, return all distinct solutions to the n-queens puzzle.


 */

import java.util.*;

public class P3{

	public static void main(String[] args){

		System.out.println(new P3().solveNQueens(7));

	}

  public ArrayList<ArrayList<String>> solveNQueens(int a) {
        
     ArrayList<ArrayList<String>> cache = new ArrayList<>();
     ArrayList<String> board = new ArrayList<>();
     
     char[] data_ = new char[a];
     Arrays.fill(data_,'.');
     String data = new String(data_);
     
     
     for(int i=0;i<a;i++){
         
         board.add(data);
         
     }
     
     helper(board,0,cache);
     return cache;    
    }
    
    
    public boolean issafe(ArrayList<String> board,int row,int col){
        
        for(int i=0;i<col;i++){
            
            if(board.get(row).charAt(i)=='Q') return false;
        }
        
        for(int i=0;i<row;i++){
            
            if(board.get(i).charAt(col)=='Q') return false;
        }
        
        
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board.get(i).charAt(j)=='Q') return false;
        }
        
        
        for(int i=row+1,j=col-1;i<board.size() && j>=0;i++,j--){
            if(board.get(i).charAt(j)=='Q') return false;
        }
        
        
        return true;
    }
    
    
    public boolean helper(ArrayList<String> board, int col, ArrayList<ArrayList<String>> cache){
        
        // success
        if(col==board.size()){
            cache.add(new ArrayList<>(board));
            return false;
        }
        
        for(int row=0;row<board.size();row++){
            
            if(issafe(board, row, col)){
                
                set(board,row,col,'Q');
                if(helper(board, col+1,cache)) return true;
                set(board,row,col,'.'); //backtracking
            }
        
        }
        return false;
    }
    
    public void set(ArrayList<String> board, int r,int c, char xx){
        
        StringBuilder x = new StringBuilder(board.get(r));
        x.setCharAt(c, xx);
        board.set(r, new String(x));
    }
    

}