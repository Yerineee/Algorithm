import java.util.*;
import java.io.*;

public class BOJ_21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 지난 일수
		int x = Integer.parseInt(st.nextToken()); // 기준 일수
		
		String[] input = br.readLine().split(" "); // 입력 받은 하루 방문자 수
		int[] dp = new int[n];	// 누적 방문자 수
		for(int i=0;i<n;i++) {
			dp[i] = i==0 ? Integer.parseInt(input[i]) : dp[i-1]+Integer.parseInt(input[i]);
		}
		
		// X일 동안의 누적 방문자 수 저장
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=x-1;i<n;i++) {
			if(i == x-1) {
				list.add(dp[i]);
			} else {
				list.add(dp[i]-dp[i-x]);
			}
		}
		
		Collections.sort(list); // 누적 방문자 수를 오름차순으로 정렬
		int max = list.get(list.size()-1); // X일 동안 가장 많이 들어온 방문자 수
		
		// 최대 방문자 수가 0이면, "SAD" 출력
		if(max == 0) {
			System.out.println("SAD");
		} else {
			// 그렇지 않으면, 최대 방문자 수와 그 기간 출력
			System.out.println(max);
			System.out.println(Collections.frequency(list, max));
		}
	}
}
