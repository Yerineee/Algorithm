import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1783 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" "); // 입력
		
		int M = Integer.parseInt(input[1]);	// 가로 길이 M
		int N = Integer.parseInt(input[0]);	// 세로 길이 N
		int answer = 0;	// 병든 나이트가 방문할 수 있는 칸의 최대 개수
		
		// 첫 번째 경우의 수 (N이 1일 때) : 병든 나이트가 움직일 수 없으므로 방문할 수 있는 칸은 1개
		if(N == 1) answer = 1;
		// 두 번째 경우의 수 (N이 2일 때)
		// 병든 나이트가 움직일 수 있는 방법은 (오른쪽으로 2칸, 위로 1칸) 또는 (오른쪽으로 2칸, 아래로 1칸)이므로 방문 가능한 칸은 (M+1)/2개
		// 예외 : 이동 횟수가 4번 이상이면 안되므로 방문 가능한 칸의 최대 개수는 4
		else if (N==2) answer = Math.min((M+1)/2, 4);
		// 세 번째 경우의 수 (N이 3 이상일 떄)
		// 병든 나이트는 어느 경로 방법을 이용해 움직일 수 있음
		// M이 7보다 작은 경우, 이동 방법을 모두 한 번씩 사용할 수 없으므로 (모든 이동 방법을 이용하면 가로로 6칸 이동해야 하므로) M개의 칸에 방문 가능 (최대 4개까지 방문 가능)
		// M이 7 이상인 경우, 1(처음 여행을 시작한 칸)+4(모든 이동 방법을 이용하여 도달한 칸)+(M-7)개의 칸에 방문할 수 있으므로 (M-2)개의 칸에 방문 가능
		// 위에서 (M-7)은 이동 방법 중 (오른쪽으로 1칸)을 움직이는 두가지 이동 방법을 이용하여 방문한 칸의 개수임 (그래야 최대한 많은 칸에 방문 가능) 
		else if (N>=3) {
			if(M<7) answer = Math.min(M,4);
			else answer = M-2;
		}
		
		System.out.println(answer);
	}
}
