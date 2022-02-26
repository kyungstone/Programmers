/**
 * 
 */
package Codility.Lesson5_PrefixSums;

/**
 * @author kyungstone
 *
 */

/*
 * Task description
 * A non-empty array A consisting of N integers is given. A
 * pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array
 * A (notice that the slice contains at least two elements). The average of a
 * slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length
 * of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... +
 * A[Q]) / (Q − P + 1).
 * 
 * For example, array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the
 * following example slices:
 * 
 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average
 * is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is
 * minimal.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the
 * starting position of the slice with the minimal average. If there is more
 * than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 the function
 * should return 1, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [2..100,000]; each element of array A is an
 * integer within the range [−10,000..10,000].
 * Copyright 2009–2022 by Codility Limited.
 * All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class MinAvgTwoSlice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4, 2, 2, 5, 1, 5, 8};
		//int[] A = {-3, -5, -8, -4, -10};
		
		System.out.println(MinAvgTwoSlice.solution2(A));
	}
	
	/*
	 * Detected time complexity: O(N ** 2)
	 * Task Score 60% Correctness 100% Performance 20%
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		double minAvg = (double)(A[0] + A[1])/2;
		System.out.println("MIN AVG = " + minAvg);
		for(int i=0; i<A.length-1; i++) {
			System.out.print("IDX = " + i + "[");
			int sum = A[i];
			for(int j=i+1; j<A.length; j++) {
				sum += A[j];
				double temp = (double)sum/(j-i+1);
				System.out.print(", " + temp + " : ");
				System.out.print(temp < minAvg);
				if(temp < minAvg) {
					minAvg = temp;
					answer = i;
				}
			}
			System.out.println("]");
		}
		
		return answer;
    }
	
	/*
	 * Detected time complexity: O(N)
	 * Task Score 100% Correctness 100% Performance 100%
	 */
	public static int solution2(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		double minAvg = (double)(A[0] + A[1])/2;
		System.out.println("MIN AVG = " + minAvg);
		for(int i=0; i<A.length-1; i++) {
			System.out.print("IDX = " + i + "[");
			int sum = A[i];
			int cnt = 0;
			for(int j=i+1; j<A.length; j++) {
				if(j-1 == i || A[j] < A[j-1]) {
					sum += A[j];
					cnt = j-i+1;
					System.out.print("!! ");
				} else {
					break;
				}
			}
			System.out.print("cnt = " + cnt);
			double temp = (double)sum/(cnt);
			System.out.print(", " + temp + " : ");
			System.out.print(temp < minAvg);
			if(temp < minAvg) {
				minAvg = temp;
				answer = i;
			}
			
			System.out.println("]");
		}
		
		return answer;
    }
}
