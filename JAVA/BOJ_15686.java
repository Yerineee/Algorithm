import java.util.*;
import java.io.*;

public class BOJ_15686 {
	static int n, m, ans = Integer.MAX_VALUE;
	static ArrayList<int[]> chicken, city;
	
	// 도시의 치킨 거리 구하기
	static void getDist(boolean[] open) {
		int res = 0; // 오픈한 치킨집에 대한 도시의 치킨 거리
		
		// 각 도시 별로 치킨 거리 구하기
		for(int i=0;i<city.size();i++) {
			int temp = Integer.MAX_VALUE;
			for(int j=0;j<open.length;j++) {
				if(open[j]) {
					temp = Math.min(temp,
							Math.abs(city.get(i)[0]-chicken.get(j)[0])+Math.abs(city.get(i)[1]-chicken.get(j)[1]));
				}
			}
			
			res += temp;
		}
		
		ans = Math.min(ans, res); // 도시의 치킨 거리 최솟값 갱신
	}
	
	// 오픈한 치킨집 조합 구하기
	static void openChicken(boolean[] open, int idx, int cnt) {
		if(cnt == m) {
			// 치킨 거리 계산
			getDist(open);
			return;
		}
		
		for(int i=idx;i<open.length;i++) {
			if(!open[i]) {
				open[i] = true;
				openChicken(open, i, cnt+1);
				open[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 도시 크기
		m = Integer.parseInt(st.nextToken()); // 가장 수익을 많이 내는 치킨 집 개수
		
		chicken = new ArrayList<>();
		city = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				// 집이면, city 배열에 위치 저장
				if(num == 1) {
					city.add(new int[] {i, j});
				}
				// 치킨집이면, chicken 배열에 위치 저장
				else if(num == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}

		boolean[] open = new boolean[chicken.size()]; // 폐업하지 않은 치킨집 (true면 오픈, false면 폐업)
		openChicken(open, 0, 0);
		
		System.out.println(ans);
	}
}
