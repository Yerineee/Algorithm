import java.util.*;
import java.io.*;

public class CodeTree_3 {
    static int n, m, p, c, d, turn;
    static int[][] board;
    static Point rudolph;
    static Point[] santa;
    static boolean[] fail;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    // 좌표 클래스
    static class Point implements Comparable<Point> {
        int r, c, num, faint, score;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Point(int r, int c, int num, int faint, int score) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.faint = faint;
            this.score = score;
        }

        public int compareTo(Point p) {
            return this.num - p.num;
        }
    }

    // *함수1) 입력 받은 각종 변수들 초기화하는 함수
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 게임판의 크기
        m = Integer.parseInt(st.nextToken()); // 게임 턴 수
        p = Integer.parseInt(st.nextToken()); // 산타 수
        c = Integer.parseInt(st.nextToken()); // 루돌프의 힘
        d = Integer.parseInt(st.nextToken()); // 산타의 힘
        board = new int[n][n]; // 게임판 (산타 번호 저장)

        // 루돌프의 초기 위치
        st = new StringTokenizer(br.readLine());
        rudolph = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);

        // 산타들의 초기 위치
        santa = new Point[p+1];
        for(int i=0;i<p;i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            santa[num] = (new Point(r-1, c-1, num, 0, 0));
            board[r-1][c-1] = num;
        }

        // 탈락한 산타
        fail = new boolean[p+1];
    }

    // *함수2) 두칸 사이의 거리 구하는 함수
    public static int getDistance(Point p1, Point p2) {
        return (p1.r-p2.r)*(p1.r-p2.r) + (p1.c-p2.c)*(p1.c-p2.c);
    }

    // *함수3) 범위 밖에 있는 점인지 확인하는 함수
    public static boolean isOutside(Point p) {
        if(p.r<0 || p.r>=n || p.c<0 || p.c>=n) return true;
        else return false;
    }
    
    // *함수4) 루돌프 이동
    public static void moveRudolph() {
    	// 1. 가까운 산타 찾기
    	int nearNum = 0, nearDis = Integer.MAX_VALUE;
    	for(int i=1;i<=p;i++) {
    		// 탈락한 산타 제외
    		if(fail[i]) continue;
    		
    		int dis = getDistance(rudolph, santa[i]);
    		if(dis < nearDis
    				|| dis == nearDis && santa[nearNum].r < santa[i].r
    				|| dis == nearDis && santa[nearNum].r == santa[i].r && santa[nearNum].c < santa[i].c)
    		{
    			nearNum = i;
    			nearDis = dis;
    		}
    	}
    	
    	// 2. 가까운 산타 방향으로 루돌프가 이동
    	int moveR = 0, moveC = 0;
    	if(rudolph.r < santa[nearNum].r) moveR = 1;
    	else if (rudolph.r > santa[nearNum].r) moveR = -1;
    	
    	if(rudolph.c < santa[nearNum].c) moveC = 1;
    	else if (rudolph.c > santa[nearNum].c) moveC = -1;
    	
    	rudolph.r += moveR;
    	rudolph.c += moveC;
    	
    	// 3. 루돌프가 움직여서 산타와 충돌
    	if(rudolph.r==santa[nearNum].r && rudolph.c==santa[nearNum].c) {
    		// c점 얻고, 루돌프가 움직인 방향으로 c칸 밀려나고 기절함
    		santa[nearNum].score += c;
    		board[santa[nearNum].r][santa[nearNum].c] = 0;
    		santa[nearNum].r += moveR*c;
    		santa[nearNum].c += moveC*c;
    		santa[nearNum].faint = 2;
    		
    		// 상호작용
    		interact(santa[nearNum], moveR, moveC);
    	}
    }
    
    // *함수5) 산타 이동
    public static void moveSanta() {
    	for(int num=1;num<=p;num++) {
    		
    		// 탈락했거나 기절한 산타는 넘어가기
    		if(fail[num]) continue;
    		if(santa[num].faint > 0) continue;
    		
    		// 1. 루돌프와 가까워지는 방향 찾기
        	int nearDir = -1, nearDis = getDistance(rudolph, santa[num]);
        	for(int dir=0;dir<4;dir++) {
        		Point next = new Point(santa[num].r+dr[dir], santa[num].c+dc[dir]);
        		
        		// 범위 밖이거나 다른 산타가 있으면 넘어가기
        		if(isOutside(next) || board[next.r][next.c]>0) continue;
        		
        		int dis = getDistance(rudolph, next);
        		if(dis < nearDis) {
        			nearDir = dir;
        			nearDis = dis;
        		}
        	}
        	
        	// 2. 가까워지는 방향으로 이동 - 이동할 수 없다면 이동하지 않기
        	if(nearDir > -1) {
        		board[santa[num].r][santa[num].c] = 0;
        		santa[num].r += dr[nearDir];
        		santa[num].c += dc[nearDir];
        		board[santa[num].r][santa[num].c] = num;
        		
        		// 3. 산타가 움직여서 루돌프와 충돌
            	if(rudolph.r==santa[num].r && rudolph.c==santa[num].c) {
            		// d점 얻고, 산타가 움직인 반대 방향으로 d칸 밀려나고 기절함
            		santa[num].score += d;
            		board[santa[num].r][santa[num].c] = 0;
            		santa[num].r -= dr[nearDir]*d;
            		santa[num].c -= dc[nearDir]*d;
            		santa[num].faint = 2;
            		
            		// 상호작용
            		interact(santa[num], dr[nearDir]*(-1), dc[nearDir]*(-1));
            	}
        	}
    	}
    }
    
    // *함수6) 상호작용
    public static void interact(Point newSanta, int moveR, int moveC) {
    	if(!isOutside(newSanta)) {
    		// 이미 다른 산타가 있는 경우
    		if(board[newSanta.r][newSanta.c] > 0) {
    			int prevNum = board[newSanta.r][newSanta.c]; // 원래 있던 산타 번호
    			santa[prevNum].r += moveR;
    			santa[prevNum].c += moveC;
    			interact(santa[prevNum], moveR, moveC);
    		}
    		
    		board[newSanta.r][newSanta.c]= newSanta.num;
    	} else {
    		fail[newSanta.num] = true; // 산타가 범위 밖에 있다면 탈락
    	}
    }

    public static void main(String[] args) throws IOException {
        // 입력 받은 변수 저장
        init();

        for(turn=1;turn<=m;turn++) {
        	// 1. 매 턴마다 기절 시간 줄이기
        	for(int num=1;num<=p;num++) {
        		if(santa[num].faint > 0) santa[num].faint--;
        	}
        	
        	// 2. 루돌프 이동
        	moveRudolph();
        	// 3. 산타 이동
        	moveSanta();
        	
        	// 4. 모든 산타가 탈락했으면 종료
        	boolean allFail = true;
        	for(int num=1;num<=p;num++) {
        		if(!fail[num]) {
        			allFail = false;
        			break;
        		}
        	}
        	if(allFail) break;
        	
        	// 5. 살아있는 산타에게 1점 부여
        	for(int num=1;num<=p;num++) {
        		if(!fail[num]) santa[num].score++;
        	}
        }
        
        // 최종 점수 출력
        for(int num=1;num<=p;num++) {
        	System.out.print(santa[num].score+" ");
        }
    }
}
