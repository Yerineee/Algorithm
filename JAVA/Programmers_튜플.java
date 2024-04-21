// 방법 1.
// replaceAll() 메소드와 trim() 메소드 활용하여 (방법 2)보다 더 깔끔
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        // 각 집합을 나누어 sets 배열에 저장
        String[] sets = s.replaceAll("[{]"," ").replaceAll("[}]"," ").trim().split(" , ");
        Arrays.sort(sets, (String s1, String s2) -> s1.length()-s2.length());  // 원소의 개수에 따라 집합을 오름차순으로 정렬
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<sets.length;i++) {
            String[] nums = sets[i].split(",");

            // 해당 원소가 arraylist에 없다면 저장해주기
            for(int j=0;j<nums.length;j++) {
                int num = Integer.parseInt(nums[j]);
                
                if(!answer.contains(num)) answer.add(num);
            }
        }
        
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}

// 방법 2.
/*
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1);   // 중괄호 제외한 문자열
        
        // 문자열 s를 "}" 기준으로 나누어 배열에 저장하고, 길이 기준으로 오름차순 정렬
        String[] sets = s.split("\\}");
        Arrays.sort(sets, (String s1, String s2) -> s1.length()-s2.length());
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<sets.length;i++) {
            String[] set = sets[i].split(",|\\{");

            // 해당 원소가 arraylist에 없다면 저장해주기
            for(int j=0;j<set.length;j++) {
                if(set[j].equals("")) continue;
                
                int num = Integer.parseInt(set[j]);
                
                if(!answer.contains(num)) answer.add(num);
            }
        }
        
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
*/
