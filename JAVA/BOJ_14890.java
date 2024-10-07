import java.io.*;
import java.util.*;

public class BOJ_14890 {
	static int n, l, ans=0;
	static int[][] map;
	
	static void canGo(int row, int col, boolean isRow) {
		boolean[] slope = new boolean[n]; // 경사로 설치 여부
		int[] height = new int[n]; 		  // 해당 줄에 있는 칸의 높이
		
		for(int i=0;i<n;i++) {
            if(isRow) height[i] = map[row][i];
            else height[i] = map[i][col];
        }
		
		for(int i=1;i<n;i++) {
			int diff = height[i]-height[i-1]; // 현재 칸과 이전 칸 높이 차이
			
			if(Math.abs(diff) > 1) return; // 높이가 2 이상 차이나면 지나갈 수 X
			
			// 1. 이전 칸보다 1칸 낮은 경우
			if(diff == -1) {
				for(int j=0;j<l;j++) {
					// 경사로 길이 l 동안 높이가 불연속적이거나 이미 경사로가 설치된 경우 X
					if(i+j>=n || height[i]!=height[i+j] || slope[i+j]) return;
					slope[i+j] = true;
				}
			}
			// 2. 이전 칸보다 1칸 높은 경우
			else if(diff == 1) {
				for(int j=1;j<=l;j++) {
					// 경사로 길이 l 동안 높이가 불연속적이거나 이미 경사로가 설치된 경우 x
					if(i-j<0 || height[i-1]!=height[i-j] || slope[i-j]) return;
					slope[i-j] = true;
				}
			}
		}
		
		ans++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지도 크기
		l = Integer.parseInt(st.nextToken()); // 경사로 길이
		map = new int[n][n]; // 지도
		
		// 입력받은 지도 저장
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			canGo(i, 0, true);
			canGo(0, i, false);
		}
		
		System.out.println(ans);
	}
}
