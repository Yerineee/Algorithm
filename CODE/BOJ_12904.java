import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();	// 문자열 S
		String T = br.readLine();	// 문자열 T
		
		// T를 뒤에서부터(마지막 인덱스부터) 판별
		// 'A'를 만나면 마지막 인덱스의 문자 자르고, 다음 문자로 넘어가기
		// 'B'를 만나면 마지막 인덱스의 문자 자르고, 문자열 뒤집기
		StringBuilder sb = new StringBuilder(T);
		while(sb.length() > S.length()) {
			int flag = sb.charAt(sb.length()-1)=='B' ? 1 : 0;	// 마지막 인덱스의 문자가 B인지 체크 (B이면 1, A이면 0)
			sb.deleteCharAt(sb.length()-1);	// 마지막 인덱스의 문자 자르기
			
			// 마지막 인덱스의 문자가 B였다면 문자열 뒤집기
			if(flag == 1) {
				sb.reverse();
			}
		}
		
		// 연산을 통해 문자열 T를 바꿨을 때 S와 일치하면 1을, 일치하지 않는다면 0을 출력
		int answer = sb.toString().equals(S) ? 1 : 0;
		System.out.println(answer);
	}
}
