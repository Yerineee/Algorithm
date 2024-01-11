import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2138 {
	static int N, ans=Integer.MAX_VALUE;
	
	// 전구 상태 배열에 저장하고 해당 배열을 반환하는 함수
	public static int[] saveState(String input) {
		int[] state = new int[N];
		
		for(int i=0;i<N;i++) {
			state[i] = input.charAt(i)-'0';
		}
		
		return state;
	}
	
	// 만들고자 하는 상태를 만들기 위해 탐색하는 함수
	// 매개변수 : cur(현재 전구 상태), target(만들고자 하는 전구 상태), idx(현재 탐색 중인 인덱스), cnt(현재까지 누른 스위치 개수)
	public static void search(int[] cur, int[] target, int idx, int cnt) {
		// 현재 인덱스(idx)가 N-1보다 크다면 함수 종료
		if(idx > N-1) {
			return;
		}
		
		// (idx-1)번째 전구의 현재 상태가 만들고자 하는 상태와 다른 경우 idx번째 스위치 누르기
		if(cur[idx-1] != target[idx-1]) {
			cur[idx-1] = 1-cur[idx-1];
			cur[idx] = 1-cur[idx];
			if(idx<N-1) cur[idx+1] = 1-cur[idx+1];	// 현재 인덱스(idx)가 N-1이면 (idx-1)번째와 idx번째 전구 상태만 변경되므로 해당 코드 실행하지 않음
			cnt++;	// 누른 스위치 개수 1만큼 증가
		}
		
		// 만약 현재 전구 상태와 만들고자 하는 전구 상태가 같다면, ans 변수와 cnt 변수를 비교하여 최솟값을 ans에 저장한 후 함수 종료
		if(Arrays.equals(cur, target)) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		// 다음 인덱스로 이동하여 탐색
		search(cur, target, idx+1, cnt);		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());// 전구 개수
		int[] cur = new int[N];		// 전구의 현재 상태
		int[] target = new int[N];	// 우리가 만들고자 하는 전구 상태
		
		// 전구의 현재 상태와 우리가 만들고자 하는 전구 상태를 배열에 저장
		cur = saveState(br.readLine());
		target = saveState(br.readLine());
		
		// 전구의 현재 상태와 우리가 만들고자 하는 전구 상태가 같다면 스위치를 누를 필요가 없으므로 0 출력
		if(Arrays.equals(cur, target)) {
			System.out.println(0);
		} else {
			// 0번째 스위치를 누르는 경우와 0번째 스위치를 누르지 않는 경우로 나누어 풀이
			int[] temp = Arrays.copyOf(cur, cur.length);
			
			// 1. 0번째 스위치를 누르지 않았을 경우
			search(cur, target, 1, 0);
			
			// 2. 0번째 스위치를 눌렀을 경우
			temp[0] = 1-temp[0];
			temp[1] = 1-temp[1];
			search(temp, target, 1, 1);
			
			// ans가 N보다 클 경우, 만들고자 하는 상태로 만들 수 없으므로 -1 출력
			if(ans > N) {
				System.out.println(-1);
			} else {	// 만들고자 하는 상태를 만들기 위해 스위치를 최소 몇 번 눌러야 하는지 출력
				System.out.println(ans);
			}
		}
	}
}
