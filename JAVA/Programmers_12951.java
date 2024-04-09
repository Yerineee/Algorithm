class Solution {
    public String solution(String s) {
        String answer = "";
		
        String[] list = s.toLowerCase().split("");
		boolean isNextSpace = true; // 공백 바로 뒤에 오는 문자열인지 체크할 변수
        
		for(String str:list) {
            answer += isNextSpace?str.toUpperCase():str;  // 공백 바로 다음에 오는 문자열이면 대문자로 변환하고, 그렇지 않으면 소문자로
            isNextSpace = str.equals(" ")?true:false;   // 현재 문자열이 공백이면 isNextSpace 변수에 true를 저장하고, 그렇지 않으면 false 저장
        }
        
        return answer;
    }
}
