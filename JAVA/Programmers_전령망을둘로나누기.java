import java.util.*;

class Solution {
    static int answer = 100; // n의 최댓값 저장
    
    // 전선을 끊은 송전탑을 기준으로 탐색
    static int search(int n, boolean[][] connect, int idx) {
        boolean[] visit = new boolean[n+1]; // 송전탑 탐색 여부 체크
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visit[idx] = true;
        int cnt = 1; // 전선을 끊은 송전탑에 연결된 송전탑 개수
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i=1;i<n+1;i++) {
                if(connect[cur][i] && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }
        
        // 두 전력망이 가지는 송전탑 개수 차이 반환
        return Math.abs(n-cnt*2);
    }
    
    public int solution(int n, int[][] wires) {
        // 연결 상태를 connect에 저장
        boolean[][] connect = new boolean[n+1][n+1];
        for(int i=0;i<wires.length;i++) {
            int first = wires[i][0], second = wires[i][1];
            
            connect[first][second] = true;
            connect[second][first] = true;
        }
        
        for(int i=0;i<wires.length;i++) {
            int first = wires[i][0], second = wires[i][1];
            
            // 주어진 전선 하나를 끊고 탐색
            connect[first][second] = false;
            connect[second][first] = false;
            
            answer = Math.min(answer,search(n, connect, first));
            
            // 다시 전선 이어주기
            connect[first][second] = true;
            connect[second][first] = true;
        }
        
        return answer;
    }
}
