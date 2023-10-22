import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s);  // StringTokenizer 통해 공백 기준으로 문자열 자르기
        List<Integer> list = new ArrayList<>();
        
        // 공백 기준으로 자른 문자열을 정수로 변환하여 ArrayList에 저장
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);  // ArrayList를 오름차순 정렬
        
        answer=list.get(0)+" "+list.get(list.size()-1); // 최솟값과 최댓값을 공백으로 구분하여 answer 변수에 저장
        
        return answer;
    }
}
