package com.algo.pallindrome;

import java.util.Scanner;

/**
 * 
 * @author doyoon
 * 1. 해당 문자열이 명백한 팰린드롬인지 확인(eg. abccba)
 * 2. 해당 문자열  중 특수문자를 빼고 팰린드롬인지 확인(eg. ab#cba@)
 */
public class Pallindrome {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String stringToCheck = scanner.nextLine();
		
		boolean result = isSimplePallindrome(stringToCheck);
		
		//확인 : abc c b a ,  a@#@ ,  @#@#@
		boolean secondResult = isPallindromeExceptSpecialChar(stringToCheck);
		
		
		if(result == true){
			System.out.println(stringToCheck+" is Strictly Pallindrome.");
		}else{
			System.out.println(stringToCheck+" is Not Strictly Pallindrome.");
		}
		
		if(secondResult == true){
			System.out.println(stringToCheck+" is Loosely Pallindrome.");
		}else{
			System.out.println(stringToCheck+" is Not Loosely Pallindrome.");
		}
	}
	
	public static boolean isSimplePallindrome(String value){
		final int sizeOfString = value.length();
		int leftIndex = 0;
		int rightIndex = sizeOfString-1;
		
		while(leftIndex < rightIndex){
			if(value.charAt(leftIndex) == value.charAt(rightIndex)){
				leftIndex++;
				rightIndex--;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPallindromeExceptSpecialChar(String value){
		final int sizeOfString = value.length();
		int leftIndex = 0;
		int rightIndex = sizeOfString-1;
		
		while(leftIndex < rightIndex){
			//왼쪽에서 특수문자 회피
			while(leftIndex < sizeOfString  &&  Character.isLetter(value.charAt(leftIndex)) == false){
				leftIndex++;
			}
			
			//오른쪽에서 특수문자 회피
			while(rightIndex > 0  &&  Character.isLetter(value.charAt(rightIndex)) == false){
				rightIndex--;
			} 
			
			//스트링 모두 특수문자로 이루어진경우 회피
			if(leftIndex > sizeOfString || rightIndex < 0){
				return false;
			}
			
			if(value.charAt(leftIndex) != value.charAt(rightIndex)){
				return false;
			}
			leftIndex++;
			rightIndex--;
		}
		return true;
	}
}

