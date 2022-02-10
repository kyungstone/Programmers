/**
 * 
 */
package Programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kyungstone
 *
 */
public class MoreSpicy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoreSpicy moreSpicy = new MoreSpicy();
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		System.out.println(moreSpicy.solution(scoville, K));
	}
	
	public int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		Arrays.stream(scoville).forEach(s -> queue.add(s));
		
		while(queue.peek() < K) {
			if(queue.size() == 1) {
				return -1;
			}
			answer++;
			queue.add(queue.poll() + queue.poll()*2);
		}
		
		return answer;
	}
}
