import java.util.*;

class Solution {    
    static String solve(String input) {
        // 1. 입력이 빈 문자열이면, 빈 문자열 반환
        if(input.equals("")) return input;
        
        // 2. 균형잡힌 괄호 문자열로 분리
        int left = 0, right = 0, idx;
        for(idx=0;idx<input.length();idx++) {
            if(input.charAt(idx) == '(') {
                left++;
            } else {
                right++;
            }
            
            if(left == right) break;
        }
        
        String u = input.substring(0, idx+1);
        String v = input.substring(idx+1);
        
        // 3. u가 올바른 문자열일 때
        if(isCorrect(u)) {
            return u + solve(v);
        }
        // 4. u가 올바르지 않은 문자열일 때
        else {
            return correctStr(u, v);
        }
    }
    
    // 2번 단계에서 올바른 괄호 문자열인지 체크해주는 함수
    static boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        
        
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == ')') {
                if(stack.size() > 0 && stack.peek() == '(') stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
    
    // 4. u가 올바르지 않을 때, u와 v를 매개변수로 받아 생성된 문자 반환하는 함수
    static String correctStr(String u, String v) {
        // 4-1 ~ 4-3. "("에 1번부터의 과정을 거친 v와 ")"를 이어붙이기
        String res = "(" + solve(v) + ")";

        // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열을 뒤집어서 이어붙이기
        for(int i=1;i<u.length()-1;i++) {
            if(u.charAt(i) == '(') {
                res += ")";
            } else {
                res += "(";
            }
        }
        
        return res;
    }
    
    public String solution(String p) {
        String answer = solve(p);
        
        return answer;
    }
}
