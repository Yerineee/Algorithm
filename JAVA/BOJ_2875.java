import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 여학생 수
		int M = Integer.parseInt(st.nextToken());	// 남학생 수
		int K = Integer.parseInt(st.nextToken());	// 인턴쉽 프로그램에 참여해야 하는 학생 수
		
		int answer = 0;	// 최대 팀 수
		// (여학생 수) >= 2*(남학생 수)이면 (여학생 수)에서 인턴쉽 참여할 사람 빼기
		// (여학생 수) < 2*(남학생 수)이면 (남학생 수)에서 인턴쉽 참여할 사람 빼기
		while(K-->0) {
			if(N >= 2*M) {
				N--;
			} else {
				M--;
			}
		}
		
		answer = Math.min(M, N/2);	// (여학생 수)와 (남학생 수/2) 중 최솟값이 만들 수 있는 최대 팀 수
		if(answer<=0) {	// answer 변수가 0보다 작거나 같다면 만들 수 있는 팀이 없는 것이므로 0 출력
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}

}
