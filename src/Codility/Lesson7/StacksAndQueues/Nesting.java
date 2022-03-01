/**
 * 
 */
package Codility.Lesson7.StacksAndQueues;

/**
 * @author kyungstone
 *
 */

/*
 * A string S consisting of N characters is called properly nested if:
 * 
 * S is empty; S has the form "(U)" where U is a properly nested string; S has
 * the form "VW" where V and W are properly nested strings. For example, string
 * "(()(())())" is properly nested but string "())" isn't.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if string S is
 * properly nested and 0 otherwise.
 * 
 * For example, given S = "(()(())())", the function should return 1 and given S
 * = "())", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..1,000,000]; string S consists only of
 * the characters "(" and/or ")". Copyright 2009–2022 by Codility Limited. All
 * Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Nesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String S = "(()(())())";
		String S = "())";
		System.out.println(Nesting.solution(S));
	}
	
	/*
	 * https://app.codility.com/demo/results/training55VJ6S-8T6/
	 * Detected time complexity: O(N)
	 * Task Score 100% Correctness 100% Performance 100%
	 */
	public static int solution(String S) {
        // write your code in Java SE 8
        int answer = 1;
        for(int i=0; i<S.length(); i++) {
        	char c = S.charAt(i);
        	if(c == 40) {
        		answer = answer + 1;
        	} else {
        		answer = answer - 1;
        	}
        	if(answer <= 0) {
        		return 0;
        	}
        }
        
        if(answer == 1) {
        	return 1;
        } else {
        	return 0;
        }
    }
}
