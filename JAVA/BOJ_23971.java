import java.util.Scanner;

public class BOJ_23971 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();	// 테이블 행의 개수
		int w = sc.nextInt();	// 테이블 열의 개수
		int n = sc.nextInt();	// 세로로 비워야 하는 칸 수
		int m = sc.nextInt();	// 가로로 비워야 하는 칸 수
		
		// 세로로 앉을 수 있는 인원 = ((테이블 행의 개수) / (세로로 비워야 하는 칸 수+1)의 값을 반올림한 값)
		// 가로로 앉을 수 있는 인원 = ((테이블 열의 개수) / (가로로 비워야 하는 칸 수+1)의 값을 반올림한 값)
		System.out.println((int)Math.ceil((double)h/(n+1))*(int)Math.ceil((double)w/(m+1)));
	}
}
