import java.io.*;

public class BOJ_11727 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 직사각형 가로 길이 (입력)
		int[] dp = new int[n+1];	// 직사각형을 채우는 방법의 수를 10007로 나눈 나머지
		
		dp[1] = 1;
		if(n>1) dp[2] = 3;
		
		if(n>2) {
			for(int i=3;i<=n;i++) {
				// (2*i 직사각형 채우는 방법의 수) = (2*(i-1) 직사각형 채우는 방법의 수) + (2*(i-2) 직사각형 채우는 방법의 수) * 2
				dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
			}
		}
		
		System.out.println(dp[n]);	// 2*n 크기의 직사각형 채우는 방법의 수를 10007로 나눈 나머지 (출력)
	}
}
