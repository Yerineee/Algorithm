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

/*
// 스택을 사용한 풀이법
import java.lang.StringBuilder;
import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        int restLen = number.length()-k;    // 남겨야 할 숫자 개수
        
        for(int i=0;i<number.length();i++) {
            char c = number.charAt(i);  // 해당 자리의 숫자
            
            // 스택이 비어있지 않고, 해당 자리의 숫자가 스택 최상단 숫자보다 크고, k가 0보다 크다면 스택 최상단 숫자 꺼내기
            while(!stack.isEmpty() && stack.peek()<c && k-->0) {
                stack.pop();
            }
            
            stack.push(c);  // 스택에 해당 자리의 숫자 저장
        }
    
        // 남겨야 할 숫자 개수만큼 answer에 저장
        for(int i=0;i<restLen;i++) {
            answer.append(stack.get(i));
        }
        
        return answer.toString();
    }
}
*/
