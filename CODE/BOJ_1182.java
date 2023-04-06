import java.io.*;
import java.util.*;

public class BOJ_1182 {
	static int N, S, ans = 0;	// ans: 부분수열의 개수 (결과값)
	static int[] arr;
	
	public static void backtracking(int cur, long sum) {
		if(cur == N) {	// 현재 N-1 인덱스일 경우
			if(sum == S) {	// 수열의 합이 S일 경우
				ans++;		// ans + 1
			}
			
			return;
		}
		
		backtracking(cur+1, sum);	// i 인덱스에 방문하지 않음
		backtracking(cur+1 , sum+arr[cur]);	// i 인덱스에 방문
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 정수 개수 N
		S = Integer.parseInt(st.nextToken());	// 정수 S
		arr = new int[N];	// 수열 저장할 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	// 수열을 배열에 저장
		}
		
		Arrays.sort(arr);	// 배열을 오름차순으로 정렬
		
		backtracking(0,0);
		
		System.out.println(S==0 ? ans-1 : ans);	// 공집합인 경우 제외
	}
}
