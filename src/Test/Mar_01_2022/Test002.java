/**
 * 
 */
package Test.Mar_01_2022;

import java.util.Stack;

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
		String S = "ACBDACBD";
		//String S = "ABABCDCDDC";
		System.out.println(Test002.solution(S));
	}
	
	public static String solution(String S) {
        // write your code in Java SE 8
        String answer = "";
        Stack<Character> stack = new Stack<Character>();
        stack.add(S.charAt(0));

        for(int i=1; i<S.length(); i++) {
            char current = S.charAt(i);
            if(stack.isEmpty()) {
            	stack.add(current);
            } else {
            	char back = stack.pop();
                if(!(back + current == 131 || back + current == 135)) {
                    stack.add(back);
                    stack.add(current);
                }
            }
        }

        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        return new StringBuffer(answer).reverse().toString();
    }
}
