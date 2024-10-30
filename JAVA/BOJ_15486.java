import java.io.*;
import java.util.*;

public class BOJ_15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 남은 날짜
		
		int[] time = new int[n+2];  // 상담 기간
		int[] price = new int[n+2]; // 상담 가격
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+2];
		int max = 0; // 최대 가격
		for(int i=1;i<n+2;i++) {
			int next = i+time[i]; // 이번 상담이 끝나고 상담 가능한 날짜
			max = Math.max(max, dp[i]); // max 값 갱신
			
			if(next > n+1) continue; // 범위 벗어나면 넘어가기
			dp[next] = Math.max(dp[next], max+price[i]);
		}
		
		System.out.println(max);
	}
}
