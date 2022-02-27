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
 * Task description We draw N discs on a plane. The discs are numbered from 0 to
 * N − 1. An array A of N non-negative integers, specifying the radiuses of the
 * discs, is given. The J-th disc is drawn with its center at (J, 0) and radius
 * A[J].
 * 
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
 * K-th discs have at least one common point (assuming that the discs contain
 * their borders).
 * 
 * The figure below shows discs drawn for N = 6 and A as follows:
 * 
 * A[0] = 1 A[1] = 5 A[2] = 2 A[3] = 1 A[4] = 4 A[5] = 0
 * 
 * 
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * 
 * discs 1 and 4 intersect, and both intersect with all the other discs; disc 2
 * also intersects with discs 0 and 3. Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A describing N discs as explained above, returns the
 * number of (unordered) pairs of intersecting discs. The function should return
 * −1 if the number of intersecting pairs exceeds 10,000,000.
 * 
 * Given array A shown above, the function should return 11, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [0..2,147,483,647]. Copyright 2009–2022 by Codility
 * Limited. All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.
 */
public class NumberOfDiscIntersections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 5, 2, 1, 4, 0};
		//-4, -1, 0, 0, 2, 5
		//1, 4, 4, 5, 6, 8
		
		//0 + 1 + 2 + 3
		//4-1 
		//5-3
		//-1, 1
		//-4, 6
		//0, 4
		//2, 4
		//0, 8
		//5, 5
		
		//A[5] = 0 ,0
		//A[0] = 1, 0
		//A[3] = 1, 0
		//A[2] = 2, 2
		//A[4] = 4, 4
		//A[1] = 5, 5
		
		//A[0] = 1 ,0
		//A[1] = 1, 1
		//A[2] = 1, 2
		
		//A[2] = 0, 0
		//A[0] = 1, 0
		//A[1] = 2147483647, 
		
		
		
		//int[] A = {1, 1, 1};
		//int[] A = {1, 2147483647, 0};
		System.out.println(NumberOfDiscIntersections.solution2(A));
	}
	
	/*
	 * Detected time complexity: O(N**2)
	 * Task Score 62% Correctness 100% Performance 25%
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				if(A[i] >= j - i - A[j]) {
					answer++;
					if(answer > 10000000) return -1;
				}
			}
		}
		
		return answer;
    }
	
	/*
	 * Detected time complexity: O(N*log(N)) or O(N)
	 * Task Score 87% Correctness 100% Performance 75%
	 */
	public static int solution2(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		
		long[] min = new long[A.length];
		long[] max = new long[A.length];
		for(int i=0; i<A.length; i++) {
			min[i] = i - (long)A[i];
			max[i] = i + (long)A[i];
			//System.out.println(max[i] + ", " + min[i]);
		}
		
		Arrays.sort(min);
		Arrays.sort(max);
		
		for(int m=0; m<A.length-1; m++) {
			for(int n=m+1; n<A.length; n++) {
				//System.out.println(max[m] + ", " + min[n]);
				if(max[m] >= min[n]) {
					answer++;
					if(answer > 10000000) {
						return -1;
					}
				} else {
					break;
				}
			}
		}
		
		return answer;
    }
}
