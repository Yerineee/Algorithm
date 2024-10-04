import java.util.*;
import java.io.*;

public class BOJ_1965 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 상자의 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] box = new int[n]; // 상자의 크기
		for(int i=0;i<n;i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		dp[0] = 1;
		
		for(int i=1;i<n;i++) {
			int max = 0; // 최대 상자 개수
			/*
			 * max를 처음에 1로 초기화해줬더니 '틀렸습니다'가 떴음
			 * => 반복문 맨마지막에 dp[i]를 (max+1)로 설정해주기 때문에, 해당 상자에 넣을 수 있는 상자가 없더라도 dp[i]가 1이 아니라 2로 설정되어버림
			 */
			
			for(int j=0;j<i;j++) {
				// 더 작은 크기의 상자이고, max 값보다 더 크면 max 갱신
				if(box[j]<box[i])
					max = Math.max(max, dp[j]);
			}
			
			dp[i] = max+1;
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}
}
