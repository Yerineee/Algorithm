import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> hashMap = new HashMap<>();
        // 전화번호 중복 X => 전화번호를 key 값으로 사용하여 해시맵에 저장
        for(int i=0;i<phone_book.length;i++) {
            hashMap.put(phone_book[i],1);
        }
        
        Loop:
        for(int i=0;i<phone_book.length;i++) {
            for(int j=0;j<phone_book[i].length()-1;j++) {
                String subStr = phone_book[i].substring(0,j+1);
                
                // 해당 번호가 다른 번호의 접두어인 경우
                if(hashMap.containsKey(subStr)) {
                    answer = false;
                    break Loop;
                }
            }
        }
        
        return answer;
    }
}
