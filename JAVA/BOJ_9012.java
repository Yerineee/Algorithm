import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 데이터 개수
		
		// 테스트 데이터 개수만큼 반복하며 올바른 괄호 문자열인지 출력하기
		while(T-->0) {
			String ps = br.readLine();	// 입력받은 괄호 문자열
			
			Stack<Character> stack = new Stack<>();	// 괄호 저장할 스택
			boolean isVPS = true;	// 해당 문자열이 VPS인지 표시할 변수
			
			// 스택을 이용하여 구현
			// 1. 만약 입력받은 괄호 문자열(PS 변수)의 i번째 문자가 '('이면 스택에 저장
			// 2. i번째 문자가 ')'이면 스택에서 괄호 꺼내기 (만약 저장된 괄호가 없다면, 그건 올바른 괄호 문자열이 아니기 때문에 isVPS를 false로 갱신
			for(int i=0;i<ps.length();i++) {
				if(ps.charAt(i)=='(') {
					stack.add(ps.charAt(i));
				} else {
					if(stack.isEmpty()) {
						isVPS = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			// isVPS가 true이고 스택이 비어있다면 올바른 괄호 문자열이므로 "YES"를 출력하고, 그렇지 않다면 올바른 괄호 문자열이 아니므로 "NO" 출력
			if(isVPS && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
