/**
 * 
 */
package Codility.Lesson08_Leader;

import java.util.Arrays;

/**
 * @author kyungstone
 *
 */

/*
 * Task description A non-empty array A consisting of N integers is given.
 * 
 * The leader of this array is the value that occurs in more than half of the
 * elements of A.
 * 
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0],
 * A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the
 * same value.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 we can find two equi
 * leaders:
 * 
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose
 * value is 4. 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same
 * leader, whose value is 4. The goal is to count the number of equi leaders.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the number
 * of equi leaders.
 * 
 * For example, given:
 * 
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 the function should
 * return 2, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000,000..1,000,000,000]. Copyright 2009–2022
 * by Codility Limited. All Rights Reserved. Unauthorized copying, publication
 * or disclosure prohibited.
 */
public class EquiLeader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4, 3, 4, 4, 4, 2};
		//int[] A = {4, 4, 2, 5, 3, 4, 4, 4};
		System.out.println(EquiLeader.solution(A));
	}
	
	/*
	 * Detected time complexity: O(N)
	 * Task Score 100% Correctness 100% Performance 100%
	 * https://app.codility.com/demo/results/trainingASVDNS-NNA/
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		
		int[] B = A.clone();
		Arrays.sort(A);
		int leader = A[A.length/2];
		System.out.println("leader : " + leader);
		int count = 0;
		for(int num : A) {
			if(num == leader) count++;
			else if(num > leader) break;
		}
		System.out.println("count : " + count);
		int check = 0;
		for(int i=0; i<B.length; i++) {
			if(leader == B[i]) {
				check++;
				count--;
			}
			if(check*2 > i+1 && count*2 > B.length-i-1) {
				System.out.println("answer : " + answer + ", i : " + i + ", count : " + count);
				answer++;
			}
		}
		
		return answer;
    }
}
