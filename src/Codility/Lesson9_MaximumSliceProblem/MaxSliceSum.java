/**
 * 
 */
package Codility.Lesson9_MaximumSliceProblem;

/**
 * @author kyungstone
 *
 */

/*
 * Task description A non-empty array A consisting of N integers is given. A
 * pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array
 * A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns the maximum sum of
 * any slice of A.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 3 A[1] = 2 A[2] = -6 A[3] = 4 A[4] = 0 the function should return 5
 * because:
 * 
 * (3, 4) is a slice of A that has sum 4, (2, 2) is a slice of A that has sum
 * −6, (0, 1) is a slice of A that has sum 5, no other slice of A has sum
 * greater than (0, 1). Write an efficient algorithm for the following
 * assumptions:
 * 
 * N is an integer within the range [1..1,000,000]; each element of array A is
 * an integer within the range [−1,000,000..1,000,000]; the result will be an
 * integer within the range [−2,147,483,648..2,147,483,647]. Copyright 2009–2022
 * by Codility Limited. All Rights Reserved. Unauthorized copying, publication
 * or disclosure prohibited.
 */
public class MaxSliceSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {3, 2, -6, 4, 0};
		//int[] A = {3, 2, 7, -4, 9, 8, 7};
		//int[] A = {-6, -4, -1};
		int[] A = {-2, 1};
		//int[] A = {3, -2, 3};
		System.out.println(MaxSliceSum.solution(A));
	}
	
	/*
	 * Detected time complexity: O(N)
	 * Task Score 100% Correctness 100% Performance 100%
	 * https://app.codility.com/demo/results/trainingP3UN72-2C4/
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int answer = A[0];
		int sum = A[0];
		for(int i=1; i<A.length; i++) {
			int num = A[i];
			if(sum >= 0 && A[i] >= 0) {
				sum += num;
			} else if(sum >= 0 && A[i] < 0) {
				answer = Math.max(answer, sum);
				if(sum + num > 0) {
					sum += num;
				} else {
					sum = num;
				}
			} else if(sum < 0 && A[i] >= 0) {
				sum = num;
			} else {
				sum = Math.max(sum, num);
			}
		}
		
		return Math.max(answer, sum);
    }
}
