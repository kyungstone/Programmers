/**
 * 
 */
package Codility.Lesson8_Leader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author kyungstone
 *
 */

/*
 * Task description An array A consisting of N integers is given. The dominator
 * of array A is the value that occurs in more than half of the elements of A.
 * 
 * For example, consider array A such that
 * 
 * A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3 The
 * dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in
 * those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * 
 * Write a function
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns index of any element
 * of array A in which the dominator of A occurs. The function should return −1
 * if array A does not have a dominator.
 * 
 * For example, given array A such that
 * 
 * A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3 the
 * function may return 0, 2, 4, 6 or 7, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Copyright 2009–2022
 * by Codility Limited. All Rights Reserved. Unauthorized copying, publication
 * or disclosure prohibited.
 */
public class Dominator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
		int[] A = {1, 2, 1};
		System.out.println(Dominator.solution2(A));
	}
	
	/*
	 * Detected time complexity: O(N**2)
	 * Task Score 75% Correctness 100% Performance 25%
	 * https://app.codility.com/demo/results/trainingAMZBF9-DP6/
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		Arrays.stream(A).forEach(num -> set.add(num));
		int half = A.length/2;
		System.out.println("half : " + half);
		int num;
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			int count = 0;
			num = iter.next();
			System.out.println("num : " + num);
			//System.out.println(iter.next());
			for(int i=0; i<A.length; i++) {
				if(A[i] == num) {
					count++;
					System.out.print(", i : " + i);
					if(count > half) {
						return i;
					}
				}
			}
			System.out.println("");
		}
		
		return -1;
    }
	
	/*
	 * Detected time complexity: O(N*log(N)) or O(N)
	 * Task Score 100% Correctness 100% Performance 100%
	 * https://app.codility.com/demo/results/training6ETNPP-SXC/
	 */
	public static int solution2(int[] A) {
        // write your code in Java SE 8
		if(A.length != 0) {
			int[] B = A.clone();
			Arrays.sort(A);
			int basic = A.length/2;
			int num = A[basic];
			int count = 0;
			for(int i=0; i<B.length; i++) {
				if(num == B[i]) {
					count++;
					if(count > basic) {
						return i;
					}
				}
			}
		}
		
		return -1;
    }
}
