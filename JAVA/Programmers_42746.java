import java.util.Comparator;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strs = new String[numbers.length];
        
        // 정수를 문자열로 변환
        for(int i=0;i<numbers.length;i++) {
            strs[i] = Integer.toString(numbers[i]);
        }
        
        // 내림차순 정렬
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        };
        
        Arrays.sort(strs, comparator);

        // 문자열 배열을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++) {
            sb.append(strs[i]);
        }
        answer = sb.toString();

        // 0으로 시작되는 문자열은 "0"을 반환
        if(answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;   
        }
    }
}
