import java.util.Map;
import java.util.HashMap;

class Solution {
    static int answer = 1;
    
    // [의상의 이름, 의상의 종류]
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        // key = 의상 종류
        // value = 해당 종류의 의상 개수
        for(int i=0;i<clothes.length;i++) {
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }
        }
        
        // 해당 의상 종류를 입지 않는 경우를 포함한 (의상 개수 + 1)를 모두 곱하기
        map.forEach((key, value) -> {
            answer *= (value+1);
        });
        
        // 의상을 아예 안 입는 경우는 제외하기
        return answer-1;
    }
}
