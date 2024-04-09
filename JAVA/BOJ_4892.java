import java.util.Scanner;

public class BOJ_4892 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int cnt=1;
		while(true) {
			int n0=sc.nextInt();
			// 마지막줄에 0 입력받으면 종료
			if(n0==0) {
				break;
			}
			
			int n1=3*n0;
			
			System.out.print(cnt+". ");
			
			// 짝수이면 even 출력
			if(n1%2==0) {
				System.out.println("even "+n0/2);
			}
			// 홀수이면 odd 출력
			else {
				System.out.println("odd "+(n0-1)/2);
			}
			cnt++;
		}
		
		sc.close();
	}
}
