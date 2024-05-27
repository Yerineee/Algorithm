import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 전체 토핑 수가 1이면, 공평하게 나눌 수 없으므로 0 반환
        if(topping.length == 1) return 0;
        
        HashMap<Integer, Integer> older = new HashMap<>();  // 형의 토핑
        HashMap<Integer, Integer> younger = new HashMap<>();// 동생의 토핑
        
        for(int i=0;i<topping.length;i++) {
            // 현재 동생에게 없는 토핑이면 추가, 없으면 개수 1 증가
            younger.put(topping[i], younger.getOrDefault(topping[i], 0)+1);
        }
        
        // 동생 토핑에서 형 토핑으로 옮기면서 개수 비교
        for(int i=0;i<topping.length-1;i++) {
            // 동생 토핑에서 삭제
            int value = younger.get(topping[i]);
            if(value <= 1) younger.remove(topping[i]);
            else younger.replace(topping[i], value-1);
            
            // 형 토핑에 추가
            older.put(topping[i], older.getOrDefault(topping[i], 0)+1);
            
            // 형과 동생의 토핑 수가 같으면 answer 1 증가
            if(younger.size() == older.size()) answer++;
            // 형의 토핑 수가 더 많으면 반복문 빠져나가기
            else if(younger.size() < older.size()) break;
        }
        
        return answer;
    }
}
