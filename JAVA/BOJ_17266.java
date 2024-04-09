import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17266 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 굴다리의 길이 n
		int m = Integer.parseInt(br.readLine());	// 가로등의 개수 m
		int[] x = new int[m+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로등의 위치 x
		for(int i=1;i<=m;i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 가로등 최소 높이가 될 수 있는 경우의 수 (아래 경우 들 중 최댓값)
		 * 1. 첫 번재 가로등 위치와 0(굴다리 시작 위치) 사이의 거리
		 * 2. 마지막 가로등 위치와 n(굴다리 끝 위치) 사이의 거리
		 * 3. (가로등 사이의 거리)/2 => (가로등 개수가 1개보다 많은 경우)
		 */
		
		x[0] = x[1];	// 1번 경우
		// (가로등 개수가 1개보다 많다면) 3번 경우
		if(m>1) {
			for(int i=1;i<m;i++) {
				x[i] = (int)Math.ceil((double)(x[i+1]-x[i])/2);
			}
		}
		x[m] = n-x[m];	// 2번 경우
		
		Arrays.sort(x);	// 배열 x 오름차순 정렬
		System.out.println(x[m]);	// 배열 x의 최댓값 출력 (가로등 최소 높이)
	}
}

// 이분탐색 풀이법
/*
public class BOJ_17266 {
	static int n, m;
	static int[] x;
	
	// height의 높이로 모든 곳을 비출 수 있는지 확인하는 함수
	public static boolean isPossible(int height) {
		int prevX = 0;	// 이전 가로등이 비춘 위치
		
		for(int i=0;i<m;i++) {
			// 현재 위치에서 height를 뺀 위치가 이전 가로등이 비춘 위치보다 작거나 같다면 모두 비추고 있다는 의미
			if(x[i]-height <= prevX) {
				prevX = x[i]+height;	// prevX를 현재 가로등이 비추는 위치로 갱신
			}
			// 그렇지 않다면, 비추지 않는 곳이 있으므로 false 반환
			else {
				return false;
			}
		}
		
		// 마지막 가로등이 비추는 위치가 굴다리의 끝 위치보다 크거나 같은지 확인 (모두 비추는지)
		return x[m-1]+height >= n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	// 굴다리의 길이 n
		m = Integer.parseInt(br.readLine());	// 가로등의 개수 m
		x = new int[m];	// 가로등의 위치 x
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로등의 위치 x 저장
		for(int i=0;i<m;i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;	// 가로등 최소 높이
		// 이분탐색
		int left = 1;	// 굴다리 최소 길이 1
		int right = n;	// 굴다리 최대 길이 n
		while(left<=right) {
			int mid = (left+right)/2;
			
			// mid 높이의 가로등이 모든 곳을 비춘다면
			if(isPossible(mid)) {
				ans = mid;		// ans 변수에 mid 저장
				right = mid-1;	// right 값 수정해서 계속 탐색
			}
			// 모든 곳을 비추지 않다면 left 값 수정해서 계속 탐색
			else {
				left = mid+1;
			}
		}
		
		System.out.println(ans);
	}
}
*/
