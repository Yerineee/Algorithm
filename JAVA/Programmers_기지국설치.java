import java.util.*;

class Solution {
    // 해당 범위에서 추가 설치해야 하는 기지국 수 구하는 함수
    static int installNum(int w, int distance) {
        int scope = 2*w+1;  // 기지국 하나를 추가 설치했을 때, 전파가 전달되는 범위
        
        if(distance <= 0) return 0;
        
        // distance가 scope으로 나누어떨어지면 몫을 반환, 그렇지 않으면 (몫+1) 반환
        if(distance%scope == 0) {
            return distance/scope;
        } else {
            return distance/scope+1;
        }
    }
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        for(int i=0;i<stations.length;i++) {
            int distance;   // 전파가 전달되는 아파트들 사이의 거리(전파가 전달되지 않는 범위)
            
            if(i == 0) {
                distance = stations[i]-w-1;
            } else{
                distance = stations[i]-stations[i-1]-2*w-1;
            }
            
            answer += installNum(w, distance);
        }
        
        answer += installNum(w, n-stations[stations.length-1]-w);
        

        return answer;
    }
}
