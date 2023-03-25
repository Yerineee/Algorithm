import java.io.*;
import java.util.*;

public class BOJ_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();			// 입력 받은 문자열
		String explosionStr = br.readLine();	// 폭발 문자열
		Stack<Character> stack = new Stack<>();

		int explosionSize = explosionStr.length();	// 폭발 문자열 크기
		boolean same;	// 문자열과 폭발 문자열이 같은지 체크
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));	// 스택에 문자 저장
			
			// 스택 크기가 폭발 문자열 길이보다 크거나 같으면
			if(stack.size() >= explosionSize) {
				same = true;
				
				// 폭발 문자열과 똑같지 않은 경우
				for(int j=0;j<explosionSize;j++) {
					if(stack.get(stack.size()-(explosionSize-j)) != explosionStr.charAt(j)) {
						same = false;
						break;
					}
				}
				
				// 폭발 문자열과 같은 경우 해당 문자열 스택에서 꺼내기
				if(same) {
					for(int j=0;j<explosionSize;j++) {
						stack.pop();
					}
				}
			}
		}
		
		// 스택에 저장된 문자열을 stringbuilder에 추가
		for(int i=0;i<stack.size();i++) {
			sb.append(stack.get(i));
		}
		
		// 남아있는 문자열이 있으면 문자열 출력
		if(sb.length()>0) {
			System.out.println(sb.toString());
		}
		// 남아있는 문자열이 없으면 "FRULA" 출력
		else {
			System.out.println("FRULA");
		}
	}
}
