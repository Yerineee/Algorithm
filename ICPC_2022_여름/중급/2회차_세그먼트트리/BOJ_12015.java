package �߱�_2ȸ��;

import java.util.*;
import java.io.*;

public class BOJ_12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());	// ���� A ũ��
		List<Integer> list=new ArrayList<Integer>(); // �����ϴ� �κ� ������ ����Ʈ
		list.add(0);
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(st.nextToken());
			
			if(num>list.get(list.size()-1))
				list.add(num);
			else {
				int left=1;
				int right=list.size()-1;
				
				while(left<right) {
					int mid=(left+right)/2;
					if(list.get(mid)<num)
						left=mid+1;
					else
						right=mid;
				}
				list.set(right,num);
			}
			
		}
		
		sb.append(list.size()-1);
		System.out.println(sb.toString());
	}
}
