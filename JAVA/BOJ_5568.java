import java.io.*;
import java.util.*;

public class BOJ_5568 {
	static int n, k;
	static int[] num, ans;
	static boolean[] check;
	static HashSet<String> set;
	
	public static void backtracking(int idx, int cnt) {
		check[idx] = true;	// 방문 체크
		ans[cnt-1] = num[idx];	// 배열에 카드 숫자 저장
		
		if(cnt == k) {	// k개의 카드 탐색했을 경우
			String str="";
			for(int i=0;i<k;i++) {	// 카드 나열해서 만든 정수를 str 변수에 저장
				str = str.concat(Integer.toString(ans[i]));
			}
			set.add(str);	// set에 정수 저장 (중복 방지)
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!check[i]) {	// 아직 방문하지 않은 카드일 경우
				backtracking(i, cnt+1);	// 방문 탐색
				check[i] = false;		// 다시 방문 여부 false로 재할당
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 카드 개수
		k = Integer.parseInt(br.readLine());	// 상근이가 선택한 카드 개수
		num = new int[n];	// 카드에 적혀있는 수 저장
		check = new boolean[n];  // 방문 여부 저장
		ans = new int[k];   // 나열한 수 저장
		
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		set = new HashSet<String>();	// 만들 수 있는 정수 저장할 집합
		
		for(int i=0;i<n;i++) {
			Arrays.fill(check, false);	// check 배열의 모든 요소에 false 할당(방문 여부 초기화)
			backtracking(i, 1);	// 방문 탐색
		}
		
		
		System.out.println(set.size());	// 만들 수 있는 정수 개수 출력
	}
}
