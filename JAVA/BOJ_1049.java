import java.io.*;
import java.util.*;

public class BOJ_1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 끊어진 기타줄의 개수 (입력)
		int M = Integer.parseInt(st.nextToken());	// 기타줄 브랜드 (입력)
		int ans = 0;	// 출력 값(기타줄을 사기 위해 필요한 돈의 최솟값)
		
		int[] pack = new int[M];	// 기타줄 패키지 가격
		int[] each = new int[M];	// 기타줄 낱개 가격
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			pack[i] = Integer.parseInt(st.nextToken());
			each[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(pack);		// 패키지 가격 정렬
		Arrays.sort(each);		// 낱개 가격 정렬

		// 경우의 수 3가지
		// 1. 패키지로만 사는 경우
		// 2. 패키지와 낱개를 섞어서 사는 경우
		// 3. 낱개로만 사는 경우
		ans = pack[0]*(N/6) + Math.min(pack[0],each[0]*(N%6));
		ans = Math.min(ans, N*each[0]);
		
		System.out.println(ans);	// 결과 출력
	}
}
