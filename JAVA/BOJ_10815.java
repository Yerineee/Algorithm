import java.io.*;
import java.util.*;

public class BOJ_10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 상근이가 갖고 있는 숫자 카드 개수 N
		st = new StringTokenizer(br.readLine());
		int[] card = new int[N];	// 상근이가 갖고 있는 숫자 카드
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);	// 숫자 카드 배열 정렬
		
		int M = Integer.parseInt(br.readLine());	// 상근이가 갖고 있는 카드인지 구해야 할 개수 M
		st = new StringTokenizer(br.readLine());
		int compareCard;		// 갖고 있는지 비교할 숫자 카드
		
		// 상근이가 해당 카드를 가지고 있는지 M번 비교하기
		for(int i=0;i<M;i++) {
			int pivot;
			int left = 0, right = N-1;
			boolean flag = false;	// 갖고 있는지 체크할 변수
			compareCard = Integer.parseInt(st.nextToken());
			
			while(left <= right) {
				pivot = (left+right)/2;
				
				if(card[pivot] == compareCard) {	// 해당 카드와 갖고 있는지 구해야 할 카드의 숫자가 같다면
					flag = true;					// 상근이가 해당 카드 갖고 있음을 체크
					sb.append("1 ");				// 1 출력
					break;
				}
				else if(card[pivot] < compareCard) { // 해당 카드가 갖고 있는지 구해야 할 카드의 숫자보다 작으면
					left = pivot + 1;				// left를 오른쪽으로 한칸 이동
				}
				else {								// 해당 카드가 갖고 있는지 구해야 할 카드의 숫자보다 크다면
					right = pivot - 1;				// right를 왼쪽으로 한칸 이동
				}
			}
			
			if(!flag) {				// 상근이가 카드를 갖고있지 않다면
				sb.append("0 ");	// 0 출력
			}
		}
		
		System.out.println(sb.toString());
	}
}
