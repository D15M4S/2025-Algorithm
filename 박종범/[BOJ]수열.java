package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	/**
	 * [BOJ] 수열 / Silver 3
	 * @see https://www.acmicpc.net/problem/2559
	 * @author D15M4S
	 */
	public static void main(String[] args) throws Exception {

		// 콘솔 입출력;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input = new StringTokenizer(br.readLine());
		StringTokenizer tokenStream = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(input.nextToken());
		int K = Integer.parseInt(input.nextToken());

		// 배열로 stream 선언
		int[] stream = new int[N];

		for (int i = 0; i < N; i++) {
			stream[i] = Integer.parseInt(tokenStream.nextToken());
		}

		// 완전 탐색 계산 및 비교
		int result = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < N - K + 1; i++) {
			for (int j = i; j < i + K; j++) {
				sum += stream[j];
			}

			if (sum > result)
				result = sum;

			sum = 0;
		}

		// 콘솔 출력
		System.out.println(result);
	}
}
