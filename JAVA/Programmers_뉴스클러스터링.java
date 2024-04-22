import java.util.ArrayList;
import java.util.regex.Pattern;

class Solution {
    public static ArrayList<String> saveStr(String str) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<str.length()-1;i++) {
            String substr = str.substring(i, i+2).toUpperCase();    // 두글자씩 끊기
            String REGEXP = "^[A-Z][A-Z]$";
            
            // 영문자 대문자로만 이루어져 있을 경우, 리스트에 저장
            if(Pattern.matches(REGEXP, substr)) {
                list.add(substr);
            }
        }
        
        return list;
    }
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> list1 = saveStr(str1);
        ArrayList<String> list2 = saveStr(str2);
        
        int list1Size = list1.size();   // 리스트 1 크기
        int list2Size = list2.size();   // 리스트 2 크기
        
        // 교집합 (intersection)
        int intersection = 0;
        for(String str : list1) {
            // 해당 문자열이 리스트 2에 포함되어 있다면, intersection 1 증가 후 리스트 2에서 해당 문자열 삭제 (다중 집합 고려)
            if(list2.contains(str)) {
                intersection++;
                list2.remove(str);
            }
        }
        
        // 합집합 (union)
        int union = list1Size + list2Size - intersection;
        
        // 두 집합 모두 공집합인 경우 예외 처리
        double j = union==0 ? 1 : (double) intersection / (double) union;
        answer = (int) Math.floor(j * 65536);
        
        return answer;
    }
}
