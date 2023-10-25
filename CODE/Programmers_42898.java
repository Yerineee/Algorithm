class Solution {
    // 매개변수 (m, n: 격자의 크기, puddles: 물이 잠긴 지역 좌표)
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        // 동적 계획법을 이용하여 학교까지 가는 방법의 수 구할 배열
        int[][] dp = new int[n+1][m+1];
        
        // 물에 잠긴 지역을 -1로 표시
        for(int i=0;i<puddles.length;i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                // 만약 해당 배열 요소의 값이 -1이면(물에 잠긴 지역이라면) 지나갈 수 없는 길이므로 0 저장
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위치가 (1, 1)인 경우, 1 저장
                if(i==1 && j==1) {
                    dp[i][j] = 1;
                } else if(i == 1) {  // 첫 번째 행의 경우, 왼쪽을 통해서만 해당 위치에 올 수 있으므로 dp[i][j-1] 저장
                    dp[i][j] = dp[i][j-1];
                } else if(j == 1) { // 첫 번째 열의 경우, 윗쪽을 통해서만 해당 위치에 올 수 있으므로 dp[i-1][j] 저장
                    dp[i][j] = dp[i-1][j];
                } else { // 나머지 경우, 왼쪽과 윗쪽(두 가지 경우)을 통해 해당 위치에 올 수 있으므로 두 가지 경우의 수를 더함
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }
        
        answer = dp[n][m];  // answer 변수에 (n, m)에 갈 수 있는 최단 경로의 수를 1,000,000,007로 나눈 나머지 저장
        
        return answer;
    }
}
