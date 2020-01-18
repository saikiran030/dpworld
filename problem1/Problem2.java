package com.dpworld;
import java.util.*; 
public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(); 
		  
        HashMap map = new HashMap(); 
        for(int i=0;i<=1000000;i++){
    		int rand_int1 = rand.nextInt(1000000);
        	if (!map.containsKey(rand_int1)) { 
        		 map.put(rand_int1, rand_int1); 
        	}
        }
        System.out.println(map);
	}

}
