/**
 * 
 */
package Programmers.Level1;

/**
 * @author kyungstone
 *
 */

/*
Summer/Winter Coding(~2018)
소수 만들기

소수 만들기
문제 설명
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
입출력 예
nums	result
[1,2,3,4]	1
[1,2,7,6,4]	4
입출력 예 설명
입출력 예 #1
[1,2,4]를 이용해서 7을 만들 수 있습니다.

입출력 예 #2
[1,2,4]를 이용해서 7을 만들 수 있습니다.
[1,4,6]을 이용해서 11을 만들 수 있습니다.
[2,4,7]을 이용해서 13을 만들 수 있습니다.
[4,6,7]을 이용해서 17을 만들 수 있습니다.
 */
public class MakePrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {1,2,3,4};
		int[] nums = {1,2,7,6,4};
		
		System.out.println(MakePrimeNumber.solution(nums));
	}
	
	static int answer = 0;
	public static int solution(int[] nums) {

        dfs(nums, 0, 0, 0);

        return answer;
    }
	
	/* +5 */
	public static void dfs(int[] nums, int idx, int sum, int cnt) {
		Loop1:
		for(int i=idx; i<nums.length; i++) {
			int num = nums[i];
			System.out.println("num : " + num + ", idx : " + idx + ", sum : " + sum + ", cnt : " + cnt);
			if(cnt == 2) {
				for(int j=2; j<=Math.sqrt(sum + num); j++) {
					if((sum + num) % j == 0) {
						continue Loop1;
					}
				}
				System.out.println("Prime number : " + (sum + num));
				answer++;
			} else {
				dfs(nums, i+1, sum + num, cnt+1);
			}
		}
	}
}
