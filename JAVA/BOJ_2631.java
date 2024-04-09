import java.io.*;
import java.util.Arrays;

public class BOJ_2631 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 아이들의 수 (입력)
		int[] children = new int[N];	// 아이들의 위치 (입력)
		int[] dp = new int[N];			// 증가 수열 길이
		
		for(int i=0;i<N;i++) {
			children[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;
		
		// LIS (최장 증가 부분 수열) 이용
		for(int i=1;i<N;i++) {
			dp[i] = 0;

			// i번째 아이 앞에 있는 아이들을 차례로 탐색
			for(int j=0;j<i;j++) {
				// i번째 아이가 앞에 있는 j번째 아이보다 키가 큰 경우
				if(children[i] > children[j])
					dp[i] = Math.max(dp[i], dp[j]);	// dp[i]와 dp[j] 중 큰 수를 dp[i]에 저장
			}
			
			dp[i] += 1;
		}
		
		Arrays.sort(dp);	// dp 배열을 오름차순 정렬
		
		System.out.println(N-dp[N-1]);	// (아이들의 수) - (최장 증가 부분 수열의 길이)
	}
}
