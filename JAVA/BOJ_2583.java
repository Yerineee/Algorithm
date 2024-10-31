import java.util.*;
import java.io.*;

public class BOJ_2583 {
	static int m, n, k;
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 이동방향
	static int[][] map;		  // 모눈종이
	static boolean[][] visit; // 눈금 방문 체크
	static ArrayList<Integer> areas = new ArrayList<>(); // 분리된 영역들의 넓이
	
	// 좌표 클래스
	private static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 1. 직사각형 그리기
	static void drawRect(Point left, Point right) {
		// 직사각형 그려진 부분은 1로 표시
		for(int y=left.y;y<=right.y;y++) {
			for(int x=left.x;x<=right.x;x++) {
				map[y][x] = 1;
			}
		}
	}
	
	// 2. 분리된 영역 탐색
	static void search(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visit[start.y][start.x]= true;
		
		int area = 1; // 분리된 영역 넒이 (시작 좌표 포함이므로 1로 초기화)
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i=0;i<4;i++) {
				Point next = new Point(cur.x+dir[i][0], cur.y+dir[i][1]);
				
				// 1) 범위 벗어나면 넘어가기
				if(next.x<0 || next.x>=n || next.y<0 || next.y>=m) continue;
				// 2) 방문했거나 직사각형이 그려진 영역이면 넘어가기
				if(map[next.y][next.x]==1 || visit[next.y][next.x])continue; 
				
				q.add(next);
				visit[next.y][next.x] = true;
				area++;
			}
		}
		
		areas.add(area);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken()); // 모눈종이 세로 길이
		n = Integer.parseInt(st.nextToken()); // 모눈종이 가로 길이
		k = Integer.parseInt(st.nextToken()); // 직사각형 개수
		map = new int[m][n]; 		// 모눈종이
		visit = new boolean[m][n];  // 눈금 방문 체크
		
		// 1. 직사각형 그리기
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			
			// 왼쪽 아래 꼭짓점 좌표
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			Point left = new Point(leftX, leftY);
			// 오른쪽 위 꼭짓점 좌표
			int rightX = Integer.parseInt(st.nextToken())-1;
			int rightY = Integer.parseInt(st.nextToken())-1;
			Point right = new Point(rightX, rightY);
			
			drawRect(left, right);
		}
		
		// 2. 분리된 영역 탐색 (직사각형이 그려지지 않고, 방문하지 않은 좌표)
		for(int y=0;y<m;y++) {
			for(int x=0;x<n;x++) {
				if(map[y][x]==0 && !visit[y][x]) {
					search(new Point(x, y));
				}
			}
		}
		
		// 3. 넓이 오름차순으로 정렬 후, 분리된 영역의 개수와 넓이 출력
		Collections.sort(areas);
		System.out.println(areas.size());
		for(int area : areas) {
			System.out.print(area+" ");
		}
	}
}
