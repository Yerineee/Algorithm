import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();	// 문자열 S (입력)
		
		int min = 0;			// 다솜이가 해야하는 행동의 최소 횟수
		char prev=S.charAt(0);	// 이전에 나왔던 문자
		if(S.length() > 1) {
			for(int i=1;i<S.length();i++) {
				// 이전에 나왔던 문자와 동일한 경우
				if(S.charAt(i) == prev) {
					continue;
				}
				
				// 이전에 나왔던 문자와 동일하지 않은 경우
				min++;				// 다솜이가 해야하는 행동의 최소 횟수 + 1
				prev=S.charAt(i);	// 이전에 나왔던 문자를 현재 문자로 갱신
			}
		}

		System.out.println(min%2==0 ? min/2 : (min+1)/2);	// min이 짝수일 경우와 홀수일 경우로 나누어 출력 (대칭 이용)
	}
}
