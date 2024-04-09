import java.io.*;
import java.util.*;

public class BOJ_3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());	// 수열의 크기
		ArrayList<Integer> list = new ArrayList<Integer>();	// 수열 a 저장할 리스트
		
		// 수열 a를 리스트에 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int x = Integer.parseInt(br.readLine());	// 자연수 x
		Collections.sort(list);	// 리스트 정렬
		
		int ans = 0;	// 쌍의 개수 (결과값)
		int left = 0;
		int right = n-1;
		while(left<right) {
			int sum = list.get(left)+list.get(right);
			if(sum < x) {
				left++;
			}
			else if(sum == x) {
				ans++;
				left++;
				right--;
			}
			else {
				right--;
			}
		}

		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();
	}
}
