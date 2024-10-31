import java.util.Scanner;
import java.util.*;
public class Main {
    // 상,하,좌,우 로 이동이 가능하다.
    public static int [] moveX= new int[]{-1,1,0,0};
    public static int [] moveY= new int[]{0,0,-1,1};
    public static boolean [][] visited;
    public static int [][] miro;
    public static void main(String[] args) {
        // bfs혹은 dfs이다.
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리
        visited = new boolean[height][width];
        miro = new int[height][width];
        // 입력을 배열에 넣어준다
        for (int i = 0; i < height; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < width; j++) {
                miro[i][j] = line.charAt(j) - '0'; // 각 문자를 정수로 변환하여 배열에 저장
                visited[i][j] = false; // 방문 배열 초기화
            }
        }
        bfs(0,0,height,width);
        System.out.println(miro[height-1][width-1]);

    }
    // BFS함수는 외부로 뺴준다
    // BFS를 어떤 상황에서 쓸까? BFS는 가중치가 없는 그래프에서 최단 경로를 보장한다는 강력한 장점이 있다.
    // BFS가 어떤 완전탐색 과정을 거치는지 생각해보자
    // 모든 특정 좌표에서의 이동 가능성은 상,하,좌,우 총 4가지이다.
    public static void bfs(int x,int y,int height,int width){
        // BFS는 LinkedList기반의 queue로 이루어진다.
        // BFS가 한번 실행될떄 해당 x,y기준 모~든 가능성을 탐색해주어야한다.
        Queue<int[]> findByBfs = new LinkedList<>();
        findByBfs.add(new int[]{x,y});
        while (!findByBfs.isEmpty()){
            int [] getTmpXY = findByBfs.poll();
            int tmpX = getTmpXY[0];
            int tmpY = getTmpXY[1];
            // 빼낸 좌표는 방문
            visited[tmpX][tmpY] = true;
            // 상,하,좌,우로 이동한 애들을 조건에 맞다면 add
            for(int i=0; i<4; i++){
                int nextX = tmpX+moveX[i];
                int nextY = tmpY+moveY[i];
                if(nextX >= 0 && nextX< height && nextY >=0 &&nextY < width){
                    // 방문 조건 체크
                    if(!visited[nextX][nextY] && miro[nextX][nextY] == 1) {
                        findByBfs.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        miro[nextX][nextY] = miro[tmpX][tmpY]+1;
                    }
                }
            }
        }

    }
}