import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();  // 출력 값
        HashMap<String, Integer> dic = new HashMap<>(); // 사전
        
        while(msg.length()>0) {
            String w = msg.substring(0, 1);   //첫 글자로 초기화
            
            // 가장 긴 문자열 w 찾기
            for(int i=1;i<msg.length();i++) {
                String temp = msg.substring(0,i+1);
                // 사전에 있는 글자라면
                if(dic.containsKey(temp)) {
                    w = temp;   // w를 해당 글자로 설정
                } else {
                    break;
                }
            }
            
            // 색인 번호 출력
            // 1. 한 글자이면, 아스키코드 이용하여 색인 번호 출력
            if(w.length() ==1) {
                answer.add(w.charAt(0)-'A'+1);
            }
            // 2. 두 글자 이상이면, 사전에서 색인 번호 찾아 출력
            else {
                answer.add(dic.get(w));
            }
            
            // 입력에서 w 삭제
            msg = msg.substring(w.length());
            
            // 다음 글자가 남아있다면, w+c에 해당하는 단어를 사전에 등록
            if(msg.length() > 0) {
                dic.put(w+Character.toString(msg.charAt(0)), 27+dic.size());
            }
        }
        
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
