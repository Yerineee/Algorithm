import java.lang.StringBuilder;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
    
        int num = 0;    // 0부터 숫자 세기
        String nNum = "";   // n진법으로 변환한 숫자 이어붙여 저장
        // nNum의 길이가 t*m 이상이 될 때까지 숫자 이어붙이기 (대문자로 이어붙이기)
        while(nNum.length() < t*m) {
            nNum += Integer.toString(num++, n).toUpperCase();
        }
        
        // 튜브 순서의 숫자만 answer에 저장하기
        for(int i=0;i<t;i++) {
            answer.append(nNum.charAt(m*i+p-1));
        }
        
        return answer.toString();
    }
}
