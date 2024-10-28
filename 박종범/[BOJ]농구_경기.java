package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	

	/**
	 * [BOJ] 농구 경기 / 브론즈2
	 * @see https://www.acmicpc.net/problem/1159
	 * @author D15M4S
	 */
	public static void main(String args[]) throws Exception
	{
		// 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		
		
		// 이름의 첫 글자를 추출
		int[] alphabet = new int[26];
		
		for(int i = 0; i < loop; i++) {
			alphabet[br.readLine().charAt(0) - 'a']++;
		}
		
		// 친선경기 결과 반환
		int over5 = 0;
		
		for(int i = 0; i < 26; i++) {
			 if(alphabet[i] > 4) {
				 System.out.print((char)(97 + i));
				 over5++;
			 }
		}
		
		if(over5++ == 0)
			System.out.print("PREDAJA");
		
	}
}
