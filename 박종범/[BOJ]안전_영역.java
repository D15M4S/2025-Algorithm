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
	 * [BOJ] 안전 영역 / 실버 1
	 * 
	 * @see https://www.acmicpc.net/problem/2468
	 * @author D15M4S
	 */
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];
        int maxMatrixHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                // 최적화 포인트
                maxMatrixHeight = Math.max(maxMatrixHeight, matrix[i][j]);
            }
        }

        int maxSafeAreas = 1; // 최소 하나의 안전 영역이 존재할 수 있음
        for (int height = 1; height <= maxMatrixHeight; height++) {
            boolean[][] seen = new boolean[N][N];
            int count = 0;

            // 4방향 탐색용 배열 설정
            int[] dx = { 0, 1, 0, -1 };
            int[] dy = { 1, 0, -1, 0 };

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] > height && !seen[i][j]) {
                        count++;
                        Stack<List<Integer>> stack = new Stack<>();
                        stack.push(Arrays.asList(i, j));
                        seen[i][j] = true;

                        while (!stack.isEmpty()) {
                            List<Integer> current = stack.pop();
                            int x = current.get(0); // row
                            int y = current.get(1); // column

                            for (int idx = 0; idx < 4; idx++) {
                                int nx = x + dx[idx];
                                int ny = y + dy[idx];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < N && matrix[nx][ny] > height && !seen[nx][ny]) {
                                    stack.push(Arrays.asList(nx, ny));
                                    seen[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }

            maxSafeAreas = Math.max(maxSafeAreas, count);
        }
        System.out.println(maxSafeAreas);
    }
}
