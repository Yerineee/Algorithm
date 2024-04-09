import java.util.Scanner;

public class BOJ_9655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 돌의 개수 N
		
		// 아래와 같이 경우의 수를 따져보면 돌이 짝수개라면 창영이가 이기고, 홀수개이면 상근이가 이긴다.
		// N=1일 때 상근이가 이김. N=2일 때 창영이가 이김, N=3일 때 상근이가 이김, N=4일 때 창영이가 이김. ...
		if(N%2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
