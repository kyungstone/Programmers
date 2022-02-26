/**
 * 
 */
package Codility.Lesson5_PrefixSums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kyungstone
 *
 */

/*
 * Task description
 * A DNA sequence can be represented as a string consisting of
 * the letters A, C, G and T, which correspond to the types of successive
 * nucleotides in the sequence. Each nucleotide has an impact factor, which is
 * an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3
 * and 4, respectively. You are going to answer several queries of the form:
 * What is the minimal impact factor of nucleotides contained in a particular
 * part of the given DNA sequence?
 * 
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1]
 * consisting of N characters. There are M queries, which are given in non-empty
 * arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M)
 * requires you to find the minimal impact factor of nucleotides contained in
 * the DNA sequence between positions P[K] and Q[K] (inclusive).
 * 
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 The answers to these M
 * = 3 queries are as follows:
 * 
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C
 * (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose
 * impact factor is 4, so the answer is 4. The part between positions 0 and 6
 * (the whole string) contains all nucleotides, in particular nucleotide A whose
 * impact factor is 1, so the answer is 1. Write a function:
 * 
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * 
 * that, given a non-empty string S consisting of N characters and two non-empty
 * arrays P and Q consisting of M integers, returns an array consisting of M
 * integers specifying the consecutive answers to all queries.
 * 
 * Result array should be returned as an array of integers.
 * 
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 the function should
 * return the values [2, 4, 1], as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; M is an integer within the
 * range [1..50,000]; each element of arrays P and Q is an integer within the
 * range [0..N − 1]; P[K] ≤ Q[K], where 0 ≤ K < M; string S consists only of
 * upper-case English letters A, C, G, T. Copyright 2009–2022 by Codility
 * Limited. All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.
 */
public class GenomicRangeQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String S = "CAGCCTA";
		//int[] P = {2, 5, 0};
		//int[] Q = {4, 5, 6};
		
		String S = "AC";
		int[] P = {0, 0, 1};
		int[] Q = {0, 1, 1};
		
		GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
		Arrays.stream(genomicRangeQuery.solution3(S, P, Q)).forEach(n -> System.out.println(n));
	}
	
	/* Detected time complexity: O(N * M) */
	/* Task Score 62% Correctness 100% Performance 0% */
	public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
		int[] answer = new int[Q.length];
		
		for(int i=0; i<Q.length; i++) {
			int startIdx = 0;
			if(P.length < i+1) {
				startIdx = Q[i];
			} else {
				startIdx = P[i];
			}
			String temp = S.substring(startIdx, Q[i]+1);
			//System.out.println(temp);
			if(temp.contains("A")) {
				answer[i] = 1;
			} else if(temp.contains("C")) {
				answer[i] = 2;
			} else if(temp.contains("G")) {
				answer[i] = 3;
			} else if(temp.contains("T")) {
				answer[i] = 4;
			}
		}
		
		return answer;
    }
	
	/* Detected time complexity: O(N * M) */
	/* Task Score 62% Correctness 100% Performance 0% */
	public int[] solution2(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
		int[] answer = new int[Q.length];
		
		for(int i=0; i<Q.length; i++) {
			int startIdx = 0;
			if(P.length < i+1) {
				startIdx = Q[i];
			} else {
				startIdx = P[i];
			}
			String temp = S.substring(startIdx, Q[i]+1);
			//System.out.println(temp);
			List<String> charList = Arrays.asList(temp.split("")).stream().distinct().collect(Collectors.toList());
			if(charList.contains("A")) {
				answer[i] = 1;
			} else if(charList.contains("C")) {
				answer[i] = 2;
			} else if(charList.contains("G")) {
				answer[i] = 3;
			} else if(charList.contains("T")) {
				answer[i] = 4;
			}
		}
		
		return answer;
    }
	
	/*
	 * https://jackjeong.tistory.com/44
	 * Detected time complexity: O(N + M) Task
	 * Score 100% Correctness 100% Performance 100%
	 */
	public int[] solution3(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
		int[] answer = new int[Q.length];
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		int[][] genomic = new int[S.length()+1][map.size()];
		int[] prefixSums = {0, 0, 0, 0};
		char[] chatArray = S.toCharArray();
		for(int i=0; i<chatArray.length; i++) {
			prefixSums[map.get(chatArray[i])]++;
			for(int j=0; j<map.size(); j++) {
				genomic[i][j] = prefixSums[j];
			}
		}
		
		for(int k=0; k<Q.length; k++) {
			for(int m=0; m<map.size(); m++) {
				int end = genomic[Q[k]][m];
				int start = P[k] == 0 ? 0 : genomic[P[k]-1][m];
				if(end - start > 0) {
					answer[k] = m+1;
					break;
				}
			}
		}
		
		return answer;
    }
}