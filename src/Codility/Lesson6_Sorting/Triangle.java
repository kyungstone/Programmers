/**
 * 
 */
package Codility.Lesson6_Sorting;

import java.util.Arrays;

/**
 * @author kyungstone
 *
 */

/*
 * Task description An array A consisting of N integers is given. A triplet (P,
 * Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * 
 * A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q]. For example,
 * consider array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 Triplet (0, 2, 4) is
 * triangular.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns 1 if there exists a
 * triangular triplet for this array and returns 0 otherwise.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 the function should
 * return 1, as explained above. Given array A such that:
 * 
 * A[0] = 10 A[1] = 50 A[2] = 5 A[3] = 1 the function should return 0.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Copyright 2009–2022
 * by Codility Limited. All Rights Reserved. Unauthorized copying, publication
 * or disclosure prohibited.
 */
public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {10, 2, 5, 1, 8, 20};
		int[] A = {10, 5, 50, 1};
		//int[] A = {1, 1, 1, 1, 5, 5, 5};
		System.out.println(Triangle.solution(A));
	}
	
	/*
	 * Detected time complexity: O(N*log(N))
	 * Task Score 100% Correctness 100% Performance 100%
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		
		if(A.length < 3) return 0;
		
		Arrays.sort(A);
		for(int i=0; i<A.length-2; i++) {
			if(A[i] > A[i+2] - A[i+1]) return 1;
		}
		
		return answer;
    }
}
