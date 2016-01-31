package com.algo.fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author doyoon
 * 재귀를 이용한 피보나치
 */
public class RecursiveCachedFibonacci {
	static Map<Integer,Integer> cache = new HashMap<>();
	static int methodCallCount=0;
	static int cacheMethodCallCount=0;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
	
		int nth = scanner.nextInt();
		
//		long start1 = System.nanoTime();
//		int fiboNum = fibonacci(nth);
//		long end1 = System.nanoTime();
//		System.out.println("Fibonacci num: "+fiboNum+ " spent "+(end1-start1));
		
		
		long start2 = System.nanoTime();
		int cachedfiboNum = cachedfibonacci(nth);
		long end2 = System.nanoTime();
		System.out.println("Cached Fibonacci num: "+cachedfiboNum+ " spent "+(end2-start2));
		
		System.out.println(cacheMethodCallCount+"  " +methodCallCount);
	}
	
	public static int fibonacci(int number){
		if(number==0 || number ==1){
			return number;
		}
		methodCallCount++;
		return fibonacci(number-1)+fibonacci(number-2);
	}
	
	public static int cachedfibonacci(int number){
		cache.put(0, 0);
		cache.put(1, 1);
		
		return recursiveCachedFinbonacci(number);
	}
	
	public static int recursiveCachedFinbonacci(int number){
		if(cache.containsKey(number)==true){
			return cache.get(number);
		}
		
		cacheMethodCallCount++;
		int result =  cachedfibonacci(number-1)+cachedfibonacci(number-2);
		cache.put(number, result);
		
		return result;
	}
}

//0 1 1 2 3 5