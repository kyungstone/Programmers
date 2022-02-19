/**
 * 
 */
package Codility.Lesson1_Iterations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author kyungstone
 *
 *
 */

/*
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps. The number
 * 32 has binary representation 100000 and has no binary gaps.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the length of its longest binary
 * gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5. Given N = 32 the function should return 0, because N has binary
 * representation '100000' and thus no binary gaps.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..2,147,483,647]. Copyright 2009–2022 by
 * Codility Limited. All Rights Reserved. Unauthorized copying, publication or
 * disclosure prohibited.
 */

public class BinaryGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1041;
		BinaryGap binaryGap = new BinaryGap();
		//System.out.println("Result : " + binaryGap.solution(N));
		System.out.println("Result : " + binaryGap.solution2(N));
	}
	
	public int solution(int N) {
        // write your code in Java SE 8
		int zeroSize = 0;
		List<Integer> binaryList = new ArrayList<Integer>();
		while(N!=1) {
			binaryList.add(N%2);
			N = (int) Math.floor(N/2);
		}
		binaryList.add(N);
		Collections.reverse(binaryList);
		
		int tempSize = 0;
		for(int i:binaryList) {
			if(i==1) {
				if(tempSize > zeroSize) {
					zeroSize = tempSize;
				}
				tempSize = 0;
			} else {
				tempSize++;
			}
		}
		
		return zeroSize;
    }
	
	public int solution2(int N) {
        // write your code in Java SE 8
		int zeroSize = 0;
		Stack<Integer> binaryStack = new Stack<Integer>();
		while(N!=1) {
			binaryStack.add(N%2);
			N = (int) Math.floor(N/2);
		}
		binaryStack.add(N);
		
		int tempSize = 0;
		while(!binaryStack.isEmpty()) {
			int binary = binaryStack.pop();
			if(binary==1) {
				if(tempSize > zeroSize) {
					zeroSize = tempSize;
				}
				tempSize = 0;
			} else {
				tempSize++;
			}
		}
		
		return zeroSize;
    }
}
