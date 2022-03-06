/**
 * 
 */
package Codility.Lesson04_CountingElements;

import java.util.Arrays;

/**
 * @author kyungstone
 *
 */

/*
 * Task description This is a demo task.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000]. Copyright 2009–2022 by
 * Codility Limited. All Rights Reserved. Unauthorized copying, publication or
 * disclosure prohibited.
 */
public class MissingInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {1, 2, 3};
		int[] A = {-1, -2};
		
		MissingInteger missingInteger = new MissingInteger();
		System.out.println(missingInteger.solution(A));
	}
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 1;
		
		Arrays.sort(A);
		for(int i=0; i<A.length; i++) {
			if(A[i] == answer) {
				answer++;
			} else if(A[i] > answer) {
				break;
			}
		}
		
		return answer;
    }

}
