package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


	/**
	 * [BOJ] ROT13 / Bronze 1
	 *
	 * @see https://www.acmicpc.net/problem/11655
	 * @author D15M4S
	 */
	public static void main(String args[]) throws Exception{

		// 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer string = new StringBuffer(br.readLine());


		// ROT13 암호화
		for(int i = 0; i < string.length(); i++) {

			char ch = string.charAt(i);

			// 대문자 A-Z 처리
			if(Character.isUpperCase(ch)) {
				ch = (char) ((ch - 'A' + 13) % 26 + 'A');
			}
			// 소문자 a-z 처리
			if(Character.isLowerCase(ch)) {
				ch = (char) ((ch - 'a' + 13) % 26 + 'a');
			}

			string.setCharAt(i, ch);
		}

		// 콘솔 출력
		System.out.println(string);
	}
}

