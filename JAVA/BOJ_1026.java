import java.io.*;
import java.util.*;
	
public class BOJ_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];	// 배열 A
		int[][] B = new int[N][2];	// 배열 B
		int[] temp = new int[N];	// S 값을 최소로 만들기 위해 정렬한 A 배열
		
		// A, B 배열에 숫자 저장
		for(int i=0;i<2;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(i==0) {
					A[j] = Integer.parseInt(st.nextToken());
				}
				else {
					B[j][0] = j;	// 인덱스 저장
					B[j][1] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		Arrays.sort(A);	// A 배열 오름차순으로 정렬
		Arrays.sort(B, new Comparator<int[]> () {	// B 배열을 숫자 기준으로 내림차순 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
		});
		
		int ans = 0;	// S의 최솟값
		for(int i=0;i<N;i++) {	// A 배열의 작은 값과 B 배열의 큰 값을 매치
			temp[B[i][0]] = A[i];
			ans += A[i]*B[i][1];
		}
		
		System.out.println(ans);
	}
}
