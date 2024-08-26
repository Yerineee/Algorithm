import java.util.*;
import java.io.*;

public class BOJ_14502 {
	static int n, m, ans=0;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0}; // 가로로 이동
	static int[] dy = {0, 0, 1, -1}; // 세로로 이동
	
	// 벽 3개 세우기
	static void makeWall(int cnt) {
		if(cnt == 3) {
			spreadVirus();
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1; // 벽 세우기
					makeWall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	// 바이러스 퍼진 뒤의 안전 영역 구하기
	static void spreadVirus() {
		int safe = n*m; // 바이러스가 퍼진 칸의 수
		Queue<int[]> q = new LinkedList<>(); // 바이러스 위치 저장할 큐
		
		// 지도 (원본 값 유지를 위한 임시 배열)
		int[][] temp = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[i][j] = map[i][j];
				if(temp[i][j] == 1) safe--;
				else if(temp[i][j] == 2) q.offer(new int[] {i, j});
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			safe--;
			
			for(int i=0;i<4;i++) {
				// 이동한 후의 위치
				int nx = cur[1]+dx[i];
				int ny = cur[0]+dy[i];
				
				// 이동한 후의 위치가 지도를 벗어나면 넘어가기
				if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
				
				// 이동한 위치가 빈칸이면, 큐에 추가
				if(temp[ny][nx] == 0) {
					q.offer(new int[] {ny, nx});
					temp[ny][nx] = 2;
				}
			}
		}
		
		ans = Math.max(ans, safe); // 안전 영역 최대 크기 갱신
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로 크기
		m = Integer.parseInt(st.nextToken()); // 가로 크기
		
		map = new int[n][m]; // 지도 (0은 빈칸, 1은 벽, 2는 바이러스)
		
		// 입력 받은 지도 저장
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0);
		
		System.out.println(ans);
	}
}
