import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
	// 모음인지 확인하는 함수 (모음이면 true 반환)
	public static boolean isVowel(char c) {
		if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) {
				break;
			}
			
			boolean isAccep=true;	// 높은 품질이면 true 저장
			int vCnt=0;	// 모음 개수
			
			/* 
			 * 조건
			 * 1. 모음을 적어도 하나 포함해야 함
			 * 2. 모음이 연속으로 3개, 자음이 연속으로 3개 오면 아뇜
			 * 3. 같은 글자가 연속으로 나오면 안되지만, ee나 oo는 가능 
			*/
			for(int i=0;i<str.length();i++) {
				// 모음이면 vCnt 변수 1 증가
				if(isVowel(str.charAt(i))) {
					vCnt++;
				}
				
				// 2번 조건 : 모음이나 자음이 연속으로 3개 오면 높은 품질이 아님
				if(i>=2) {
					if(isVowel(str.charAt(i-2))==isVowel(str.charAt(i-1)) && isVowel(str.charAt(i-1))==isVowel(str.charAt(i))) {
						isAccep = false;
					}
				}
				
				// 3번 조건 : 같은 글자가 연속으로 오면 높은 품질이 아님 (ee와 oo 제외)
				if(i>=1) {
					if(str.charAt(i-1)==str.charAt(i) && str.charAt(i)!='e' && str.charAt(i)!='o') {
						isAccep = false;
					}
				}
			}
			
			// 모음이 하나도 포함되어 있지 않으면 안됨
			if(vCnt==0) {
				isAccep = false;
			}
			
			// 높은 품질인 경우
			if(isAccep) {
				System.out.printf("<%s> is acceptable.\n", str);
			}
			// 낮은 품질인 경우
			else {
				System.out.printf("<%s> is not acceptable.\n", str);
			}
		}

	}

}
