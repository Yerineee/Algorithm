import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 국가의 수 N
		int K = Integer.parseInt(st.nextToken());	// 등수를 알고 싶은 국가 K
		int[][] medal = new int[N+1][3];				// 금, 은, 동메달의 정보를 저장한 배열 medal
		
		// 입력받은 메달의 정보를 배열 medal에 저장
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());	// 국가를 나타내는 정수
			medal[num][0] = Integer.parseInt(st.nextToken());	// 해당 국가의 금메달 수
			medal[num][1] = Integer.parseInt(st.nextToken());	// 해당 국가의 은메달 수
			medal[num][2] = Integer.parseInt(st.nextToken());	// 해당 국가의 동메달 수
		}
		
		int rank = 1;	// 알고 싶은 국가의 등수
		for(int i=1;i<=N;i++) {
			if(i!=K) {	// 알고 싶은 국가가 아닐 때
				if(medal[i][0]>medal[K][0]) {	// 알고 싶은 국가보다 금메달 수가 많다면 등수+1
					rank++;
				} else if(medal[i][0]==medal[K][0] && medal[i][1]>medal[K][1]) {	// 알고 싶은 국가와 금메달 수가 같지만, 은메달 수가 많다면 등수+1
					rank++;
				} else if(medal[i][0]==medal[K][0] && medal[i][1]==medal[K][1] && medal[i][2]>medal[K][2]) {	// 알고 싶은 국가와 금,은메달 수가 같지만, 동메달 수가 많다면 등수+1
					rank++;
				}
			}
		}
		
		System.out.println(rank);
	}
}
