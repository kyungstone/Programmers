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
