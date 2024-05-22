// 1. 이중 for문 이용
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length-1;i++) {
            for(int j=i+1;j<prices.length;j++) {
                answer[i]++;
                
                // 가격이 떨어진 경우
                if(prices[j] < prices[i]) break;
            }
        }
        
        return answer;
    }
}

// 2. 스택 이용
/*
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();        
        
        for(int i=0;i<prices.length;i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i-idx;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = prices.length-1-idx;
        }
        
        return ans;
    }
}
*/
