import java.util.*;

class Solution {
    static boolean[][] visit;
    static ArrayList<Integer> answer;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static void bfs(String[] maps, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        int days = 0;    // 해당 무인도에서 지낼 수 있는 일 수
        
        // 큐에 해당 칸의 행, 열을 저장하고 방문 체크
        q.offer(new int[]{row, col});
        visit[row][col] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            days += maps[cur[0]].charAt(cur[1])-'0'; // days 갱신
            
            // 상, 하, 좌, 우로 연결되는 땅 탐색하면서 연결된 땅 있는지 확인
            for(int i=0;i<4;i++) {
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                // 범위를 벗어나면 넘어가기
                if(nextR<0 || nextR>=maps.length || nextC<0 || nextC>=maps[0].length()) continue;
                
                if(!visit[nextR][nextC] && maps[nextR].charAt(nextC)!='X') {
                    q.offer(new int[]{nextR, nextC});
                    visit[nextR][nextC] = true;
                }
            }
        }
        
        answer.add(days);
    }
    
    public int[] solution(String[] maps) {
        answer = new ArrayList<>();
        visit = new boolean[maps.length][maps[0].length()]; // 해당 칸 방문 여부 체크
        
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[0].length();j++) {
                // 방문하지 않았고, 바다가 아니라면 탐색
                if(!visit[i][j] && maps[i].charAt(j)!='X') {
                    bfs(maps, i, j);
                }
            }
        }
        
        // 오름차순 정렬
        Collections.sort(answer);
        // 머무를 수 있는 무인도가 없으면 -1 담기
        if(answer.size() == 0) answer.add(-1);
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
