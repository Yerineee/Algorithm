import java.io.*;
import java.util.*;

public class BOJ_15828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());			// 버퍼의 크기
		
		Queue<Integer> queue = new LinkedList<Integer>();	// 큐 (패킷 저장)
		
		int packet, rest;				// packet: 입력받은 패킷 정보 저장할 변수, rest: 남은 패킷 저장할 변수
		while(true) {
			packet = Integer.parseInt(br.readLine());
			
			if(packet == -1) {			// -1을 입력받으면 반복문 빠져나가기
				break;
			}
			
			if(packet > 0 && queue.size() < N) {	// 입력받은 수가 양수이고 버퍼가 가득 차지 않았다면
				queue.add(packet);		// 버퍼에 패킷 추가
			} else if(packet == 0) {	// 0을 입력받으면 맨 앞의 패킷 꺼내기
				queue.poll();
			}
		}
		
		if(queue.isEmpty()) {			// 버퍼가 비어있으면 "empty" 츨력
			bw.write("empty");
		} else {
			while(!queue.isEmpty()) {	// 버퍼가 비어있지 않으면 남아있는 패킷 번호 출력
				rest = queue.poll();
				bw.write(rest+" ");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
