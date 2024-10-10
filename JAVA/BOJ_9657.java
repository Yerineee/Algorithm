import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9657 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001]; // 1은 SK가 이기는 경우, 2는 CY가 이기는 경우
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 1;
		for(int i=5;i<=n;i++) {
			// 만약 돌을 1, 3, 4개 가져갔을 때, CY가 이기는 경우의 수가 있다면 SK가 이김
			if(dp[i-1]==2 || dp[i-3]==2 || dp[i-4]==2) dp[i] = 1;
			// SK가 이기는 경우의 수가 없다면 CY가 이김
			else dp[i] = 2;
		}
		
		if(dp[n] == 1) System.out.println("SK");
		else System.out.println("CY");
	}
}
