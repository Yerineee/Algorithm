import java.io.*;

public class BOJ_1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());	// 자연수의 합 S (입력)
		int N = 1;	// 서로 다른 자연수의 개수 (출력)
		
		// Math.pow(N,2)+N-2*S=0을 만족하는 실수 N을 구한 뒤 소수점 버림
		N = (int) Math.floor((-1 + Math.sqrt(1+8*S)) / 2);
		
		System.out.println(N);	// N 출력
	}
}
