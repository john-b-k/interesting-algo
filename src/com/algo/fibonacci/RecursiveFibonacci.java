package com.algo.fibonacci;

import java.util.Scanner;

/**
 * 
 * @author doyoon
 * 재귀를 이용한 피보나치
 */
public class RecursiveFibonacci {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
	
		int nth = scanner.nextInt();
		
		int fiboNum = fibonacci(nth);
		System.out.println("Fibonacci num: "+fiboNum);
	}
	
	public static int fibonacci(int number){
		System.out.println("fibonacci method "+number);
		if(number==0 || number ==1){
			return number;
		}
		return fibonacci(number-1)+fibonacci(number-2);
	}
}
//0 1 1 2 3 5