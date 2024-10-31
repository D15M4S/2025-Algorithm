package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


	/**
	 * [BOJ] 유기농 배추 / 실버 2
	 *
	 * @see https://www.acmicpc.net/problem/1012
	 * @author D15M4S
	 */
	public static void main(String args[]) throws Exception{

		// 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());


		for(int t = 0; t < test_case; t++) {

			// 그래프 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());	// 가로
			int N = Integer.parseInt(st.nextToken());	// 세로
			int num = Integer.parseInt(st.nextToken());	// 배추의 갯수

			int[][] matrix = new int[N][M];
			Stack<List<Integer>> stack = new Stack<>();

			// 배추 입력
			for(int n = 0; n < num; n++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());

				int ci = Integer.parseInt(st2.nextToken());
				int cj = Integer.parseInt(st2.nextToken());

				matrix[cj][ci] = 1;
			}

			int[] ni = {0, 1, 0, -1};
			int[] nj = {1, 0, -1, 0};


			// DFS
			int count = 0;
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					// 배추가 심어져 있을 경우
					if(matrix[n][m] == 1) {
						stack.push(Arrays.asList(m, n));
						matrix[n][m] = 0;
						count++;

						while(!stack.isEmpty()) {

							List<Integer> current = stack.pop();

							int ci = current.get(0);
							int cj = current.get(1);

							//순회
							for(int i = 0; i < 4; i++) {
								int di = ci + ni[i];
								int dj = cj + nj[i];

								if(di < 0 || di >= M || dj < 0 || dj >= N)
									continue;
								if(matrix[dj][di] == 0)
									continue;

								stack.push(Arrays.asList(di, dj));	//xy
								matrix[dj][di] = 0;					//yx
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}
