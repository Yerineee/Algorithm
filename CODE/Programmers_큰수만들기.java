import java.lang.StringBuilder;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int idx = -1;   // 탐색 완료한 인덱스
        
        // 남겨야 하는 숫자 개수가 (number.length()-k-1)개이므로, (number.length()-k-1)번 반복
        for(int i=0;i<number.length() - k;i++) {
            int maxNum = 0;     // 아래의 반복문을 통해 구한 최댓값 저장할 변수
            
            // 이전 최댓값의 다음 숫자부터 k+i번째 숫자까지 탐색하며 최댓값 찾기
            for(int j=idx+1;j<=k+i;j++) {
                // 최댓값 갱신 후 idx에 해당 숫자의 인덱스 저장
                if(maxNum < number.charAt(j)-'0') {
                    maxNum = number.charAt(j)-'0';
                    idx = j;
                }
            }
            
            answer.append(maxNum);  // 출력값에 최댓값 이어붙이기
        }        
        
        return answer.toString();
    }
}
