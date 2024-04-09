import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();	// 입력받은 수 N (Integer나 Long으로 입력 받으면 NumberFormat 런타임 에러 발생)
		ArrayList<Character> list = new ArrayList<>();	// 각 자리의 숫자 저장할 ArrayList
		
		Long sum = (long) 0;	// 각 자리의 숫자의 합
		// 각 자리 숫자의 합을 구하고, ArrayList에 저장
		for(int i=0;i<N.length();i++) {
			int num = (int)(N.charAt(i));
			sum += num;	
			list.add(N.charAt(i));
		}
		
		// 출력할 변수 answer
		String answer;
		// ArrayList에 0이 없거나 각 자리 수의 합계가 3의 배수가 아니라면, 숫자를 조합해도 30의 배수가 될 수 없으므로 -1 반환
		if(!list.contains('0') || sum%3 != 0) {
			answer = "-1";
		} else {
			// 30의 배수가 될 수 있는 경우, ArrayList를 내림차순으로 정렬한 후 임시 변수 temp에 저장
			Collections.sort(list, Collections.reverseOrder());
			
			String temp = "";
			for(int num : list) {
				temp += Character.toString(num);
			}
			// temp 변수에 저장된 문자열을 answer에 저장
			answer = temp;
		}
		
		// answer 출력
		System.out.println(answer);
	}
}
