import java.io.*;
import java.util.*;

class Point {
	int r, c;
	
	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BOJ_17144 {
	static int r, c;
	static int[][] map;
	static Point cleaner;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 1. 미세먼지 확산
	static void spreadDust() {
		int[][] amount = new int[r+1][c+1]; // 각 칸에서 상하좌우로 확산되는 미세먼지의 양 (해당 칸의 미세먼지의 양/5)
		
		// 상하좌우로 확산될 미세먼지 양 구하기
		for(int i=1;i<=r;i++) {
			for(int j=1;j<=c;j++) {
				if(map[i][j] == -1 || map[i][j] == 0) {
					amount[i][j] = map[i][j];
				} else {
					amount[i][j] = (int) Math.floor((double)map[i][j]/5);
				}
			}
		}
		
		for(int i=1;i<=r;i++) {
			for(int j=1;j<=c;j++) {
				if(amount[i][j]==0 || amount[i][j]==-1) continue; // 확산될 미세먼지가 없다면 넘어가기
				int cnt = 0; // 상하좌우 중 몇 개의 방향으로 확산되는지
				
				for(int k=0;k<4;k++) {
					int tempR = i+dr[k];
					int tempC = j+dc[k];
					
					// 공기청정기 위치이거나 집의 범위를 벗어나는 경우 넘어가기
					if(tempR<=0 || tempR>r || tempC<=0 || tempC>c || map[tempR][tempC]==-1) continue;
					
					map[tempR][tempC] += amount[i][j]; // 확산되는 미세먼지 양 더하기
					cnt++;
				}
				
				map[i][j] -= amount[i][j]*cnt; // 해당 위치는 확산된 미세먼지 양 빼기
			}
		}
	}
	
	// 2. 공기청정기 작동
	static void cleanAir() {
		// (1) 공기청정기 위쪽
		// 아래로 회전
		for(int i=cleaner.r-1;i>1;i--) {
			map[i][1] = map[i-1][1];
		}
		// 왼쪽으로 회전
		for(int i=1;i<c;i++) {
			map[1][i] = map[1][i+1];
		}
		// 위로 회전
		for(int i=1;i<cleaner.r;i++) {
			map[i][c] = map[i+1][c];
		}
		// 오른쪽으로 회전
		for(int i=c;i>2;i--) {
			map[cleaner.r][i] = map[cleaner.r][i-1];
		}
		map[cleaner.r][2] = 0;
		
		// (2) 공기청정기 아래쪽
		// 위로 회전
		for(int i=cleaner.r+2;i<r;i++) {
			map[i][1] = map[i+1][1];
		}
		// 왼쪽으로 회전
		for(int i=1;i<c;i++) {
			map[r][i] = map[r][i+1];
		}
		// 아래로 회전
		for(int i=r;i>cleaner.r+1;i--) {
			map[i][c] = map[i-1][c];
		}
		// 오른쪽으로 회전
		for(int i=c;i>2;i--) {
			map[cleaner.r+1][i] = map[cleaner.r+1][i-1];
		}
		map[cleaner.r+1][2] = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()); // 집의 세로 크기
		c = Integer.parseInt(st.nextToken()); // 집의 가로 크기
		int t = Integer.parseInt(st.nextToken()); // 지난 시간 (t초)
		map = new int[r+1][c+1];
		cleaner = new Point(0, 0);
		
		// 입력 받은 미세먼지 양 저장
		for(int i=1;i<=r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기 위치 저장 (2칸 중 윗칸 위치만 저장)
				if(map[i][j] == -1 && cleaner.r == 0) {
					cleaner.r = i;
					cleaner.c = j;
				}
			}
		}
		
		for(int i=0;i<t;i++) {
			spreadDust();
			cleanAir();
		}
		
		// 남아있는 미세먼지의 양 구하기
		int ans = 0;
		for(int i=1;i<=r;i++) {
			for(int j=1;j<=c;j++) {
				if(map[i][j] == -1) continue;
				
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
	}
}
