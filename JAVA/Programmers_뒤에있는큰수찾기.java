import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 스택에 {인덱스, 숫자} 형식으로 저장
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0;i<numbers.length;i++) {
            // 스택의 top에 있는 숫자보다 numbers[i]가 크다면 top 꺼내기
            while(!stack.isEmpty() && stack.peek()[1]<numbers[i]) {
                answer[stack.pop()[0]] = numbers[i];
            }
            
            stack.push(new int[]{i, numbers[i]});
        }
        
        // 스택이 비어있지 않다면, 숫자를 꺼낸 후 해당 인덱스에 -1 저장
        while(!stack.isEmpty()) {
            answer[stack.pop()[0]] = -1;
        }
        
        return answer;
    }
}
