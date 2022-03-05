/**
 * 
 */
package Codility.Lesson7.StacksAndQueues;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author kyungstone
 *
 */

/*
 * Task description You are going to build a stone wall. The wall should be
 * straight and N meters long, and its thickness should be constant; however, it
 * should have different heights in different places. The height of the wall is
 * specified by an array H of N positive integers. H[I] is the height of the
 * wall from I to I+1 meters to the right of its left end. In particular, H[0]
 * is the height of the wall's left end and H[N−1] is the height of the wall's
 * right end.
 * 
 * The wall should be built of cuboid stone blocks (that is, all sides of such
 * blocks are rectangular). Your task is to compute the minimum number of blocks
 * needed to build the wall.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] H); }
 * 
 * that, given an array H of N positive integers specifying the height of the
 * wall, returns the minimum number of blocks needed to build it.
 * 
 * For example, given array H containing N = 9 integers:
 * 
 * H[0] = 8 H[1] = 8 H[2] = 5 H[3] = 7 H[4] = 9 H[5] = 8 H[6] = 7 H[7] = 4 H[8]
 * = 8 the function should return 7. The figure shows one possible arrangement
 * of seven blocks.
 * 
 * 
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array H is an
 * integer within the range [1..1,000,000,000]. Copyright 2009–2022 by Codility
 * Limited. All Rights Reserved. Unauthorized copying, publication or disclosure
 * prohibited.
 */
public class StoneWall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
		System.out.println(StoneWall.solution3(H));
	}
	
	/*
	 * Detected time complexity: O(N**2)
	 * Task Score 71% Correctness 100% Performance 55%
	 * https://app.codility.com/demo/results/trainingKBXA2W-294/
	 */
	public static int solution(int[] H) {
        // write your code in Java SE 8
		int answer = 0;
		
		Queue<Block> queue = new PriorityQueue<Block>();
		for(int i=0; i<H.length; i++) {
			Block block = new Block(i, H[i]);
			queue.add(block);
		}
		
		List<Integer> list = new ArrayList<Integer>();
		Block bBlock = queue.poll();
		list.add(bBlock.getPosition());
		answer++;
		while(!queue.isEmpty()) {
			Block aBlock = queue.poll();
			if(bBlock.getHeigth() < aBlock.getHeigth()) {
				answer++;
			} else {
				for(int i=0; i<list.size(); i++) {
					if(bBlock.getPosition() < list.get(i) && aBlock.getPosition() > list.get(i)) {
						answer++;
						break;
					}
				}
			}
			bBlock = aBlock;
			list.add(bBlock.getPosition());
		}
		//Arrays.stream(H).forEach(num -> queue.add(0, num));
		/*
		 * while(!queue.isEmpty()) { Block temp = queue.poll();
		 * System.out.println(temp.getHeigth() + ", " + temp.getPosition()); }
		 */
		
		return answer;
    }
	
	static class Block implements Comparable<Block> {
		
		private int position;
		private int heigth;
		
		public Block(int position, int heigth) {
			this.position = position;
			this.heigth = heigth;
		}
		
		public int getPosition() {
			return this.position;
		}
		
		public int getHeigth() {
			return this.heigth;
		}

		@Override
		public int compareTo(Block o) {
			// TODO Auto-generated method stub
			if(this.heigth > o.getHeigth()) {
				return 1;
			} else if(this.heigth < o.getHeigth()) {
				return -1;
			} else {
				if(this.position > o.getPosition()) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}
	
	public static int solution2(int[] H) {
        // write your code in Java SE 8
		int answer = 1;
		
		int min = H[0];
		int before = H[0];
		Set<Integer> set = new HashSet<Integer>();
		set.add(min);
		
		for(int i=1; i<H.length; i++) {
			int num = H[i];
			System.out.print("before : " + before + ", num : " + num + ", min : " + min);
			if(before < num) {
				answer++;
				System.out.print(", case1");
			} else {
				if(!set.contains(num)) {
					answer++;
					System.out.print(", case2");
				}
				if(min >= num) {
					System.out.print(", clear");
					set.clear();
					min = num;
				}
			}
			set.add(num);
			before = num;
			System.out.print(", size" + set.size());
			System.out.println("");
		}
		
		return answer;
    }
	
	/*
	 * Detected time complexity: O(N) 
	 * Task Score 100% Correctness 100% Performance 100%
	 * https://jobjava00.github.io/algorithm/codility/lesson7/StoneWall/
	 * https://app.codility.com/demo/results/trainingTUPWNU-G73/
	 */
	public static int solution3(int[] H) {
        // write your code in Java SE 8
		int answer = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<H.length; i++) {
			int num = H[i];
			while(!stack.isEmpty() && stack.peek() > num) {
				stack.pop();
			}
			if(stack.isEmpty() || stack.peek() < num) {
				answer++;
				stack.add(num);
			}
		}
		
		return answer;
    }
}
