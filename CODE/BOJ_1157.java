import java.util.Scanner;

public class BOJ_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();	// 입력 받은 단어 word
		word = word.toUpperCase();	// 대소문자를 구분하지 않으므로 word를 대문자로 변환
		
		int[] alpha = new int[26];	// 알파벳 개수를 저장할 배열 alpha
		// 반복문을 통해 알파벳 개수를 저장
		for(int i=0;i<word.length();i++) {
			alpha[word.charAt(i)-'A']++;
		}
		
		int max = 0;	// 알파벳이 사용된 개수의 최댓값을 저장할 변수 max
		char ans = '?';	// 가장 많이 사용된 알파벳을 저장할 변수 ans
		for(int i=0;i<26;i++) {
			// 만약 현재 알파벳이 사용된 개수가 지금까지 저장된 최댓값 max보다 크다면 max와 ans를 갱신해준다.
			if(alpha[i]>max) {
				max = alpha[i];			// max를 현재 알파벳이 사용된 개수로 갱신해준다.
				ans = (char)('A'+i);	// ans를 현재 알파벳으로 갱신해준다.
			}
			// 만약 현재 알파벳이 사용된 개수가 지금까지 저장된 최댓값 max와 같다면, 가장 많이 사용된 알파벳이 여러 개 존재하는 것이므로 ans에 ? 저장
			else if(alpha[i]==max) {
				ans = '?';
			}
		}
		
		System.out.println(ans);
	}
}
