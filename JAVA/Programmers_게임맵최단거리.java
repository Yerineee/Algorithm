// 1. BFS를 이용한 풀이
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static Queue<int[]> queue;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void bfs(int[][] maps, int[][] visit) {
        // 시작 위치를 큐에 저장한 후, 방문 체크
        queue.add(new int[]{0,0});
        visit[0][0] = 1;
        
        while(!queue.isEmpty()) {
            // 큐에서 꺼낸 위치
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            
            // 위, 아래, 오른쪽, 왼쪽 방향 중 이동 가능한 방향으로 이동
            for(int i=0;i<4;i++) {
                int x = col+dx[i];
                int y = row+dy[i];
                
                // 배열의 범위를 벗어나면 넘어감
                if(x<0 || x>=maps[0].length || y<0 || y>=maps.length) continue;

                // 방문한 적 없고 벽이 없는 자리라면, 이동
                if(visit[y][x]==0 && maps[y][x]==1) {
                    queue.add(new int[]{y, x});
                    visit[y][x] = visit[row][col]+1;
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        queue = new LinkedList<>();
        int[][] visit = new int[maps.length][maps[0].length];   // 방문 확인을 위한 배열
        
        bfs(maps, visit);
        
        answer = visit[maps.length-1][maps[0].length-1];
        
        // 상대 팀 진영에 도달하지 못한 경우
        if(answer==0) {
            answer = -1;
        }
        
        return answer;
    }
}

// 2. DFS를 이용한 풀이 - 테스트 케이스는 모두 통과했으나, 효율성 테스트는 통과 못함 (시간 초과)
/*
class Solution {
    static int answer = 10000;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void search(int[][] maps, int row, int col, boolean[][] check, int num) {
        
        // 상대팀 진영에 도착한 경우, answer 값 갱신
        if(row==maps.length-1 && col==maps[0].length-1) {
            answer = Math.min(answer, num);
            return;
        }
        
        // 위, 아래, 오른쪽, 왼쪽 방향 중 이동 가능한 방향으로 이동
        for(int i=0;i<4;i++) {
            int x = col+dx[i];
            int y = row+dy[i];
            if(x<0 || x>=maps[0].length || y<0 || y>=maps.length) continue;
            
            if(!check[y][x] && maps[y][x]==1) {
                check[y][x] = true;
                search(maps, y, x, check, num+1);
                check[y][x] = false;
            }
        }
    }
    
    public int solution(int[][] maps) {
        boolean[][] check = new boolean[maps.length][maps[0].length];   // 방문 확인을 위한 배열
        
        check[0][0] = true;
        search(maps, 0, 0, check, 1);
        
        // 상대 팀 진영에 도달하지 못한 경우
        if(answer == 10000) {
            answer = -1;
        }
        
        return answer;
    }
}
*/
