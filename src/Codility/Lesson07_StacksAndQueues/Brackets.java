/**
 * 
 */
package Codility.Lesson07_StacksAndQueues;

import java.util.Stack;

/**
 * @author kyungstone
 *
 */

/*
 * Task description A string S consisting of N characters is considered to be
 * properly nested if any of the following conditions is true:
 * 
 * S is empty; S has the form "(U)" or "[U]" or "{U}" where U is a properly
 * nested string; S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if S is properly
 * nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S =
 * "([)()]", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..200,000]; string S consists only of the
 * following characters: "(", "{", "[", "]", "}" and/or ")". Copyright 2009–2022
 * by Codility Limited. All Rights Reserved. Unauthorized copying, publication
 * or disclosure prohibited.
 */
public class Brackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "{[()()]}";
		//String S = "{[)()(]}";
		//String S = "}[)()(]}";
		//char a = '{';
		//char b = '}';
		//char a = '(';
		//char b = ')';
		//char a = '[';
		//char b = ']';
		/*
		 * if('(' == 41) { System.out.println("!!"); }
		 */
		//System.out.println('{' - 0);
		System.out.println("Result = " + Brackets.solution4(S));
	}
	
	/*
	 * Detected time complexity: O(3**N)
	 * Task Score 50% Correctness 100% Performance 20%
	 */
	public static int solution(String S) {
        // write your code in Java SE 8
		int answer = 1;

        while(S.contains("()") || S.contains("[]") || S.contains("{}")) {
        	if(S.contains("()")) S = S.replaceAll("\\(\\)", "");
        	if(S.contains("[]")) S = S.replaceAll("\\[\\]", "");
        	if(S.contains("{}")) S = S.replaceAll("\\{\\}", "");
        }

        if(S.length() > 0) return 0;

        return answer;
    }
	
	/*
	 * Detected time complexity: O(3**N)
	 * Task Score 50% Correctness 100% Performance 20%
	 */
	public static int solution2(String S) {
        // write your code in Java SE 8
		Stack<String> stack = new Stack<String>();
		
        for(int i=0; i<S.length(); i++) {
        	String s = S.substring(i, i+1);
        	if(s.equals("(") || s.equals("[") || s.equals("{")) {
        		stack.add(s);
        		if(stack.size() > (S.length()-i+1)) {
        			return 0;
        		}
        	} else {
        		if(stack.isEmpty()) {
        			return 0;
        		} else {
        			String b = stack.pop();
            		String f = b + s;
            		if(!(f.equals("()") || f.equals("[]") || f.equals("{}"))) {
            			return 0;
            		}
        		}
        	}
        }
        
        if(stack.isEmpty()) {
        	return 1;
        } else {
        	return 0;
        }
    }
	
	public static int solution3(String S) {
        // write your code in Java SE 8
		Stack<Integer> stack = new Stack<Integer>();
		
        S = S.replace("(", "1").replace("[", "2").replace("{", "3").replace(")", "4").replace("]", "5").replace("}", "6");
        System.out.println(S);
        if(S.startsWith("4") || S.startsWith("5") || S.startsWith("6")) {
        	return 0;
        }
        
        for(int i=0; i<S.length(); i++) {
        	int num = Integer.parseInt(S.substring(i, i+1));
        	if(num < 4) {
        		stack.add(num);
        	} else {
        		if(num - stack.pop() != 3) {
        			return 0;
        		}
        	}
        }
        
        if(stack.isEmpty()) {
        	return 1;
        } else {
        	return 0;
        }
    }
	
	/*
	 * Detected time complexity: O(N)
	 * Task Score 100% Correctness 100% Performance 100%
	 */
	public static int solution4(String S) {
		Stack<Character> stack = new Stack<Character>();
		
        for(int i=0; i<S.length(); i++) {
        	char s = S.charAt(i);
        	if(s == 40 || s == 91 || s == 123) {
        		stack.add(s);
        		if(stack.size() > (S.length()-i+1)) {
        			return 0;
        		}
        	} else {
        		if(stack.isEmpty()) {
        			return 0;
        		} else {
        			if(Math.abs(stack.pop() - s) > 2) {
        				return 0;
        			}
        		}
        	}
        }
        
        if(stack.isEmpty()) {
        	return 1;
        } else {
        	return 0;
        }
	}
}
