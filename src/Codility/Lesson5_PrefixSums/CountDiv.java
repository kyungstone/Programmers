/**
 * 
 */
package Codility.Lesson5_PrefixSums;

/**
 * @author kyungstone
 *
 */
public class CountDiv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int A = 6;
		int A = 0;
		//int B = 11;
		int B = 0;
		//int K = 1;
		int K = 11;
		
		CountDiv countDiv = new CountDiv();
		System.out.println(countDiv.solution(A, B, K));
	}
	
	public int solution(int A, int B, int K) {
        // write your code in Java SE 8
		int min = (int) Math.ceil((double)A/K);
		System.out.println(min);
		
		int max = (int) Math.floor((double)B/K);
		System.out.println(max);
		
		return max - min + 1;
    }
}
