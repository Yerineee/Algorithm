import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 수열 a의 크기
		int[] a = new int[n]; // 수열 a
		
		// 수열 a 저장하기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n]; // 증가하는 부분 수열의 합 저장
		dp[0] = a[0];
		for(int i=1;i<n;i++) {
			dp[i] = a[i]; // i번째 수까지 증가하는 부분 수열 합의 최댓값
			
			for(int j=0;j<i;j++) {
				// j번째 수보다 i번째 수가 크다면, max 갱신
				if(a[j] < a[i]) {
					dp[i] = Math.max(dp[i], dp[j]+a[i]);
				}
			}
		}
		
		Arrays.sort(dp); 			 // dp 배열 오름차순 정렬
		System.out.println(dp[n-1]); // 최댓값 출력
	}
}
