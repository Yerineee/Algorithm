import java.util.*;

public class BOJ_12852 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		HashMap<Integer, String> map = new HashMap<>(); // (숫자, 1로 만드는 방법)
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		map.put(1, "1");
		
		for(int i=2;i<=n;i++) {
			int min = i; // dp[i]가 최소가 되는 연산 결과
			
			// 1. 3으로 나누어 떨어지고, 그때의 dp값이 최솟값이면 3으로 나누기
			if(i%3 == 0 && dp[i] > dp[i/3]+1) {
				dp[i] = dp[i/3]+1;
				min = i/3;
			}
			// 2. 2로 나누어 떨어지고, 그때의 dp값이 최솟값이면 2로 나누기
			if(i%2 == 0 && dp[i] > dp[i/2]+1) {
				dp[i] = dp[i/2]+1;
				min = i/2;
			}
			// 3. 1 빼기
			if(dp[i] > dp[i-1]+1) {
				dp[i] = dp[i-1]+1;
				min = i-1;
			}
			
			// 4. i를 1로 만드는 방법 저장
			String method = i+" "+map.get(min);
			map.put(i, method);
		}
		
		System.out.println(dp[n]);
		System.out.println(map.get(n));
	}
}
