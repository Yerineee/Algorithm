import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    
    static void bfs(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();    // [연산한 수, 횟수] 배열로 저장
        Set<Integer> set = new HashSet<>(); // 현재까지 연산한 숫자들 저장
        
        queue.add(new int[]{x, 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 연산한 결과가 y와 같다면 ans 갱신
            if(cur[0] == y) {
                ans = Math.min(ans, cur[1]);
                continue;
            }
            
            int[] result = {cur[0]+n, cur[0]*2, cur[0]*3}; // 연산한 숫자
            for(int i=0;i<3;i++) {
                // 연산을 수행한 수가 y보다 크거나, set에 있는 숫자면 넘어가기
                if(result[i]>y || set.contains(result[i])) continue;
                
                // 그렇지 않다면, queue와 set에 연산한 숫자 및 횟수 저장
                queue.add(new int[]{result[i], cur[1]+1});
                set.add(result[i]);
            }
        }
        
        // x를 y로 만들 수 없다면 ans에 -1 저장
        if(ans == Integer.MAX_VALUE) ans = -1;
    }
    
    public int solution(int x, int y, int n) {
        bfs(x, y, n);
        
        return ans;
    }
}
