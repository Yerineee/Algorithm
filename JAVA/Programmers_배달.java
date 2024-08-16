import java.util.*;

class Solution {
    static int[][] time;
    static int[] distance;
    
    static void dijkstra(int N, int[][] road) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        boolean[] visit = new boolean[N+1];
        
        // 큐에 {마을 번호, 1번 마을로부터 걸리는 시간} 저장
        q.offer(new int[]{1, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(visit[cur[0]]) continue; // 방문한 마을이면 넘어가기
            
            // 해당 마을 방문 체크
            visit[cur[0]] = true;
            
            for(int i=1;i<=N;i++) {
                // 연결된 마을이 아니면 넘어가기
                if(time[cur[0]][i] == 0) continue;
                
                if(!visit[i] && distance[i]>cur[1]+time[cur[0]][i]) {
                    distance[i] = cur[1]+time[cur[0]][i]; // 최단 거리 갱신
                    q.offer(new int[]{i, distance[i]});
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 각 도로를 지나는 데 걸리는 시간을 time에 저장
        time = new int[N+1][N+1];
        for(int i=0;i<road.length;i++) {
            int from = road[i][0];
            int to = road[i][1];
            int t = time[from][to]==0 ? road[i][2] : Math.min(time[from][to], road[i][2]);
            
            time[from][to] = t;
            time[to][from] = t;
        }
        
        // 1번 마을로부터 각 마을까지의 최단 거리
        distance = new int[N+1];
        // 1번 마을을 제외한 모든 마을 값을 모두 최댓값으로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        // 다익스트라 이용
        dijkstra(N, road);
        
        // distance 배열을 오름차순으로 정렬한 후, K보다 작은 마을 개수 세기
        Arrays.sort(distance);
        for(int i=0;i<N+1;i++) {
            if(distance[i] > K) break;
            
            answer++;
        }

        return answer;
    }
}
