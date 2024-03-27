import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();	// 지우고 남은 수 (최대 3,000자리)
		int ans = 0;	// N의 최솟값
		
		int idx = 0;	// 몇 번째 숫자인지
		Loop:
		while(true) {
			ans++;
			
			String ansStr = Integer.toString(ans);
			// ans가 2자리 수 이상인 경우, 모든 자리 체크하기 위해 반복문 사용
			for(int i=0;i<ansStr.length();i++) {
				// 숫자가 일치하는 경우 다음 숫자 체크하기 위해 idx 1 증가
				if(input.charAt(idx) == ansStr.charAt(i)) {
					idx++;
				}
				
				// idx와 input의 길이가 같다면, N의 최솟값 출력 후 반복문 빠져나가기
				if(idx == input.length()) {
					System.out.println(ans);
					break Loop;
				}
			}
		}
	}
}
