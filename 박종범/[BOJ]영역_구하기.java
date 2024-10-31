package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {


	/**
	 * [BOJ] 영역 구하기 / 실버 1
	 *
	 * @see https://www.acmicpc.net/problem/2583
	 * @author D15M4S
	 */
	public static void main(String args[]) throws Exception {

		//TODO 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<Integer> result = new ArrayList<>();

		int M = Integer.parseInt(st.nextToken());	//y
		int N = Integer.parseInt(st.nextToken());	//x
		int K = Integer.parseInt(st.nextToken());

		boolean[][] matrix = new boolean[M][N];

		//TODO 직사각형 표시
		for(int r = 0; r < K; r++) {
			StringTokenizer rectSt = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(rectSt.nextToken());
			int y1 = Integer.parseInt(rectSt.nextToken());

			int x2 = Integer.parseInt(rectSt.nextToken());
			int y2 = Integer.parseInt(rectSt.nextToken());

			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) {
					matrix[y][x] = true;
				}
			}
		}

		//TODO DFS 탐색을 통한 영역의 갯수와 크기 구하기

		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		for(int y = 0; y < M; y++) {
			for(int x = 0; x < N; x++) {

				if(matrix[y][x] == false) {

					int size = 1;

					Stack<List<Integer>> stack = new Stack<>();
					matrix[y][x] = true;
					stack.push(Arrays.asList(x, y));

					while(!stack.isEmpty()) {

						List<Integer> current = stack.pop();

						for(int i = 0; i < 4; i++) {
							int nx = current.get(0) + dx[i];
							int ny = current.get(1) + dy[i];

							if(nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;

							if(matrix[ny][nx] == true)
								continue;

							stack.push(Arrays.asList(nx, ny));
							matrix[ny][nx] = true;
							size += 1;
						}
					}	// DFS 종료
					result.add(size);
				}
			}
		}	// matrix 탐색 종료

		// 결과 출력
		Collections.sort(result);
		System.out.println(result.size());
		for (Integer value : result) {
			System.out.print(value + " ");
		}
	}
}
