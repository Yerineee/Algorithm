import java.io.*;
import java.util.*;

public class BOJ_14500 {
	static int n, m, ans = Integer.MIN_VALUE;
	static boolean[][] visit;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	private static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void search(Point cur, int depth, int sum) {
		if(depth == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			Point next = new Point(cur.x+dx[i], cur.y+dy[i]); // 다음에 방문할 칸
			
			// 종이 범위 벗어나면 넘어가기
			if(next.x<0 || next.x>=m || next.y<0 || next.y>=n) continue;
			
			
			// 방문하지 않은 칸이라면 방문하기
			if(!visit[next.y][next.x]) {
				// ㅗ모양 테트로미노는 기존 위치로 한번 돌아가야 함
				if(depth == 2) {
					visit[next.y][next.x] = true; // 방문 체크
					search(cur, depth+1, sum+map[next.y][next.x]);
					visit[next.y][next.x] = false;
				}
				
				visit[next.y][next.x] = true; // 방문 체크
				search(next, depth+1, sum+map[next.y][next.x]);
				visit[next.y][next.x] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 세로 크기
		m = Integer.parseInt(st.nextToken()); // 가로 크기
		visit = new boolean[n][m]; // 방문 여부 체크
		map = new int[n][m];	   // 칸에 쓰여 있는 수
		
		// 칸에 쓰여 있는 수 저장
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				search(new Point(j, i), 0, 0);
			}
		}
		
		System.out.println(ans);
	}
}
