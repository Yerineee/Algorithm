import java.util.Scanner;
import java.util.Arrays;

public class BOJ_10844 {
	static final long MOD = 1_000_000_000L;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 수의 길이
		long[][] dp = new long[n+1][10]; // 행:수의 길이, 열:시작숫자
		
		Arrays.fill(dp[1], 1); // 길이가 1일 때
		
		for(int i=2;i<n+1;i++) {
			for(int j=0;j<10;j++) {
				// 1. 0에 인접한 숫자는 1만 가능
				if(j == 0) {
					dp[i][j] = dp[i-1][1]%MOD;
				}
				// 2. 9에 인접한 숫자는 8만 가능
				else if(j == 9) {
					dp[i][j] = dp[i-1][8]%MOD;
				}
				// 3. j가 1~8일 때 인접한 숫자는 (j-1)과 (j+1) 둘 다 가능
				else {
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%MOD;
				}
			}
		}

		long answer = 0;
		for(int i=1;i<10;i++) {
			answer += dp[n][i];
		}
		
		System.out.println(answer%MOD);
	}
}
