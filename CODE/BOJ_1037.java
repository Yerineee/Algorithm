import java.io.*;
import java.util.*;

public class BOJ_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());	// 약수의 개수
		int[] arr=new int[num];	// 입력받은 약수 저장할 배열
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			arr[i]=Integer.parseInt(st.nextToken());	// 약수 저장
		}
		
		Arrays.sort(arr);	// 배열 정렬
		System.out.println(arr[0]*arr[num-1]);	// 배열의 첫번째 값과 마지막 값 곱해서 N 구하기
	}
}
