/**
 * 
 */
package exercise;

/**
 * @author kyungstone
 *
 */
public class Test001 {

	boolean[] isCheck;
	int[] reArrays;
	int answer;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] params = { 20, 8, 10, 1, 4, 15 };

		Test001 t = new Test001();
		t.solution(params);
	}

	public void solution(int[] params) {
		answer = 0;

		isCheck = new boolean[params.length];
		reArrays = new int[params.length];
		
		dfs(params, 1);
		System.out.println("answer : " + answer);
	}

	public void dfs(int[] params, int cnt) {
		for(int i=0; i<params.length; i++) {
			if(!isCheck[i]) {
				isCheck[i] = true;
				reArrays[cnt-1] = params[i];
				if(cnt == params.length) {
					//System.out.print("[");
					//Arrays.stream(reArrays).forEach(n -> System.out.print(n + ", "));
					//System.out.print("]");
					int sum = 0;
					for(int j=0; j<params.length-1; j++) {
						sum += Math.abs(reArrays[j] - reArrays[j+1]);
						//System.out.print(", j = " + j + ", sum = " + sum);
						if(sum > answer) {
							answer = sum;
						}
					}
					//System.out.println("");
					//System.out.println("==============================");
				} else {
					dfs(params, cnt+1);
				}
				
				isCheck[i] = false;
			}
		}
	}
}