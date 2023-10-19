import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int[] citations) { // citations: 발표한 논문의 인용 횟수
        int answer = 0; // 과학자의 H-Index
        
        Arrays.sort(citations); // 오름차순 정렬
        
        for(int i=0;i<citations.length;i++) {
            // '인용된 횟수 >= 특정 횟수 이상 인용된 논문 개수'를 만족하는 값
            if(citations[i]>=citations.length-i) {
                answer = citations.length-i;
                break;
            }
        }
        
        return answer;
    }
}
