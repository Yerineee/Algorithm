import java.util.*;
import java.io.*;

public class BOJ_16234 {
	static int n, l, r;
	static boolean canMove;
	static int[][] a; // 인구 수
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visit;
	static ArrayList<Point> union = new ArrayList<>();
	
	private static class Point {
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	// bfs (연합을 이루는지 탐색)
	static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		union.add(start);
		visit[start.r][start.c] = true;
		int sum = a[start.r][start.c]; // 연합 인구 수
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int k=0;k<4;k++) {
				Point next = new Point(cur.r+dr[k], cur.c+dc[k]);
				
				if(next.r<0 || next.r>=n || next.c<0 || next.c>=n || visit[next.r][next.c]) continue; // 범위 벗어나면 넘어가기
				
				int gap = Math.abs(a[cur.r][cur.c] - a[next.r][next.c]);
				
				// 인구수의 차이가 l이상 r이하일 때 국경선 열기
				if(gap>=l && gap<=r) {
					q.add(next);
					union.add(next);
					canMove = true;
					visit[next.r][next.c] = true;
					sum += a[next.r][next.c];
				}
			}
		}
		
		int avg = sum / union.size(); // 연합을 이루는 각 칸의 인구수
		// 인구수 갱신
		for(int i=0;i<union.size();i++) {
			Point cur = union.get(i);
			a[cur.r][cur.c]= avg; 
		}
		
		union.clear();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받은 n, l, r 저장
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		a = new int[n][n];
		
		// 입력받은 인구 수 저장
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int days = 0; // 인구 이동 발생 일수
		while(true) {
			canMove = false; // 인구 이동 가능 여부
			visit = new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visit[i][j]) {
						bfs(new Point(i, j));
					}
				}
			}
			
			if(!canMove) break; // 더 이상 이동할 수 없다면 끝내기
			
			days++;
		}
		
		System.out.println(days);
	}
}
