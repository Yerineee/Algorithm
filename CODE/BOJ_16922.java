import java.io.*;
import java.util.*;

public class BOJ_16922 {
	static int N, res=0;	// res : 만들 수 있는 수의 개수
	static int[] num = {1, 5, 10, 50};	// 로마 문자(I, V, X, L) 숫자 저장
	static int[] ans;
	
	public static void backtracking(int idx, int cnt, int sum) {
		if(cnt == N) {			// N개의 문자를 모두 탐색한 경우
			if(ans[sum] == 0) {	// 해당 수를 아직 만들지 않았다면
				ans[sum] = 1;	// 해당 수를 만들었음을 체크
				res++;			// 결과값(만들 수 있는 수의 개수)+1
			}
			
			return;
		}
		
		for(int i=idx;i<4;i++) {	// 탐색
			backtracking(i, cnt+1, sum+num[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());	// 문자 개수
		ans = new int[1001];	// 만들 수 있는 수 저장할 배열 (만들 수 있으면 1로 표시)
		
		backtracking(0, 0, 0);	// 백트래킹 이용
		
		bw.write(Integer.toString(res));	//	만들 수 있는 수의 개수 출력
		bw.flush();
		bw.close();
	}
}
