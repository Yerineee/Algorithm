import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		
		while(p-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());	// 테스트 케이스 번호
			ArrayList<Integer> list = new ArrayList<>();
			
			int cnt = 0;	// 학생들이 뒤로 물러난 걸음 수의 총합
			// 20번(학생 수만큼) 반복
			for(int i=0;i<20;i++) {
				int height = Integer.parseInt(st.nextToken());	// (i+1)번째 학생의 키
				
				// 기존에 저장된 학생들의 키와 비교하여 키 큰 학생 수만큼 cnt 변수를 1만큼 증가시켜준다.
				for(int j=0;j<list.size();j++) {
					if(list.get(j)>height) cnt++;
				}
				
				list.add(height);	// 리스트에 학생 키를 저장해준다.
			}
			
			System.out.println(t+" "+cnt);	// 테스트 케이스 번호와 학생들이 뒤로 물러난 걸음 수를 출력해준다.
		}
	}
}
