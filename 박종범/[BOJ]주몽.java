package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
    /**
     * [BOJ] 주몽 / Silver 4
     * @see https://www.acmicpc.net/problem/1940
     * @author D15M4S
     */
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());	// 재료의 개수
    	int M = Integer.parseInt(br.readLine());	// 갑옷을 만들기 위한 수
    	
    	HashSet<Integer> materials = new HashSet<>();
    	int result = 0;
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		int currentMaterial = Integer.parseInt(st.nextToken());
    		int complement = M - currentMaterial;
    		
    		// 필요한 쌍이 이미 존재하면 카운트 증가 후 제거
    		if (materials.contains(complement)) {
    			result++;
    			materials.remove(complement); // 쌍으로 사용된 재료 제거
    		} else {
    			materials.add(currentMaterial); // 재료 추가
    		}
    	}
    	
    	System.out.println(result);
    } 
}
