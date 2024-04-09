import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 1. 몸무게를 정렬
        // 2. 가장 무거운 사람과 가장 가벼운 사람을 짝지을 수 있다면 짝지어서 보트에 같이 태운다. (짝짓지 못한다면 무거운 사람 혼자 태우기)
        Arrays.sort(people);            // 몸무게 정렬
        int right = people.length-1;    // 현재까지 구명보트에 타지 않은 사람들 중 가장 무거운 사람
        int left = 0;                   // 현재까지 구명보트에 타지 않은 사람들 중 가장 가벼운 사람
        
        
        while(left<=right) {
            answer++;
            
            // 가벼운 사람과 무거운 사람의 몸무게 합이 무게 제한보다 작거나 같다면, 보트에 같이 태운다.
            if(left<right && people[right]+people[left]<=limit) {
                left++;
            }
            
            right--;
        }
        
        return answer;
    }
}
