/**
 * 
 */
package Test.Mar_01_2022;

/**
 * @author kyungstone
 *
 */
public class Test001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
		//int[] A = {5, 8};
		int[] A = {1, 1, 1, 1};
		System.out.println(Test001.solution(A));
	}
	
	//https://app.codility.com/c/feedback/EQWHDB-VPQ/
	public static int solution(int[] A) {
        // write your code in Java SE 8
        int answer = 0;

        int back = A[0];
        answer += back;
        //System.out.println("start = " + answer);
        for(int i=1; i<A.length; i++) {
            int current = A[i];
            //System.out.print("current = " + current);
            if(current > back) {
                answer = answer + current - back;
                //System.out.print(", answer = " + answer);
                if(answer > 1000000000) {
                	return -1;
                }
            }
            back = current;
            //System.out.println("");
        }

        return answer;
    }
}
