package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	
	/**
	 * [BOJ] 나는야 포켓몬 마스터 이다솜 / Silver 4
	 * @see https://www.acmicpc.net/problem/1620
	 * @author D15M4S
	 */
	
	public static void main(String[] args) throws Exception {
		
		// 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 도감 저장
		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> reverseMap = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String pokemon = br.readLine();
			map.put(i, pokemon);
			reverseMap.put(pokemon, i);
		}
		
		// 문제 풀이
		for(int i = 0; i < M; i++) {
			String question = br.readLine();
			
			if('0' <= question.charAt(0) && question.charAt(0) <= '9') {
				System.out.println(map.get(Integer.parseInt(question)));
			}else {
				System.out.println(reverseMap.get(question));
			}
		}	
	}
}
