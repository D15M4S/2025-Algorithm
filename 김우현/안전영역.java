import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main
{

    public static int [] moveX= new int[]{-1,1,0,0};
    public static int [] moveY= new int[]{0,0,-1,1};
    public static boolean [][] visited;
    public static int [][] graph;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        // 생각보다 간단한 문제인 것 같다... DFS를 사용하는 완전탐색
        // 특정 지점에서의 모든 dfs의 경우를 파악해야한다 이는 for문을 동반한 반복문이 쓰일 것임을 의미한다.
        // dfs를 생각하다가 문득 든 생각이 있다. 그냥 안잠기는 빌딩들 false로 두고 bfs로 탐색 최소로 때리고 최대값들 파악하면 되는거 아닌가?
        int m = sc.nextInt();
        sc.nextLine();
        int waterLv = 0;
        int maximumValue = 0;
        visited = new boolean[m][m];
        graph = new int[m][m];

        // graph를 채워준다.이러면서 최대치의 waterLv를 파악한다.
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                graph[i][j] = sc.nextInt();
                if(waterLv < graph[i][j]) waterLv = graph[i][j];
            }
            sc.nextLine();
        }
        // setVisitedInfoToFalse(visited);
        // 모두 잠길 수 도있고 아예 안잠길수도 있다, 모두 잠기는 경우는 graph의 요소들 중 가장 큰 value에 해당하는 물높이
        // 이제 각 물높이떄 마다 어느정도의 생존 블럭들이 나타나는지 dfs로 파악하면 끝이다.
        int maximumCount = 0;
        while(waterLv >= 0){
            // 물높이 기준으로 visited 배치
            checkVisitedInfoByWaterLV(graph,visited,waterLv);
            // 이제 생존한 빌딩들은 false로 false를 찾아나가면 된다.
            // 이제 dfs를 수행 단 dfs를 수행하는 spot또한 이차원 배열의 매 공간이 적절
            int count = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    if (!visited[i][j]) {
                        bfs(i,j,m,m);
                        count++;
                    }
                }
            }
            // System.out.println("현재 물높이는 "+waterLv+"현재 블록수: "+count);
            maximumCount = Math.max(maximumCount,count);
            // 방문 정보 초기화
            setVisitedInfoToFalse(visited);
            // 물높이를 한 단계 down
            waterLv --;
            }
            System.out.println(maximumCount);

        }


        // 우선 비의 양에 따라서 매번 범람지역이 업데이트 되는 것에 주의를 하자


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
                    if(!visited[nextX][nextY]) {
                        findByBfs.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

    }
    public static void checkVisitedInfoByWaterLV(int graph[][],boolean hi[][],int standardWaterLV){
        int checkNum = hi.length;
        for(int i=0; i<checkNum; i++){
            for (int j=0; j<checkNum; j++){
                // 물높이보다 더 높다면
                if((graph[i][j]-standardWaterLV) > 0) hi[i][j] = false;
            }
        }
    }

    // 모든 visited 블록을 false로 되바꿔버리는 곳
    public static void setVisitedInfoToFalse(boolean hi[][]){
        int checkNum = hi.length;
        for(int i=0; i<checkNum; i++){
            for (int j=0; j<checkNum; j++){
                hi[i][j] = true;

            }
        }
    }

}