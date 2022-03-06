/**
 * 
 */
package Codility.Lesson10_PrimeAndCompositeNumbers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kyungstone
 *
 */

/*
 * Task description A positive integer D is a factor of a positive integer N if
 * there exists an integer M such that N = D * M.
 * 
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition
 * (24 = 6 * 4).
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the number of its factors.
 * 
 * For example, given N = 24, the function should return 8, because 24 has 8
 * factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..2,147,483,647]. Copyright 2009–2022 by
 * Codility Limited. All Rights Reserved. Unauthorized copying, publication or
 * disclosure prohibited.
 */
public class CountFactors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		//N = 1;
		//N = 24;
		//N = 9;
		//N = 111;
		N = 2147483647;
		System.out.println(Math.sqrt(N));
		System.out.println(CountFactors.solution2(N));
	}
	
	/*
	 * Detected time complexity: O(N)
	 * Task Score 71% Correctness 100% Performance 33%
	 * https://app.codility.com/demo/results/training6D729C-RCN/
	 */
	public static int solution(int N) {
        // write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<=Math.ceil((double)N/2); i++) {
			if(set.contains(i)) {
				break;
			} else if(N%i == 0) {
				set.add(i);
				set.add(N/i);
			}
		}
		
		return set.size();
    }
	
	/*
	 * Detected time complexity: O(sqrt(N))
	 * Task Score 100% Correctness 100% Performance 100%
	 * https://app.codility.com/demo/results/training3ECBRH-QQF/
	 */
	public static int solution2(int N) {
        // write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<=Math.sqrt(N); i++) {
			if(set.contains(i)) {
				break;
			} else if(N%i == 0) {
				set.add(i);
				set.add(N/i);
			}
		}
		
		return set.size();
    }
}
