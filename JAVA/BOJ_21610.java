import java.util.*;
import java.io.*;

class Location {
	int r, c;
	
	Location(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BOJ_21610 {
	static int n, m;
	static int[][] a;
	static ArrayList<Location> cloud = new ArrayList<>();
	static boolean[][] visit; // 이전에 생성된 구름
	static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	
	// 구름 이동 (d: 방향, s: 거리)
	static void moveCloud(int d, int s) {
		for(int i=0;i<cloud.size();i++) {
			// 구름을 d 방향으로 s칸 이동
			Location next = cloud.get(i);
			
			int nr = (n+next.r+dir[d][0]*(s%n))%n;
			int nc = (n+next.c+dir[d][1]*(s%n))%n;
			
			cloud.set(i, new Location(nr, nc));
			a[nr][nc]++;
			visit[nr][nc] = true;
		}
	}
	
	// 비 내려서 물 1 증가 + 물복사버그마법
	static void addWater() {
		for(int i=0;i<cloud.size();i++) {
			Location cur = cloud.get(i);

			// 대각선 방향에 물이 있으면 cnt를 1 증가
			for(int j=1;j<=7;j+=2) {
				int nr = cur.r + dir[j][0];
				int nc = cur.c + dir[j][1];
				
				if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
				
				if(a[nr][nc] > 0) a[cur.r][cur.c]++; 
			}
		}
	}
	
	static void makeCloud() {
		cloud.clear(); // 구름 모두 삭제
		
		// 물이 2 이상이고, 이전에 있던 구름이 아니면 구름 생성
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]>=2 && !visit[i][j]) {
					a[i][j] -= 2;
					cloud.add(new Location(i, j));
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			Arrays.fill(visit[i], false);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 격자 크기
		m = Integer.parseInt(st.nextToken()); // 명령 개수
		
		// 구름의 위치
		visit = new boolean[n][n];
		for(int i=n-2;i<n;i++) {
			for(int j=0;j<2;j++) {
				cloud.add(new Location(i, j));
			}
		}
		
		// 각 칸의 바구니 속 물의 양
		a = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); // 방향
			int s = Integer.parseInt(st.nextToken()); // 거리
			
			moveCloud(d-1, s);
			addWater();
			makeCloud();
		}

		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans += a[i][j];
			}
		}
		
		System.out.println(ans);
	}
}
