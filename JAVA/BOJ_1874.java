import java.io.*;
import java.util.*;

public class BOJ_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());	// 1 <= n <= 100,000
		int[] num = new int[n+1];	// 수열 저장할 배열
		Stack<Integer> stack = new Stack<>();	// 스택
		
		// 배열에 수열 저장
		for(int i=1;i<=n;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 1;	// 수열의 몇번째 수까지 완성되었는지 저장
		for(int i=1;i<=n;i++) {
			stack.push(i);
			sb.append("+\n");	// push 연산 : "+" 출력
				
			// 스택의 탑에 있는 수와 수열의 cnt번째 수가 같다면
			while(!stack.isEmpty() && stack.peek() == num[cnt]) {
				stack.pop();		// 스택에서 숫자 꺼내기
				sb.append("-\n");	// pop 연산 : "-" 출력
				cnt++;				// cnt를 1만큼 증가
			}
		}
		
		// 스택이 비어있지 않다면 (수열을 만들 수 없다면)
		if(!stack.isEmpty()) {
			sb.setLength(0);	// stringbuilder 초기화
			sb.append("NO");	// "NO" 출력
		}

		System.out.println(sb.toString());
	}
}
