import java.util.*;

class Solution {
    public int solution(int[][] routes) {        
        // 고속도로에서 나간 지점을 기준으로 오름차순 정렬
        // 나간 지점이 같다면 고속도로에 진입한 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        
        int answer = 1;
        int temp = routes[0][1];
        for(int i=1;i<routes.length;i++) {
            if(temp>=routes[i][0] && temp<=routes[i][1]) continue;
            
            // 이전 차량과 겹치는 구간이 없다면 temp 갱신하고 카메라 추가 설치
            temp = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}
