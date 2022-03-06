/**
 * 
 */
package Codility.Lesson10_PrimeAndCompositeNumbers;

/**
 * @author kyungstone
 *
 */

/*
 * Task description An integer N is given, representing the area of some
 * rectangle.
 * 
 * The area of a rectangle whose sides are of length A and B is A * B, and the
 * perimeter is 2 * (A + B).
 * 
 * The goal is to find the minimal perimeter of any rectangle whose area equals
 * N. The sides of this rectangle should be only integers.
 * 
 * For example, given integer N = 30, rectangles of area 30 are:
 * 
 * (1, 30), with a perimeter of 62, (2, 15), with a perimeter of 34, (3, 10),
 * with a perimeter of 26, (5, 6), with a perimeter of 22. Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given an integer N, returns the minimal perimeter of any rectangle
 * whose area is exactly equal to N.
 * 
 * For example, given an integer N = 30, the function should return 22, as
 * explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..1,000,000,000]. Copyright 2009–2022 by
 * Codility Limited. All Rights Reserved. Unauthorized copying, publication or
 * disclosure prohibited.
 */
public class MinPerimeterRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		N = 30;
		N = 1;
		N = 36;
		N = 100000000;
		System.out.println(MinPerimeterRectangle.solution(N));
	}
	
	/*
	 * Detected time complexity: O(sqrt(N)) 
	 * Task Score 100% Correctness 100% Performance 100%
	 * https://app.codility.com/demo/results/training4QUVWW-XYN/
	 */
	public static int solution(int N) {
        // write your code in Java SE 8
		int minSum = 1 + N;
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(N%i == 0) {
				System.out.println("i = " + i + ", N/i = " + N/i);
				minSum = Math.min(minSum, i + N/i);
			}
		}
		
		return minSum * 2;
    }
}
