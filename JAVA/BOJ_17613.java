/*https://onedaycoding.tistory.com/235 참고함*/

import java.io.*;
import java.util.*;

public class BOJ_17613 {
	static int[] arr;
	
	public static int getIdx(int n) {	// 해당 숫자가 포함되는 구간 구하기
		int i;
		for(i=1;i<30;i++) {
			if(arr[i]>n) break;
		}
		
		return i-1;
	}
	
	public static int jump(int n) {	// 해당 구간의 점프넘버들 중 최댓값 구하기
		return n*(n+1)/2+1;
	}
	
	public static int calc(int x, int y, int n ) {
		int idx;
		int end = y;
		int num = 0;
		if(x==0 && y==0) return n;
		
		while(true) {
			idx=getIdx(end);	// 구간 알아내기
			if(arr[idx] <= x) break;
			
			if(arr[idx]*2==end) 
				num=Math.max(num, jump(idx));
			
			else
				num=Math.max(num, calc(1,end-arr[idx],idx));
			
			end=arr[idx]-1;
		}
		
		num=Math.max(num, calc(x-arr[idx],end-arr[idx],idx));
		
		return num+n;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		arr=new int[30];
		
		arr[1]=1;
		for(int i=2;i<30;i++) {
			arr[i]=2*arr[i-1]+1;	// 점프 간격 더해나감
		}
		
		for(int i=0;i<T;i++) {	// T번 반복
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			sb.append(calc(x,y,0)+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
