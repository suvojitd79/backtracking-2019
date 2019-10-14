/*
	modular arithmetic properties:
	(a*b) % c = (a%c * b%c) % c
	(-a) % c = (a + c) % c 
 * 
 */

import java.util.*;

public class P9{

	public static void main(String[] args){

		System.out.println(mod(71045970,41535484,64735492));

	}

	public static int mod(int x,int y,int z){

		if(x==0) return 0;

		if(y==0) return 1;

		long val;

		if(y % 2 == 0){
			val = mod(x,y/2,z) % z;
			val =  (val  * val) % z;
		}else{
			val = x % z;
			val =  (val * mod(x, y-1,z) % z) % z;
		}
		return (int) (val + z) % z;
	}

}