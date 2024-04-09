class Solution {
    public int dfs(int[] numbers, int target, int idx, int sum) {   // 숫자 배열, 타겟 넘버, 현재 인덱스, 합계
        if(idx == numbers.length-1) {   // 마지막 인덱스일 때
            if(sum == target) { // 합계가 타겟 넘버와 같다면 1 반환
                return 1;
            }
            
            return 0;   // 합계가 타겟 넘버와 다르다면 0 반환
        }
        
        return dfs(numbers, target, idx+1, sum+numbers[idx+1]) + dfs(numbers, target, idx+1, sum-numbers[idx+1]);  // 해당 인덱스 숫자를 더했을 때와 뺐을 때
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
       // dfs 이용
        answer = dfs(numbers, target, 0, numbers[0]) + dfs(numbers, target, 0, -numbers[0]);
        
        return answer;
    }
}
