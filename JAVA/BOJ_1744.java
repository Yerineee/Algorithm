import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1744 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 수열 크기 N
		ArrayList<Integer> positive = new ArrayList<>();	// 1을 제외한 양수를 저장할 리스트
		ArrayList<Integer> negative = new ArrayList<>();	// 0과 음수를 저장할 리스트
		
		int ans = 0;	// 수열을 묶었을 때, 그 합의 최댓값
		
		// 1. 양수끼리는 두 개의 수가 모두 1이 아니면 모두 묶어준다. (1은 무조건 묶지 않고 더해준다.)
		// 2. 음수가 짝수개이면 음수끼리 묶어준다.
		// 3. 음수가 홀수개일 경우, 0이 있으면 0과 묶어준다.
		
		// 수가 1이면 더해주고, 양수이면 positive 리스트에, 음수나 0이면 negative 리스트에 저장해준다.
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==1) {
				ans++;
			} else if(num>0) {
				positive.add(num);
			} else {
				negative.add(num);
			}
		}
		
		// positive와 negative 리스트 오름차순 정렬
		Collections.sort(positive);
		Collections.sort(negative);
		
		// 양수는 뒤에서부터(큰 수부터) 묶어주고, 음수는 앞에서부터 묶어준다(작은 수부터)
		for(int i=positive.size()-1;i>0;i-=2) {
			ans += positive.get(i)*positive.get(i-1);
		}
		
		for(int i=0;i<negative.size()-1;i+=2) {
			ans += negative.get(i)*negative.get(i+1);
		}
		
		// positive 리스트와 negative 리스트에 저장된 수의 개수가 홀수이면, 남은 하나의 수를 더해준다. (더 이상 묶어줄 수가 없기 때문)
		if(positive.size()%2!=0) {
			ans += positive.get(0);
		}
		if(negative.size()%2!=0) {
			ans += negative.get(negative.size()-1);
		}

		System.out.println(ans);
	}
}
