/**
 * 
 */
package Programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kyungstone
 *
 */

/*
 * K번째수 문제 설명 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 * 
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 * 
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다. 2에서
 * 나온 배열의 3번째 숫자는 5입니다. 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질
 * 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution
 * 함수를 작성해주세요.
 * 
 * 제한사항 array의 길이는 1 이상 100 이하입니다. array의 각 원소는 1 이상 100 이하입니다. commands의 길이는 1
 * 이상 50 이하입니다. commands의 각 원소는 길이가 3입니다. 입출력 예 array commands return [1, 5, 2,
 * 6, 3, 7, 4] [[2, 5, 3], [4, 4, 1], [1, 7, 3]] [5, 6, 3] 입출력 예 설명 [1, 5, 2, 6,
 * 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다. [1, 5, 2, 6,
 * 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다. [1, 5, 2, 6, 3, 7, 4]를
 * 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
 * https://neerc.ifmo.ru/subregions/northern.html
 * https://programmers.co.kr/learn/courses/30/lessons/42748/solution_groups?language=java
 */
public class NumberOfK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		Arrays.stream(NumberOfK.solution(array, commands)).forEach(num -> System.out.println(num));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> origin = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> target;
        int idx = 0;
        for(int[] i:commands) {
        	target = new ArrayList<Integer>(origin);
        	Collections.copy(target, origin);
        	target = target.subList(i[0]-1, i[1]);
        	target.sort(Comparator.naturalOrder());
        	answer[idx] = target.get(i[2]-1);
        	idx++;
        }
        
        return answer;
    }
}
