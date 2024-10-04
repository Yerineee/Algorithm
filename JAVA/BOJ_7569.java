import java.util.*;
import java.io.*;

public class BOJ_7569 {
	static int m, n, h, ans=0; // 상자 크기
	static int[][] move = {{0,0,1}, {0,-1,0}, {1,0,0}, {0,0,-1}, {0,1,0}, {-1,0,0}};
	static int[][][] box;
	static Queue<Tomato> q = new LinkedList<>();
	
	private static class Tomato {
		int r, c, h, day;
		
		Tomato(int r, int c, int h, int day) {
			this.r = r; // 행
			this.c = c; // 열
			this.h = h; // 높이
			this.day = day; // 익을 때까지 걸린 날짜
		}
	}
	
	static void bfs() {
		int days = 0; // 토마토가 익는 데 걸리는 날짜
		
		while(!q.isEmpty()) {
			Tomato cur = q.poll();
			days = Math.max(days, cur.day);
			
			for(int i=0;i<6;i++) {
				Tomato next = new Tomato(cur.r+move[i][0], cur.c+move[i][1], cur.h+move[i][2], cur.day+1);
				
				// 범위를 벗어났거나 익은 토마토/토마토가 없는 칸이면 넘어가기
				if(next.r<0 || next.r>=n || next.c<0 || next.c>=m || next.h<0 || next.h>=h ||
						box[next.r][next.c][next.h] != 0) continue;
				
				q.add(next);
				box[next.r][next.c][next.h] = 1;
			}
		}
		
		// 익지 않은 토마토가 있으면 -1 반환
		Loop:
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<h;k++) {
					if(box[i][j][k] == 0)  {
						ans = -1;
						break Loop;
					}
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
		h = Integer.parseInt(st.nextToken()); // 상자 높이
		box = new int[n][m][h];
		
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {
					box[j][k][i] = Integer.parseInt(st.nextToken());
					
					if(box[j][k][i] == 1) {
						q.add(new Tomato(j, k, i, 0));
					}
				}
			}
		}
		
		bfs();

		System.out.println(ans);
	}
}
