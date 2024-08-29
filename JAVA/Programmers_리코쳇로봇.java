import java.util.*;

class Solution {
    static int n, m; // 세로, 가로 크기
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int bfs(String[] board, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m]; // 칸 방문 체크
        
        q.offer(new int[]{start[0], start[1], 0}); // {행, 열, 횟수} 저장
        visit[start[0]][start[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(board[cur[0]].charAt(cur[1]) == 'G') {
                return cur[2];
            }
            
            // 상하좌우로 움직이기
            for(int i=0;i<4;i++) { 
                int ny = cur[0]; // 이동한 행
                int nx = cur[1]; // 이동한 열
            
                while(true) {
                    // 벽이나 장애물 만나면 그 전에 멈추기
                    if(ny<0 || ny>=n || nx<0 || nx>=m || board[ny].charAt(nx)=='D') {
                        ny -= dy[i];
                        nx -= dx[i];
                        break;
                    }
                    
                    ny += dy[i];
                    nx += dx[i];
                }
                
                // 방문하지 않은 칸이면 방문
                if(!visit[ny][nx]) {
                    q.offer(new int[]{ny, nx, cur[2]+1});
                    visit[ny][nx] = true;
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        int[] start = new int[2]; // 시작점
        n = board.length;
        m = board[0].length();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // 시작점을 발견하면
                if(board[i].charAt(j) == 'R') {
                    start[0] = i; // 행 저장
                    start[1] = j; // 열 저장
                }
            }
        }
        
        int answer = bfs(board, start);
        
        return answer;
    }
}
