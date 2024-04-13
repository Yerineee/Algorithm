import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0; // 폰켓몬 종류 번호의 개수
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        
        // 저장된 폰켓몬의 종류보다 가져갈 수 있는 폰켓몬 마릿수가 더 작다면, 가져갈 수 있는 폰켓몬 마릿수 반환
        // 저장된 폰켓몬의 종류가 더 작거나 같다면, 저장된 폰켓몬 종류 반환
        answer = set.size() > nums.length/2 ? nums.length/2 : set.size();
        
        return answer;
    }
}
