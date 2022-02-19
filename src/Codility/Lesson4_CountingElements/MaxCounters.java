/**
 * 
 */
package Codility.Lesson4_CountingElements;

import java.util.Arrays;

/**
 * @author kyungstone
 *
 */
public class MaxCounters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[] A = {3,4,4,6,1,4,4};
		
		//int N = 5;
		//int[] A = {3};
		
		MaxCounters maxCounters = new MaxCounters();
		Arrays.stream(maxCounters.solution(N, A)).forEach(num -> System.out.println(num));
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
}
