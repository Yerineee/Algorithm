// https://dogrin.tistory.com/63

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12970 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		// (i, j) 쌍의 최대 개수(N*N/4)가 K보다 작은 경우, 가능한 S가 없으므로 -1 출력
		if(N*N/4 < K) {
			System.out.println(N*N/4);
			System.out.println(-1);
		}
		// 가능한 S가 있는 경우
		else {
			String ans = "";	// 가능한 S 저장할 변수 (출력값)
			
			// A의 개수를 i개, B의 개수를 (N-i)개라고 설정
			// (A의 개수)*(B의 개수)>=K를 만족하는 (A의 개수)*(B의 개수)가 최솟값일 때의 A, B 개수로 S를 만들 수 있음
			// 경우의 수 1. (A의 개수)*(B의 개수)==K를 만족하는 A, B 개수가 있다면, "AAABBB"와 같이 "A"가 i번 반복되고, "B"가 (N-i)번 반복되는 형태임
			// 경우의 수 2. (A의 개수)*(B의 개수)==K를 만족하는 A, B 개수가 없고 (A의 개수)*(B의 개수)>K인 경우, "AAABBABB"와 같이 "AAAABBBB"에서 가장 오른쪽 "A"가 오른쪽으로 (i*(N-i)-K)번 움직인 형태임
			// (예외) 경우의 수 2에서 "BA"나 "ABA"와 같은 경우를 고려하여 Math.max()를 통해 예외 처리
			for(int i=1;i<=N/2;i++) {
				if(i*(N-i) < K) {
					continue;
				} else if(i*(N-i)== K) {
					ans = "A".repeat(i) + "B".repeat(N-i);
					break;
				} else {
					// "A"는 i개, "B"는 (N-i)개
					ans = "A".repeat(Math.max(0, i-1)) + "B".repeat(i*(N-i)-K) + "A" + "B".repeat(Math.max(0,N-i+K-i*(N-i)));
					break;
				}
			}
			
			System.out.println(ans);
		}
	}
}
