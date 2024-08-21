import java.util.*;
import java.io.*;

public class BOJ_14499 {
	static int n, m;
	static int x, y;
	static int[][] map;
	static int[] dice;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int moveDice(int dir) {
		// 이동한 뒤의 좌표
		int nx = x + dx[dir-1];
		int ny = y + dy[dir-1];
		
		// 지도 범위를 벗어나면 -1 반환
		if(nx<0 || nx>=n || ny<0 || ny>=m) return -1;
		
		// x, y 업데이트
		x = nx;
		y = ny;
		
		switch(dir) {
		// 동쪽으로 움직인 경우
		case 1:
			dice = new int[]{dice[0], dice[5], dice[1], dice[2], dice[4], dice[3]};
			break;
		// 서쪽으로 움직인 경우
		case 2:
			dice = new int[]{dice[0], dice[2], dice[3], dice[5], dice[4], dice[1]};
			break;
		// 북쪽으로 움직인 경우
		case 3:
			dice = new int[]{dice[2], dice[1], dice[4], dice[3], dice[5], dice[0]};
			break;
		// 남쪽으로 움직인 경우
		default:
			dice = new int[]{dice[5], dice[1], dice[0], dice[3], dice[2], dice[4]};
		}
		
		// 이동한 칸에 쓰여 있는 수가 0이면, 주사위 바닥면의 수를 칸에 복사
		if(map[x][y] == 0) {
			map[x][y] = dice[5];
		}
		// 그렇지 않으면, 칸에 쓰여 있는 수를 주사위 바닥면에 복사하고, 칸에 쓰여 있는 수를 0으로 설정
		else {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
		
		// 주사위 윗 면에 쓰여 있는 수 반환
		return dice[2];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 지도의 세로 크기 n, 가로 크기 m
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		// 주사위 놓은 좌표 x, y
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		// 명령의 개수 k
		int k = Integer.parseInt(st.nextToken());
		
		// 지도에 적힌 수 map에 저장
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[6];
		// 명령
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			int num = moveDice(Integer.parseInt(st.nextToken()));
			// 지도 범위를 벗어난 경우는 무시
			if(num == -1) continue;
			
			System.out.println(num);
		}
	}
}
