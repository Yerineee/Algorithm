import java.util.*;
import java.io.*;

public class BOJ_7576 {
	static int m, n, ans=0; // 상자 크기
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] box;
	static Queue<Tomato> q = new LinkedList<>();
	
	private static class Tomato {
		int r, c, day;
		
		Tomato(int r, int c, int day) {
			this.r = r; // 행
			this.c = c; // 열
			this.day = day; // 익을 때까지 걸린 날짜
		}
	}
	
	static void bfs() {
		int days = 0; // 토마토가 익는 데 걸리는 날짜
		
		while(!q.isEmpty()) {
			Tomato cur = q.poll();
			days = Math.max(days, cur.day);
			
			for(int i=0;i<4;i++) {
				Tomato next = new Tomato(cur.r+dr[i], cur.c+dc[i], cur.day+1);
				
				// 범위를 벗어났거나 익은 토마토/토마토가 없는 칸이면 넘어가기
				if(next.r<0 || next.r>=n || next.c<0 || next.c>=m || box[next.r][next.c] != 0) continue;
				
				q.add(next);
				box[next.r][next.c] = 1;
			}
		}
		
		// 익지 않은 토마토가 있으면 -1 반환
		Loop:
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(box[i][j] == 0)  {
					ans = -1;
					break Loop;
				}
			}
		}
		
		// 토마토가 모두 익었으면, 토마토가 익는 데 걸리는 날짜 반환
		if(ans != -1) ans = days;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken()); // 상자 가로 크기
		n = Integer.parseInt(st.nextToken()); // 상자 세로 크기
		box = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j] == 1) {
					q.add(new Tomato(i, j, 0));
				}
			}
		}
		
		bfs();

		System.out.println(ans);
	}
}
