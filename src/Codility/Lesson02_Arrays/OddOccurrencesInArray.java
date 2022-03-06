/**
 * 
 */
package Codility.Lesson02_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kyungstone
 *
 */

/*
 * Task description A non-empty array A consisting of N integers is given. The
 * array contains an odd number of elements, and each element of the array can
 * be paired with another element that has the same value, except for one
 * element that is left unpaired.
 * 
 * For example, in array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the elements
 * at indexes 0 and 2 have value 9, the elements at indexes 1 and 3 have value
 * 3, the elements at indexes 4 and 6 have value 9, the element at index 5 has
 * value 7 and is unpaired. Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers fulfilling the above
 * conditions, returns the value of the unpaired element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the function
 * should return 7, as explained in the example above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an odd integer within the range [1..1,000,000]; each element of array A
 * is an integer within the range [1..1,000,000,000]; all but one of the values
 * in A occur an even number of times. Copyright 2009–2022 by Codility Limited.
 * All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.
 */
public class OddOccurrencesInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,3,9,3,9,7,9};
		
		OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
		System.out.println(oddOccurrencesInArray.solution5(A));
	}
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		List<Integer> numberList = Arrays.stream(A).boxed().collect(Collectors.toList());
		int pairSeq = -1, num = 0;
		while(numberList.size() != 1) {
			for(int i=0; i<numberList.size(); i++) {
				int temp = numberList.get(i);
				if(pairSeq == -1) {
					pairSeq = i;
					num = temp;
				} else if(num == temp) {
					numberList.remove(i);
					numberList.remove(pairSeq);
					pairSeq = -1;
					break;
				}
			}
		}
		
		return numberList.get(0);
    }
	
	public int solution2(int[] A) {
        // write your code in Java SE 8
		List<Integer> numberList = new ArrayList<Integer>();
		for(int num : A) {
			if(numberList.contains(num)) {
				numberList.remove(numberList.indexOf(num));
			} else {
				numberList.add(num);
			}
		}
		
		return numberList.get(0);
    }
	
	public int solution3(int[] A) {
		int answer = 0;
		Master:
		for(int i=0; i<A.length; i++) {
			answer = A[i];
			for(int j=0; j<A.length; j++) {
				if(i != j && answer == A[j]) {
					continue Master;
				}
			}
			
			break;
		}
		
		return answer;
    }
	
	public int solution4(int[] A) {
		int answer = 0;
		
		Arrays.sort(A);
		for(int i=0; i<A.length; i++) {
			if(i%2 == 0) {
				answer += A[i];
			} else {
				answer -= A[i];
			}
		}
		
		return answer;
    }
	
	public int solution5(int[] A) {
		// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=mouse226&logNo=221304567474
		int answer = 0;
        
        for(int i=0; i<A.length; i++){
        	answer = answer^A[i];
            //System.out.println(res);
        }
        return answer;
    }
}
