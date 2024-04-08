class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // [구해야 하는 것 - 1번과 2번 더하기]
        // 1. 알파벳 바꾸는 횟수의 최솟값
        // 아래 2가지 방법을 비교하여 구하기
        // (1) 'A'에서 차례로 바꾸는 방법 - ('알파벳'-'A')번
        // (2) 'A'에서 'Z'를 거쳐서 바꾸는 방법 - ('Z'-'알파벳'+1)번
        // 2. 커서 위치 바꾸는 횟수의 최솟값
        
        int len = name.length();        // 이름의 총 길이
        int[] alpha = new int[len];     // 알파벳 바꾸는 횟수 저장할 배열
        
        // 커서 이동하는 경우의 수
        // (1) 첫 위치에서 오른쪽으로만 이동하는 경우
        // (2) 연속된 'A'를 만난다면
        //      (2)-1) 연속된 'A'까지 오른쪽으로 이동했다가 다시 왼쪽으로 이동
        //      (2)-2) 왼쪽으로 이동했다가 다시 연속된 'A'까지 오른쪽으로 이동
        int minCursor = name.length()-1;    // 커서 위치 바꾸는 횟수의 최솟값 - (1)의 경우로 변수 초기화
        for(int i=0;i<len;i++) {
            char c = name.charAt(i);
            
            // 1. 알파벳 바꾸는 횟수의 최솟값 구하고 배열에 저장
            alpha[i] = Math.min(c-'A', 'Z'-c+1);
            answer += alpha[i];
            
            
            // 2. 커서 위치 바꾸는 횟수의 최솟값
            int aPos = i+1;     // (연속된 'A' 중 마지막 'A'의 인덱스+1)의 값 저장
            while(aPos<len && name.charAt(aPos)=='A') {
                aPos++;
            }
            // 커서 이동하는 횟수 비교하여 최솟값으로 갱신
            minCursor = Math.min(minCursor, i+(len-aPos)+Math.min(i, len-aPos));
        }
        
        answer += minCursor;
        
        return answer;
    }
}
