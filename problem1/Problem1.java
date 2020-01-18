package com.dpworld;
import java.util.*;

public class Problem1 {
	public static void main(String args[]){
		char input[]="123".toCharArray();
		printSingleString(input);
		System.out.println();
		printCombinationList(input);
	}
	static void printSingleString(char[] input){
		for(int i=0;i<input.length;i++){
			System.out.print((char)(input[i]+16));
		}
	}
	static void printCombinationList(char[] input){
		List l = new LinkedList();
		for(int i=0;i<input.length-1;i++){
			for(int j=0;j<i;j++){
				System.out.print((char)(input[j]+16));
			}
			int val = Integer.parseInt(""+String.valueOf(input[i])+String.valueOf(input[i+1]))+64;
			if(val>=65 && val <=91){
				System.out.print(""+(char)(val));
			}
			
			for(int j=i+2;j<input.length;j++){
				System.out.print((char)(input[j]+16));
			}		
			System.out.println();
		}
	}
}
