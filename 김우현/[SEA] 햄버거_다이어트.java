import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
class Solution {
    public static int[] taste;
    public static int[] cal;
    public static int maximumTaste;
    public static int N; // 재료의 수
    public static int L; // 제한 칼로리
 
    public static void dfs(int startIdx, int totalTaste, int totalCalories) {
        // dfs가 끝나는 조건
        if (totalCalories > L) return; // 칼로리 초과 시 종료
        if (startIdx == N) {
            maximumTaste = Math.max(maximumTaste, totalTaste);
            return;
        }
 
        // 현재 재료를 선택하지 않는 경우
        dfs(startIdx + 1, totalTaste, totalCalories);
 
        // 현재 재료를 선택하는 경우
        dfs(startIdx + 1, totalTaste + taste[startIdx], totalCalories + cal[startIdx]);
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
 
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 재료의 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리
 
            taste = new int[N]; // 맛 점수
            cal = new int[N]; // 칼로리
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
 
            maximumTaste = 0; // 각 테스트 케이스마다 초기화
            dfs(0, 0, 0); // DFS 호출
 
            System.out.println("#" + testCase + " " + maximumTaste);
        }
    }
}