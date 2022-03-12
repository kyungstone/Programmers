/**
 * 
 */
package Test.Feb_06_2022;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kyungstone
 *
 */
public class Test002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] params = {24, 22, 20, 10, 5, 3, 2, 1};
		//int K = 3;
		int[] params = {1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486
		, 157658638, 157658634, 100000000, 100};
		int K = 2;
		System.out.println(Test002.solution(K, params));
	}
	
	public static int solution(int K, int[] params) {
		int answer = params.length;
		
		int[] num = new int[params.length-1];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=1; i<params.length; i++) {
			num[i-1] = params[i-1] - params[i];
			map.put(num[i-1], map.getOrDefault(num[i-1], 0)+1);
			//System.out.println(num[i-1] + ", " + map.get(num[i-1]));
		}
		//Arrays.stream(num).forEach(n -> System.out.println(n));
		
		boolean overlap = false;
		for(int j=0; j<num.length; j++) {
			if(map.get(num[j]) >= K) {
				if(overlap) {
					answer -= 1;
				} else {
					answer -= 2;
				}
				
				overlap = true;
			} else {
				overlap = false;
			}
		}
		
		return answer;
	}
}
