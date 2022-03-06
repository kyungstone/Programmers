/**
 * 
 */
package Codility.Lesson09_MaximumSliceProblem;

/**
 * @author kyungstone
 *
 */

/*
 * Task description An array A consisting of N integers is given. It contains
 * daily prices of a stock share for a period of N consecutive days. If a single
 * share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the
 * profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥
 * A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
 * 
 * For example, consider the following array A consisting of six elements such
 * that:
 * 
 * A[0] = 23171 A[1] = 21011 A[2] = 21123 A[3] = 21366 A[4] = 21013 A[5] = 21367
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur
 * because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4
 * and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 −
 * 21013 = 354. Maximum possible profit was 356. It would occur if a share was
 * bought on day 1 and sold on day 5.
 * 
 * Write a function,
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers containing daily prices of a
 * stock share for a period of N consecutive days, returns the maximum possible
 * profit from one transaction during this period. The function should return 0
 * if it was impossible to gain any profit.
 * 
 * For example, given array A consisting of six elements such that:
 * 
 * A[0] = 23171 A[1] = 21011 A[2] = 21123 A[3] = 21366 A[4] = 21013 A[5] = 21367
 * the function should return 356, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..400,000]; each element of array A is an
 * integer within the range [0..200,000]. Copyright 2009–2022 by Codility
 * Limited. All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.
 */
public class MaxProfit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
		//int[] A = {8, 9, 3, 6, 1, 2};
		int[] A = {};
		System.out.println(MaxProfit.solution2(A));
	}
	
	/*
	 * Detected time complexity: O(N**2) 
	 * Task Score 66% Correctness 100% Performance 25%
	 * https://app.codility.com/demo/results/trainingT9T6ZM-RBP/
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<i; j++) {
				answer = Math.max(answer, A[i]-A[j]);
			}
		}
		
		return answer;
    }
	
	/*
	 * Detected time complexity: O(N)
	 * Task Score 100% Correctness 100% Performance 100%
	 * https://app.codility.com/demo/results/training797ZWV-RP8/
	 */
	public static int solution2(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		int min = A.length > 0 ? A[0] : 0;
		for(int i=1; i<A.length; i++) {
			min = Math.min(min, A[i]);
			answer = Math.max(answer, A[i] - min);
			System.out.println("min : " + min + ", answer : " + answer);
		}
		
		return answer;
    }
}
