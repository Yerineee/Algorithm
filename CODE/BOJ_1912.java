import java.io.*;
import java.util.*;

public class BOJ_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 수열의 크기 (입력)
		int[] dp = new int[n];	// 수의 합의 최댓값 저장
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			dp[i] = Integer.parseInt(st.nextToken());	// 수열의 i번째 수 (입력)
			
			if(i>0) {
				dp[i] = Math.max(dp[i], dp[i-1]+dp[i]);	// (i번째 수)와 ((i-1)번째 수까지의 합의 최댓값+i번째 수) 중 큰 값을 저장
			}
		}
		
		Arrays.sort(dp);	// dp 배열을 오름차순 정렬
		
		System.out.println(dp[n-1]);	// 가장 큰 수 출력

	}
}
