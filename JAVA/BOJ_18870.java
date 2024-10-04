import java.util.*;
import java.io.*;

public class BOJ_18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 좌표 개수 n
		int[] x = new int[n]; 		// 좌표 x
		int[] sortedX = new int[n]; // x 정렬한 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			x[i] = Integer.parseInt(st.nextToken());
			sortedX[i] = x[i];
		}
		Arrays.sort(sortedX); // sortedX를 오름차순 정렬
		
		HashMap<Integer, Integer> map = new HashMap<>();
		// (숫자, 몇번째로 큰수인지)를 해시맵에 저장
		for(int i=0;i<n;i++) {
			// 숫자가 같으면 순위도 같아야 하므로, 해시맵에 이미 같은 수가 저장되어 있는지 확인
			if(map.containsKey(sortedX[i])) continue;
			
			map.put(sortedX[i], map.size());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(map.get(x[i])+" ");
		}
		
		System.out.println(sb.toString());
		/*
		 * 시간 초과로 인해 StringBuilder를 사용했고, 시간 초과 문제 해결할 수 있었음
		 */
	}
}
