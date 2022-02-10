/**
 * 
 */
package Programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author kyungstone
 *
 */
public class TargetNumber {

	/**
	 * @param args
	 * 한글 한글
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TargetNumber targetNumber = new TargetNumber();
		
		//int[] numbers = {1, 1, 1, 1, 1}; int target = 3;
		
		int[] numbers = {4, 1, 2, 1}; int target = 4;
		
		System.out.println(targetNumber.solution(numbers, target));
	}
	
	public int answer;
	public int checkCnt;
	public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
	
	public void dfs(int[] numbers, int target, int sum, int idx) {
		checkCnt++;
		System.out.println("Check count = " + checkCnt + ", index = " + idx + ", sum = " + sum);
		if(idx == numbers.length) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		
		int case1 = sum + numbers[idx];
		int case2 = sum - numbers[idx];
		
		dfs(numbers, target, case1, idx+1);
		dfs(numbers, target, case2, idx+1);
	}
	
	class NumInfo {
		int sum;
		int idx;
		
		public NumInfo(int sum, int idx) {
			this.sum = sum;
			this.idx = idx;
		}
	}
	
	public void dfsWithStack(int[] numbers, int target, int sum, int idx) {
		Stack<NumInfo> stack = new Stack<NumInfo>();
		NumInfo numInfo = new NumInfo(sum, idx);
		stack.push(numInfo);
		
		while(!stack.empty()) {
			checkCnt++;
			NumInfo curNumInfo = stack.pop();
			int curIdx = curNumInfo.idx;
			int curSum = curNumInfo.sum;
			System.out.println("Check count = " + checkCnt + ", index = " + curIdx + ", sum = " + curSum);
			if(curIdx == numbers.length) {
				if(curSum == target) {
					answer++;
				}
			} else {
				NumInfo numInfo1 = new NumInfo(curSum+numbers[curIdx], curIdx+1);
				NumInfo numInfo2 = new NumInfo(curSum-numbers[curIdx], curIdx+1);
				stack.add(numInfo1);
				stack.add(numInfo2);
			}
		}
	}
	
	public void bfs(int[] numbers, int target, int sum, int idx) {
		Queue<NumInfo> queue = new LinkedList<NumInfo>();
		NumInfo numInfo = new NumInfo(sum, idx);
		queue.add(numInfo);
		
		while(!queue.isEmpty()) {
			checkCnt++;
			NumInfo curNumInfo = queue.poll();
			int curIdx = curNumInfo.idx;
			int curSum = curNumInfo.sum;
			System.out.println("Check count = " + checkCnt + ", index = " + curIdx + ", sum = " + curSum);
			if(curIdx == numbers.length) {
				if(curSum == target) {
					answer++;
				}
			} else {
				NumInfo numInfo1 = new NumInfo(curSum+numbers[curIdx], curIdx+1);
				NumInfo numInfo2 = new NumInfo(curSum-numbers[curIdx], curIdx+1);
				queue.add(numInfo1);
				queue.add(numInfo2);
			}
		}
	}
}
