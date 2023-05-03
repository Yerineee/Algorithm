import java.io.*;

public class BOJ_2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stairs = Integer.parseInt(br.readLine());	// 계단의 개수 (입력)
		int[] score = new int[stairs+1];	// 각 계단에 쓰여 있는 점수 (입력)
		int[] dp = new int[stairs+1];		// 각 계단에서 얻을 수 있는 점수의 최댓값
		
		for(int i=1;i<=stairs;i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = score[1];	// 첫번째 계단에서 얻을 수 있는 점수의 최댓값 = 첫번째 계단에 쓰여 있는 점수
		if(stairs>1) {
			dp[2] = score[1]+score[2];	// 두번째 계단에서 얻을 수 있는 점수의 최댓값 (첫번째 계단의 점수 + 두번째 계단의 점수)
			
			if(stairs>2) {
				// 각 계단에서 얻을 수 있는 점수의 최댓값
				for(int i=3;i<=stairs;i++) {
					dp[i] = score[i] + Math.max(dp[i-2], score[i-1]+dp[i-3]);
				}
			}
		}
		
		System.out.println(dp[stairs]);	// 게임에서 얻을 수 있는 총 점수의 최댓값
	}
}
