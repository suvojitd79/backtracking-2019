/*
 * 
    Gray Code   
    
    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

    For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

    00 - 0
    01 - 1
    11 - 3
    10 - 2

    There might be multiple gray code sequences possible for a given n.
    Return any such sequence

 * 
 */

import java.util.*;

public class P6{

	public static void main(String[] args){

	}

    public ArrayList<Integer> grayCode(int a) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<Math.pow(2,a);i++)
            ans.add(i ^ (i>>1));
        return ans;
    }

}