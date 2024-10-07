import java.util.*;
import java.io.*;

public class BOJ_2178 {
	static int n, m, ans = 0;
	static int[][] map;
	static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	static private class Point {
		int row, col, count;
		
		Point(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
	
	static void bfs() {
		boolean[][] visit = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1));
		visit[0][0] = true;
		
		while(true) {
			Point cur = q.poll();
			
			// (n,m)위치에 도달하면 탐색 종료
			if(cur.row==n-1 && cur.col==m-1) {
				ans = cur.count;
				return;
			}
			
			for(int i=0;i<4;i++) {
				Point next = new Point(cur.row+dir[i][0], cur.col+dir[i][1], cur.count+1);
				
				// 범위를 벗어났으면 넘어가기
				if(next.row<0 || next.row>=n || next.col<0 || next.col>=m) continue;
				
				// 방문하지 않았고, 이동 가능한 칸이면 큐에 위치 추가
				if(!visit[next.row][next.col] && map[next.row][next.col]==1) {
					q.add(next);
					visit[next.row][next.col] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 미로 세로 크기
		m = Integer.parseInt(st.nextToken()); // 미로 가로 크기
		map = new int[n][m]; // 미로 배열
		
		// 미로 저장하기
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// BFS 이용
		bfs();
		
		System.out.println(ans);
	}
}
