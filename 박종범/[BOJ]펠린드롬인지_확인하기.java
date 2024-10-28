package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	/**
	 * https://www.acmicpc.net/problem/10988
	 * [BOJ] 10988 펠린드롬인지 확인하기 / Bronze 3
	 * 
	 */

	public static void main(String args[]) throws Exception
	{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int length = input.length();
		
		for(int i = 0; i < length / 2; i++) {
			
			if(input.charAt(i) != input.charAt(length - i - 1)) {
				System.out.println("0");
				return;
			}
		}
		System.out.println("1");
	}
}
