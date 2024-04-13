import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<Character> list = new ArrayList<>();
        for(int i=0;i<skill.length();i++) {
            list.add(skill.charAt(i));
        }
        
        for(int i=0;i<skill_trees.length;i++) {
            String skillStr = skill_trees[i];
            int idx = 0;
            boolean flag = true;
            
            for(int j=0;j<skillStr.length();j++) {
                // 선행 스킬에 없는 스킬이면 넘어가기
                if(!list.contains(skillStr.charAt(j))) continue;
                
                // 선행 스킬 순서에 맞는 스킬인 경우
                if(skillStr.charAt(j) == skill.charAt(idx)) {
                    idx++;
                }
                // 선행 스킬 순서에 맞지 않는 스킬인 경우
                else {
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        
        return answer;
    }
}
