package �ʱ�_1ȸ��;

import java.util.*;
import java.io.*;

public class BOJ_11651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int[][] num=new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			num[i][0]=Integer.parseInt(st.nextToken());	// x��ǥ
			num[i][1]=Integer.parseInt(st.nextToken());	// y��ǥ
		}
		
		Arrays.sort(num, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0]; // y��ǥ �����ϴ� �� -> x��ǥ �����ϴ� ��
			}
		});
		
		for(int i=0;i<N;i++) {
			sb.append(num[i][0]+" "+num[i][1]+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
