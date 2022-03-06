/**
 * 
 */
package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author kyungstone
 *
 */

/*
깊이/너비 우선 탐색(DFS/BFS)
타겟 넘버
문제 설명
n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.
입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.

입출력 예 #2

+4+1-2+1 = 4
+4-1+2-1 = 4
총 2가지 방법이 있으므로, 2를 return 합니다.
https://programmers.co.kr/learn/courses/30/lessons/43165/solution_groups?language=java
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
