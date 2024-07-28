import java.util.Arrays;

class Solution {
    // 첫 번째 스티커를 떼는 경우는 n-2까지, 떼지 않는 경우는 n-1까지 dp 구하기
    static int search(int sticker[], int n, int end) {
        int[] dp = new int[n];
        
        // 첫 번째 스티커를 떼지 않는 경우
        if(end == n-1) sticker[0] = 0;
        
        for(int i=0;i<=end;i++) {
            if(i<2) {
                dp[i] = sticker[i];
            } else if(i==2) {
                dp[i] = dp[i-2]+sticker[i];
            } else {
                dp[i] = Math.max(dp[i-3], dp[i-2])+sticker[i];
            }
        }
        
        return Math.max(dp[end-1], dp[end]);
    }
    
    public int solution(int sticker[]) {
        int n = sticker.length; // 스티커 개수
        
        if(n <=3) {
            Arrays.sort(sticker);
            return sticker[n-1];
        }
        
        return Math.max(search(sticker, n, n-2), search(sticker, n, n-1));
    }
}
