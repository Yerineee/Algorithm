import java.io.*;

public class BOJ_9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수 (입력)
		long[] P = new long[101];	// 정삼각형 변의 길이
		
		P[1] = P[2] = P[3] = 1;
		P[4] = P[5] = 2;
		
		// 테스트 케이스 개수만큼 반복
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());	// 몇 번째 정삼각형인지 (입력)
			
			// 입력 받은 N이 5보다 크다면
			if(N>5) {
				for(int i=6;i<=N;i++) {
					P[i] = P[i-1] + P[i-5];	// DP 이용하여 i번째 정삼각형 변의 길이 계산
				}
			}
			
			System.out.println(P[N]);	// N번째 정삼각형 변의 길이 (출력)
		}
	}
}
