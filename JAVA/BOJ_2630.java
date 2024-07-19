import java.io.*;
import java.util.*;

public class BOJ_2630 {
	static int n;
	static int[][] color;
	static int blue = 0, white = 0;
	
	// 해당 범위 내의 색종이 색이 모두 같은지 탐색 (같으면 true, 다르면 false 반환)
	static boolean isEqual(int row, int col, int len) {
		for(int i=row;i<row+len;i++) {
			for(int j=col;j<col+len;j++) {
				if(color[row][col] != color[i][j])  return false;
			}
		}
		
		return true;
	}
	
	static void search(int row, int col, int len) {
		// 1. 해당 범위 내의 색종이 색이 모두 같거나, len이 1인 경우
		if(len==1 || isEqual(row, col, len)) {
			if(color[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		// 2. 해당 범위 내의 색종이 색이 다른 경우
		search(row, col, len/2);
		search(row, col+len/2, len/2);
		search(row+len/2, col, len/2);
		search(row+len/2, col+len/2, len/2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 전체 종이의 한 변의 길이 n
		
		// 색종이의 색을 color 배열에 저장 (0은 하얀색, 1은 파란색)
		color = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				color[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		search(0, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
	}
}
