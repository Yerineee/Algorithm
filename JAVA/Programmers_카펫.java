class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown/2+2;            // 가로, 세로의 합
        int multiply = brown+yellow;    // 가로, 세로의 곱
        for(int i=1;i<=sum/2;i++) {
            if(i*(sum-i) == multiply) {
                // 가로 길이가 세로 길이보다 길거나 같으므로 (sum-i)가 가로 길이
                answer = new int[]{sum-i, i};
                break;
            }
        }
        
        return answer;
    }
}
