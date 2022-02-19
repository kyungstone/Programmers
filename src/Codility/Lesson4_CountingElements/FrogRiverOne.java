/**
 * 
 */
package Codility.Lesson4_CountingElements;

import java.util.HashSet;

/**
 * @author kyungstone
 *
 */
public class FrogRiverOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int X = 5;
		//int[] A = {1,3,2,4,1,3,5,4};
		
		//int X = 1;
		//int[] A = {1};
		
		int X = 2;
		int[] A = {2,2,2,2};
		
		FrogRiverOne frogRiverOne = new FrogRiverOne();
		System.out.println(frogRiverOne.solution(X, A));
	}
	
	public int solution(int X, int[] A) {
        // write your code in Java SE 8
		int answer = -1;
		
		HashSet<Integer> numSet = new HashSet<Integer>();
		for(int i=0; i<A.length; i++) {
			if(A[i] <= X) {
				numSet.add(A[i]);
			}
			if(numSet.size() == X) {
				answer = i;
				break;
			}
			
		}
		
		return answer;
    }
}
