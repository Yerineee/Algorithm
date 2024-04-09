import java.util.Scanner;

public class BOJ_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 1 ≤ N ≤ 1,000,000,000인 수 N
		
		// 층별로 방이 6개씩 증가하므로, (해당 층의 끝번호) = (이전 층의 끝번호) + 6*(현재 층 수-1)이다.
		// 예를 들어 (두 번째 층의 끝번호) = (첫 번째 층의 끝번호) + 6*1 = 1+6 = 7이다. 
		int room = 1, cnt = 1;	// room: 계산한 방 번호, cnt: 몇 번째 층인지 저장
		
		while(room<N) {
			room += 6*cnt;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
