import java.util.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    static int bfs(String[] maps, int row, int col, char target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()]; // 칸 방문 여부 체크
        
        q.add(new int[]{row, col, 0});
        visit[row][col] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            // 목적지라면, 출발지로부터 걸린 시간 반환
            if(maps[cur[0]].charAt(cur[1]) == target) {
                return cur[2];
            }
            
            // 상하좌우로 이동
            for(int i=0;i<4;i++) {
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                
                // 미로 범위를 넘어간 경우는 넘어가기
                if(nextR<0 || nextR>=maps.length || nextC<0 || nextC>=maps[0].length()) continue;
                
                // 이동할 칸이 벽이 아니고, 아직 방문하지 않은 칸이면 방문
                if(maps[nextR].charAt(nextC) != 'X' && !visit[nextR][nextC]) {
                    q.add(new int[]{nextR, nextC, cur[2]+1});
                    visit[nextR][nextC] = true;
                }
            }
        }
        
        return 0;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        // 시작 위치와 레버 위치 저장
        int startR=0, startC=0, leverR=0, leverC=0;
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[0].length();j++) {
                if(maps[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                } else if(maps[i].charAt(j) == 'L') {
                    leverR = i;
                    leverC = j;
                }
            }
        }
        
        // 시작점 -> 레버까지의 최단 거리
        int lever = bfs(maps, startR, startC, 'L');
        
        // 레버 -> 출구까지의 최단 거리
        int end = bfs(maps, leverR, leverC, 'E');
        if(lever == 0 || end == 0) return -1;
        
        return lever+end;
    }
}
