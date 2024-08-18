import java.util.*;
import java.io.*;

public class BOJ_3190 {
	static int N, time=0;
	static int[][] map;	// 보드 (사과가 있으면 1로 표시)
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static ArrayList<String[]> info = new ArrayList<>();	// 방향 변환 정보
	static ArrayList<String> snake = new ArrayList<>();		// 뱀의 몸 위치
	
	static void move(int dir) {
		time++;
		
		// 방향대로 1칸 이동
		String[] head = snake.get(0).split(" ");
		int nextR = Integer.parseInt(head[0])+dr[dir];
		int nextC = Integer.parseInt(head[1])+dc[dir];
		
		// 벽이나 몸이면 시간 return
		if(nextR<=0 || nextR>N || nextC<=0 || nextC>N || snake.contains(nextR+" "+nextC)) {
			return;
		}
		
		snake.add(0, nextR+" "+nextC);
		
		// 사과가 없는 칸이면 꼬리 이동
		if(map[nextR][nextC] == 0) {
			snake.remove(snake.size()-1);
		} else {
			// 사과가 있는 칸이면, 그 칸에 있던 사과는 없어짐
			map[nextR][nextC] = 0;
		}
		
		// 방향 정보가 있다면 방향 변환
		if(info.size()>0 && Integer.parseInt(info.get(0)[0]) == time) {
			if(info.get(0)[1].equals("D")) {
				dir = dir==3 ? 0: dir+1;
			} else {
				dir = dir==0 ? 3: dir-1;
			}
			
			info.remove(0);
		}
		
		move(dir);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 보드의 크기
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		// 사과 개수
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			String[] input = br.readLine().split(" ");
			map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
		}
		
		// 방향 변환 정보
		int L = Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			String[] input = br.readLine().split(" ");
			info.add(new String[] {input[0], input[1]});
		}
		
		// 뱀 시작 위치 저장
		snake.add("1 1");
		move(0);
		
		System.out.println(time);
	}
}
