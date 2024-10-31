import java.util.Scanner;
import java.util.*;
public class Main {
    // 상,하,좌,우 로 이동이 가능하다.
    public static boolean [][] visited;
    public static int [][] miro;
    public static int [] moveX= new int[]{-1,1,0,0};
    public static int [] moveY= new int[]{0,0,-1,1};
    public static void main(String[] args) {
        // 해당 문제에서 최소의 경우를 구하라 했으니 최소치를 찾는 BFS사용해야한다.
        Scanner sc = new Scanner(System.in);
        List<Integer> answer = new ArrayList<>();

        int howMany = sc.nextInt();
        sc.nextLine();

        for(int p=0; p<howMany; p++) {
            int count = 0;

            int height = sc.nextInt();  // 10
            int width = sc.nextInt(); // 8
            int vegetable = sc.nextInt(); // 17
            sc.nextLine();
            miro = new int[height][width]; // 기본 생성 -> 0
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 0; i < vegetable; i++) {
                int tmpX = sc.nextInt();
                int tmpY = sc.nextInt();
                // 배추 있는 곳들 1로 표시
                miro[tmpX][tmpY] = 1;
                sc.nextLine();
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // 만약 해당 장소가 배추가 있고 방문한 장소가 아니라면...
                    if (miro[i][j] == 1 && !visited[i][j]) {
                        // 해당 좌표에서 bfs수행
                        bfs(i, j, height, width);
                        count++;
                    }
                }
            }
            answer.add(count);
        }

        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }

    }

    public static void bfs(int x,int y,int height,int width){
        Queue<int[]> bfsSpot = new LinkedList<>();
        bfsSpot.add(new int[]{x,y});

        while (!bfsSpot.isEmpty()){
            int [] getTmpXY = bfsSpot.poll();
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
                        bfsSpot.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }



    }

}
