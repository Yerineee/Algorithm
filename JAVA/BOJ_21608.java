import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_21608 {
	static int n;
	static int[][] map; // 학생들 위치
	static HashMap<Integer, ArrayList<Integer>> students = new HashMap<>(); // 학생 정보
	// 인접한 칸의 방향 (상하좌우)
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	// 자리 정하기 위해 탐색
	static int[] search(int studentNum, int row, int col) {
		int[] seat = new int[4];
		
		for(int i=0;i<4;i++) {
			int nr = row+dr[i];
			int nc = col+dc[i];
			
			if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
			
			// 인접한 칸이 비어있는 칸인 경우
			if(map[nr][nc] == 0) seat[1]++;
			// 인접한 칸에 좋아하는 학생이 있는 경우
			else if(students.get(studentNum).contains(map[nr][nc])) seat[0]++;
		}
		seat[2] = row; // 행 번호
		seat[3] = col; // 열 번호
		
		return seat;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 교실 크기
		map = new int[n][n];
		int[] seq = new int[n*n];
		
		// 입력 받은 학생 정보 저장
		for(int i=0;i<n*n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int studentNum = Integer.parseInt(st.nextToken()); // 학생 번호
			ArrayList<Integer> studentInfo = new ArrayList<>();
			
			// 좋아하는 학생 번호
			for(int j=0;j<4;j++) {
				studentInfo.add(Integer.parseInt(st.nextToken()));
			}
			
			seq[i] = studentNum;
			students.put(studentNum, studentInfo);
		}
		
		for(int studentNum : seq) {
			ArrayList<int[]> seats = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					// 비어있는 칸이면, {인접한 칸 중 좋아하는 학생 수, 인접한 칸 중 비어있는 칸 수, 행 번호, 열 번호} 구하기
					if(map[i][j] == 0) {
						seats.add(search(studentNum, i, j));
					}
				}
			}
			
			Collections.sort(seats, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					// 인접한 칸에 있는 좋아하는 학생 수가 같은 경우
					if(o1[0] == o2[0]) {
						// 비어있는 칸의 수가 같은 경우
						if(o1[1] == o2[1]) {
							// 행 번호가 같은 경우, 열 번호 비교
							if(o1[2] == o2[2]) return o1[3]-o2[3];
							
							return o1[2]-o2[2];
						}
						
						return o2[1]-o1[1];
					}
					
					return o2[0]-o1[0];
				}
			});
			
			// 규칙에 따라 자리 정하기
			int row = seats.get(0)[2];
			int col = seats.get(0)[3];
			map[row][col] = studentNum;
		}
		
		// 만족도 구하기
		int satisfaction = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int cnt = 0; // 인접한 칸 중 좋아하는 학생 수
				
				for(int k=0;k<4;k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
					
					if(students.get(map[i][j]).contains(map[nr][nc])) cnt++;
				}
				
				if(cnt == 0) continue;
				satisfaction += Math.pow(10, cnt-1);
			}
		}
		
		System.out.println(satisfaction);
	}
}
