import java.util.*;

class Solution {
    // 주차 시간 반환 (분으로)
    public static int parkTime(int inHour, int inMin, int outHour, int outMin) {
        return (outHour*60+outMin)-(inHour*60+inMin);
    }
    
    public int[] solution(int[] fees, String[] records) {               
        // 주차시간 저장할 해시맵 (키: 차량 번호, 값: 누적 주차시간)
        HashMap<String, Integer> sum = new HashMap<>();
        // 입차한 차량 번호 저장할 해시맵 (키: 차량 번호, 값: 입차 시, 입차 분)
        HashMap<String, String[]> in = new HashMap<>();
        
        // 1. 누적 주차시간 구하기
        for(int i=0;i<records.length;i++) {
            String[] cur = records[i].split(" ");   // 현재 입/출차 기록
            String[] time = cur[0].split(":");      // 입/출차 시간
            
            // 입차하는 경우 (이미 입차한 차량 제외)
            if(cur[2].equals("IN") && !in.containsKey(cur[1])) {             
                in.put(cur[1], new String[]{time[0], time[1]});
            }
            
            // 출차하는 경우(입차 기록 없으면 제외)
            else if(cur[2].equals("OUT") && in.containsKey(cur[1])) {
                String[] inTime = in.get(cur[1]);   // 입차 시간
                in.remove(cur[1]);                  // 입차 정보 삭제
                
                // 주차시간 구하기
                int park = parkTime(Integer.parseInt(inTime[0]), Integer.parseInt(inTime[1]), Integer.parseInt(time[0]), Integer.parseInt(time[1]));
                
                sum.put(cur[1], sum.getOrDefault(cur[1], 0)+park);
            }
        }
        
        // 입차는 했지만 출차하지 않았다면 23:59까지의 시간으로 계산
        for(String key : in.keySet()) {
            String[] value = in.get(key);
            
            int park = parkTime(Integer.parseInt(value[0]), Integer.parseInt(value[1]), 23, 59);
            sum.put(key, sum.getOrDefault(key, 0)+park);
        }
        
        // 2. 차량 번호 오름차순으로 정렬
        List<String> keyList = new ArrayList<>(sum.keySet());
        Collections.sort(keyList);
        
        // 3. 주차 요금 구하기
        int[] answer = new int[sum.size()];
        int i=0;
        for(String key : keyList) {
            int time = sum.get(key)-fees[0];    // 주차 시간
            int fee = fees[1];                  // 주차 요금
            
            if(time > 0) {
                fee += (int)Math.ceil((double)time/(double)fees[2])*fees[3];
            }
            
            answer[i++] = fee;
        }
        
        return answer;
    }
}
