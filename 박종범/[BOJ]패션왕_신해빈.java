
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	/**
	 * [BOJ] 패션왕 신해빈 / Silver 3
	 * @see https://www.acmicpc.net/problem/9375
	 * @author D15M4S
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>(); // 의상 종류별 개수를 저장하는 맵

			// 의상 입력
			for (int j = 0; j < N; j++) {
				StringTokenizer input = new StringTokenizer(br.readLine());
				input.nextToken(); // 의상 이름은 사용하지 않음
				String type = input.nextToken();

				map.put(type, map.getOrDefault(type, 0) + 1);
			}

			// 조합 계산: (각 의상 종류의 개수 + 1)을 모두 곱하고, 최종 결과에서 1을 뺌
			int result = 1;
			for (int count : map.values()) {
				result *= (count + 1);
			}
			result -= 1; // 아무것도 입지 않는 경우 제외

			System.out.println(result);
		}
	}
}
