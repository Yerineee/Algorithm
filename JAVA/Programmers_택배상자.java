import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        // 보조 컨테이너 벨트
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1;i<order.length+1;i++) {
            stack.push(i);  // 보조 컨테이너 벨트에 상자 보관
            
            while(!stack.isEmpty()) {
                // 보조 컨테이너 벨트의 맨 앞 상자와 현재 트럭에 실어야 하는 상자 순서와 같다면, answer 1 증가
                if(stack.peek() == order[answer]) {
                    stack.pop();
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}
