import java.util.*;

class Solution {
    static int start = Integer.MAX_VALUE, end = Integer.MAX_VALUE;
    static int len = Integer.MAX_VALUE;
    
    // 부분 수열 찾는 함수
    static void searchArr(int[] sequence, int k) {
        int right = 0, sum = 0;
        
        // 투포인터 이용하여 탐색
        for(int left=0;left<sequence.length;left++) {
            while(right<sequence.length && sum<k) {
                sum += sequence[right++];
            }
            
            // k가 된다면, 시작 인덱스, 끝 인덱스, 길이 저장
            if(sum == k) {
                if(right-left<len || right-left==len&&left<start) {
                    start = left;
                    end = right-1;
                    len = right-left;
                }
            }
            
            sum -= sequence[left];
        }
    }
    
    public int[] solution(int[] sequence, int k) {
        searchArr(sequence, k);
        
        return new int[]{start, end};
    }
}
