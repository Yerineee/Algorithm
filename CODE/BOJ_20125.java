import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20125 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cookie = new int[n+1][n+1];
		
		int heartX=0, heartY=0;	// 심장 위치 (행, 열)
		
		for(int i=1;i<=n;i++) {
			String input = br.readLine();
			for(int j=1;j<=n;j++) {
				// 쿠키의 신체 부분을 배열에 1로 저장
				if(input.charAt(j-1)=='*') {
					cookie[i][j] = 1;
					
					// 심장 위치 저장 (처음 만나는 * 표시는 머리 위치이므로 이를 이용해 심장 위치를 구함)
					if(heartX==0) {
						heartX=i+1; // (심장 위치의 행 번호) = (머리 위치의 행 번호) + 1
						heartY=j;	// 머리 위치의 열 번호와 동일
					}
				}
			}
		}
		
		// 왼쪽 팔 길이, 오른쪽 팔 길이, 허리 길이, 왼쪽 다리 길이, 오른쪽 다리 길이
		int leftArm=0, rightArm=0, waist=0, leftLeg=0, rightLeg=0;
		// 왼쪽 팔과 오른쪽 팔 길이 구하기
		for(int i=1;i<=n;i++) {
			// 왼쪽 팔 길이 구하기
			if(cookie[heartX][i]==1 && i<heartY) {
				leftArm++;
			}
			// 오른쪽 팔 길이 구하기
			if(cookie[heartX][i]==1 && i>heartY) {
				rightArm++;
			}
		}
		
		// 허리의 길이 구하기
		for(int i=heartX+1;i<=n;i++) {
			if(cookie[i][heartY]==1) {
				waist++;
			} else {
				break;
			}
		}
		
		// 다리 길이 구하기
		for(int i=heartX+waist+1;i<=n;i++) {
			// 왼쪽 다리 길이 구하기
			if(cookie[i][heartY-1]==1) {
				leftLeg++;
			}
			// 오른쪽 다리 길이 구하기
			if(cookie[i][heartY+1]==1) {
				rightLeg++;
			}
		}
		
		// 심장 위치 출력
		System.out.printf("%d %d\n", heartX, heartY);
		
		// 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리 길이 출력
		System.out.printf("%d %d %d %d %d\n", leftArm, rightArm, waist, leftLeg, rightLeg);
	}
}
