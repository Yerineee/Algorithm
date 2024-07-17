class Solution {
    static String[] num = {"4", "1", "2"};
    
    public String solution(int n) {
        String answer = "";
        
        // 맨 뒷자리 한글자는 n을 3으로 나눈 나머지에 해당하는 수의 124 숫자
        // 그 앞의 글자들은 (n-1)을 3으로 나눈 몫에 해당하는 수의 124 숫자
        while(n > 0) {
            answer = num[n%3]+answer;
            n = (n-1)/3;
        }
        
        return answer;
    }
}
