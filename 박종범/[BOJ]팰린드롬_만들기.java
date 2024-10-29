package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	/**
	 * [BOJ] 팰린드롬 만들기 / Silver 3
	 * @see https://www.acmicpc.net/problem/1213
	 * @author D15M4S
	 */
	public static void main(String[] args) throws Exception {

		// 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// input 분석
		int[] alphabet = new int[26];

		for(int i = 0; i < input.length(); i++) {
			alphabet[input.charAt(i) - 'A']++;
		}

		int oddCount = 0;
		StringBuffer odd = new StringBuffer();
		for(int i = 0; i < 26; i++)
		{
			if(alphabet[i] % 2 == 1) {
				oddCount++;
				odd.append((char)('A' + i));
				alphabet[i]--;
			}
		}


		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < 26; i++) {
			if(alphabet[i] > 1) {
				for(int j = 0; j < alphabet[i] / 2; j++) {
					sb.append((char)(i + 'A'));
				}
			}
		}

		if(oddCount > 1)
			System.out.println("I'm Sorry Hansoo");
		else
			System.out.println(sb.toString() + odd + sb.reverse().toString());
	}
}