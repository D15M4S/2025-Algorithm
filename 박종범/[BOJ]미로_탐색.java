package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	/**
	 * [BOJ] 미로 탐색
	 * 
	 * @see https://www.acmicpc.net/problem/2178
	 * @author D15M4S
	 */
	public static void main(String args[]) throws Exception{
		
		// 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N][M];

		
		for(int n = 0; n < N; n++) {
			String row = br.readLine();
			for(int m = 0; m < M; m++) {
				matrix[n][m] = Character.getNumericValue(row.charAt(m));
			}
		}
	
//		System.out.println();
//		System.out.println(Arrays.deepToString(matrix).replace("], ", "],\n"));
		
		// BFS 구현
		
		int[] di = {0, 1, 0, -1};
		int[] dj = {1, 0, -1, 0};
		
		int[][] seen = new int[N][M];
		Queue<List<Integer>> queue = new ArrayDeque<>();
		seen[0][0] = 1;
		queue.add(Arrays.asList(0, 0));
		
		int result = 0;
		
		while(!queue.isEmpty()) {
			
			List<Integer> current = queue.poll();	
			int ci = current.get(0);
			int cj = current.get(1);
			
			if(ci == N - 1 && cj == M - 1) {
				System.out.println(matrix[ci][cj]);
				break;
			}
			
			
			for(int i = 0; i < 4; i++) {
				
				int ni = ci + di[i];
				int nj = cj + dj[i];
				
				if(!(ni >= 0 && ni < N && nj >= 0 && nj < M ))
					continue;
				if(matrix[ni][nj] != 1)
					continue;
				if(seen[ni][nj] == 1)
					continue;
				matrix[ni][nj] = matrix[ci][cj] + 1;
				seen[ni][nj] = 1;
				queue.add(Arrays.asList(ni, nj));
			}			
			
		}	
	}
	
}
