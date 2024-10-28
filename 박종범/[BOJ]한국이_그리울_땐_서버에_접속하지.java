package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	/**
	 * [BOJ] 한국이 그리울 땐 서버에 접속하지 / Silver 3
	 * 
	 * @see https://www.acmicpc.net/problem/9996
	 * @author D15M4S
	 */
	public static void main(String args[]) throws Exception{
		
		// 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringBuilder input = new StringBuilder(br.readLine());
		
		
		// 정규표현식 분석
		StringBuilder start = new StringBuilder();
		StringBuilder end = new StringBuilder();
		
		// start 분석
		for(int i = 0; i < input.length(); i++) {
			
			char ch = input.charAt(i);
			
			if(ch == '*')
				break;
			else
				start.append(ch);			
		}
		
		// end 분석
		input = input.reverse();
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if(ch == '*')
				break;
			else
				end.append(ch);	
		}
		
		boolean isComplete = true;
		boolean[] result = new boolean[count];
		
		
		
		// 검증
		for(int i = 0; i < count; i++) {
			
			result[i] = true;
			StringBuilder validation = new StringBuilder(br.readLine());
			
		    // `validation`이 `start`와 `end` 패턴을 포함할 만큼 충분히 긴지 확인
		    if (validation.length() < start.length() + end.length()) {
		        result[i] = false;
		        continue;
		    }
			
			// Start 검증
			for(int j = 0; j < start.length(); j++) {
				if(validation.charAt(j) != start.charAt(j)) {
					result[i] = false;
					continue;
				}
			}
				
			validation = validation.reverse();
			
			//End 검증
			for(int j = 0; j < end.length(); j++) {
				if(validation.charAt(j) != end.charAt(j)) {
					result[i] = false;
					continue;
				}
			}
			
			
			// 검증 결과 토대로 DA/NE 출력
			if(result[i] != false)
				result[i] = true;
		}
		
		// 출력
		for(int i = 0; i < count; i++) {
			if(result[i] == false)
				System.out.println("NE");
			else
				System.out.println("DA");
		}
		
	}
	
}
