import java.io.*;
import java.util.Arrays;

public class BOJ_10974 {
	static int N;
	static boolean[] check;	// 인덱스 방문 여부 체크할 배열
	static int[] ans;		// 결과 저장할 배열
	
	public static void backtracking(int cur, int cnt) {
		check[cur] = true;	// 현재 인덱스 방문을 체크
		ans[cnt] = cur;		// 결과를 ans 배열에 저장
		
		if(cnt == N) {	// N개의 수에 모두 방문했을 때는 순열 출력
			for(int i=1;i<N+1;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=1;i<N+1;i++) {	// 아직 방문하지 않은 숫자 방문
			if(!check[i]) {
				backtracking(i, cnt+1);
				check[i] = false;	// 다시 false 할당
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// N (1 ≤ N ≤ 8)
		check = new boolean[N+1];	// 인덱스 방문 여부 체크할 배열
		ans = new int[N+1];			// 결과 저장할 배열
		
		for(int i=1;i<N+1;i++) {
			Arrays.fill(check, false);
			backtracking(i,1);
		}
	}
}
