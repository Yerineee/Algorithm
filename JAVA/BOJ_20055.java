import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055 {
	// 내구도가 0인 칸의 개수 세기
	static int count(int[] belt) {
		int res = 0;
		for(int i=0;i<belt.length;i++) {
			if(belt[i] == 0) res++;
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
		int k = Integer.parseInt(st.nextToken()); // 내구도 0인 칸의 개수
		int[] belt = new int[2*n]; 			// 내구도 배열
		boolean[] robot = new boolean[n]; // 로봇 유무
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*n;i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		while(true) {
			ans++;
			
			// 1. 벨트와 로봇 한 칸씩 회전
			int temp = belt[2*n-1];
			for(int i=2*n-1;i>0;i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = temp;
			
			for(int i=n-2;i>0;i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			robot[n-1] = false;
			
			// 2. 올리는 칸부터 로봇 이동 (이동하려는 칸에 로봇이 없고, 그 칸의 내구도가 1 이상이어야 함)
			for(int i=n-1;i>0;i--) {
				if(robot[i-1] && !robot[i] && belt[i]>0) {
					robot[i] = robot[i-1];
					robot[i-1] = false;
					belt[i]--;
				}
			}
			
			// 3. 올리는 칸의 내구도가 1 이상이면 로봇 올리기
			if(belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			// 내구도가 0인 칸의 개수가 k개 이상이면 종료
			if(count(belt) >= k) break;
		}

		System.out.println(ans);
	}
}
