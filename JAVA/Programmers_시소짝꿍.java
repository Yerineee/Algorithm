import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        HashMap<Double, Integer> map = new HashMap<>();
        // 가능한 몸무게 비율은 {1.0, 0.5, 2/3, 3/4}
        double[] rate = {1.0, 0.5, 2/(double)3, 3/(double)4};
        
        for(int w : weights) {
            for(int i=0;i<rate.length;i++) {
                // 만약 map에 w의 rate[i]배인 몸무게가 존재한다면, 해당 인원 수를 answer에 저장
                if(map.containsKey(w*rate[i])) answer += map.get(w*rate[i]);
            }
            
            // 몸무게가 w인 인원 수 갱신
            map.put((double) w, map.getOrDefault((double) w, 0)+1);
        }   
        
        return answer;
    }
}
