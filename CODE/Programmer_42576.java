import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 키 : 선수 이름, 값 : 선수 인원
        HashMap<String, Integer> player = new HashMap<>();
        
        // 이름과 선수 인원을 매핑하여 해시맵에 저장
        // 선수 이름에 해당하는 값이 해시 맵에 저장되어 있지 않으면 1 저장
        for(String name: participant) {
            player.put(name, player.getOrDefault(name, 0) + 1);
        }
        
        // 선수 이름에 해당하는 (해시맵에 저장된) 선수 인원 1씩 감소
        for(String name: completion) {
            player.put(name, player.get(name) - 1);
        }
        
        // 선수 인원이 0이 아닌 선수 이름 answer 변수에 저장
        for(String name: player.keySet()) {
            if(player.get(name)>0) {
                answer = name;
            }
        }
        
        return answer;
    }
}
