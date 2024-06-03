import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 키: 유저 아이디, 값: 변경한 닉네임
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=0;i<record.length;i++) {
            String[] info = record[i].split(" ");
            
            // 유저가 채팅방에 들어오거나, 닉네임을 변경하면 map에 닉네임 저장
            if(info.length > 2) {
                map.put(info[1], info[2]);
            }
        }
        
        // 변경된 채팅방 메시지 (출력값) 저장
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i=0;i<record.length;i++) {
            String[] info = record[i].split(" ");
            String name = map.get(info[1]);
            
            if(info[0].equals("Enter")) {
                ans.add(name+"님이 들어왔습니다.");
            } else if(info[0].equals("Leave")) {
                ans.add(name+"님이 나갔습니다.");
            }
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}
