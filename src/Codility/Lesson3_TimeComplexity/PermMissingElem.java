/**
 * 
 */
package Codility.Lesson3_TimeComplexity;

import java.util.Arrays;

/**
 * @author kyungstone
 *
 */

/*
 * Task description An array A consisting of N different integers is given. The
 * array contains integers in the range [1..(N + 1)], which means that exactly
 * one element is missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; the elements of A are all
 * distinct; each element of array A is an integer within the range [1..(N +
 * 1)]. Copyright 2009–2022 by Codility Limited. All Rights Reserved.
 * Unauthorized copying, publication or disclosure prohibited.
 */
public class PermMissingElem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {2, 3, 1, 5};
		//int[] A = {2, 3, 1, 5, 6, 7, 8, 9};
		//int[] A = {1,2,3,4,5};
		int[] A = {};
		
		PermMissingElem permMissingElem = new PermMissingElem();
		System.out.println(permMissingElem.solution(A));
	}
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		int answer = A.length + 1;
		
		Arrays.sort(A);
		for(int i=0; i<A.length; i++) {
			if(A[i] != i+1) {
				answer = i+1;
				break;
			}
		}
		
		return answer;
    }
}
