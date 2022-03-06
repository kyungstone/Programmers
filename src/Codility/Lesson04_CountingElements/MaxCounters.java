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
 * Task description You are given N counters, initially set to 0, and you have
 * two possible operations on them:
 * 
 * increase(X) − counter X is increased by 1, max counter − all counters are set
 * to the maximum value of any counter. A non-empty array A of M integers is
 * given. This array represents consecutive operations:
 * 
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X), if A[K] =
 * N + 1 then operation K is max counter. For example, given integer N = 5 and
 * array A such that:
 * 
 * A[0] = 3 A[1] = 4 A[2] = 4 A[3] = 6 A[4] = 1 A[5] = 4 A[6] = 4 the values of
 * the counters after each consecutive operation will be:
 * 
 * (0, 0, 1, 0, 0) (0, 0, 1, 1, 0) (0, 0, 1, 2, 0) (2, 2, 2, 2, 2) (3, 2, 2, 2,
 * 2) (3, 2, 2, 3, 2) (3, 2, 2, 4, 2) The goal is to calculate the value of
 * every counter after all operations.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int N, int[] A); }
 * 
 * that, given an integer N and a non-empty array A consisting of M integers,
 * returns a sequence of integers representing the values of the counters.
 * 
 * Result array should be returned as an array of integers.
 * 
 * For example, given:
 * 
 * A[0] = 3 A[1] = 4 A[2] = 4 A[3] = 6 A[4] = 1 A[5] = 4 A[6] = 4 the function
 * should return [3, 2, 2, 4, 2], as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N and M are integers within the range [1..100,000]; each element of array A
 * is an integer within the range [1..N + 1]. Copyright 2009–2022 by Codility
 * Limited. All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.
 */
public class MaxCounters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[] A = {3,4,4,6,1,4,4};
		//int[] A = {3,4,4,6,1,4,4,3,4,4,6,1,4,4};
		
		//int N = 5;
		//int[] A = {3};
		
		//int N = 5;
		//int[] A = {1,2,3,4,4,5,6,7};
		
		MaxCounters maxCounters = new MaxCounters();
		Arrays.stream(maxCounters.solution4(N, A)).forEach(num -> System.out.println(num));
	}
	
	public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
		int[] answer = new int[N];
		int maxNum = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] >= 0 && A[i] <= N) {
				int tempNum = answer[A[i]-1] + 1;
				answer[A[i]-1] = tempNum;
				if(tempNum > maxNum) {
					maxNum = tempNum;
				}
			} else if(A[i] == N+1) {
				for(int j=0; j<answer.length; j++) {
					answer[j] = maxNum;
				}
			}
			
			Arrays.stream(answer).forEach(num -> System.out.print(" " + num));
			System.out.println();
		}
		
		return answer;
    }
	
	public int[] solution2(int N, int[] A) {
        // write your code in Java SE 8
		int[] answer = new int[N];
		int basicNum = 0;
		int maxNum = 0;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] <= N) {
				answer[A[i]-1] += 1;
				if(basicNum + answer[A[i]-1] > maxNum) {
					maxNum = basicNum + answer[A[i]-1];
				}
			} else {
				answer = new int[N];
				basicNum = maxNum;
			}
			
			//Arrays.stream(answer).forEach(num -> System.out.print(" " + num));
			//System.out.println();
		}
		
		for(int j=0; j<answer.length; j++) {
			answer[j] = answer[j] + basicNum;
		}
		
		return answer;
    }
	
	public int[] solution3(int N, int[] A) {
        // write your code in Java SE 8
		int[] answer = new int[N];
		int maxNum = 0;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] <= N) {
				answer[A[i]-1] += 1;
				if(answer[A[i]-1] > maxNum) {
					maxNum = answer[A[i]-1];
				}
			} else {
				Arrays.fill(answer, maxNum);
			}
			
			Arrays.stream(answer).forEach(num -> System.out.print(" " + num));
			System.out.println();
		}
		
		return answer;
    }
	
	public int[] solution4(int N, int[] A) {
        // write your code in Java SE 8
		// https://denken-y.tistory.com/entry/Codility-MaxCounters
		// https://cchoimin.tistory.com/entry/CodilityMaxCounters
		int[] answer = new int[N];
		int maxNum = 0;
		int currentNum = 0;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] <= N) {
				int idx = A[i] - 1;
				answer[idx] = Math.max(maxNum, answer[idx]) + 1;
				currentNum = Math.max(currentNum, answer[idx]);
			} else {
				maxNum = currentNum;
			}
		}
		
		for(int j=0; j<answer.length; j++) {
			answer[j] = Math.max(maxNum, answer[j]);
		}
		
		
		return answer;
    }
}
