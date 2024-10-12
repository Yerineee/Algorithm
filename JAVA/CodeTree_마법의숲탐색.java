// 코드트리_마법의 숲 탐색

import java.util.*;
import java.io.*;

class Spirit {
    int r, c, d; // 행, 열, 출구 방향
    
    Spirit(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

public class CodeTree_1 {
    static int r, c, k, ans = 0;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 1. 숲의 정령을 모두 비우는 함수 (map 배열 값을 모두 0으로 설정)
    public static void initMap() {
        for(int i=3;i<=r+2;i++) {
            Arrays.fill(map[i], 0);
        }
    }

    // 2. 골렘을 남쪽으로 이동하고 map 배열에 저장하는 함수
    public static Spirit moveGolem(Spirit spirit) {
        // 골렘을 우선순위에 따라 남쪽으로 이동
        while(true) {
            // 남쪽으로 이동할 수 없으면(범위 문제로 인해) 반복문 종료
            if(spirit.r > r) break;

            // (1) 남쪽으로 한칸 이동
            if(map[spirit.r+2][spirit.c]==0 && map[spirit.r+1][spirit.c-1]==0 && map[spirit.r+1][spirit.c+1]==0) {
                spirit.r++;
                continue;
            }
            // (2) 서쪽 방향으로 회전하면서 남쪽으로 이동
            if(spirit.c > 2) {
                if(map[spirit.r-1][spirit.c-1]==0 && map[spirit.r][spirit.c-2]==0 && map[spirit.r+1][spirit.c-1]==0) {
                    if(map[spirit.r+1][spirit.c-2]==0 && map[spirit.r+2][spirit.c-1]==0) {
                        spirit.r++;
                        spirit.c--;
                        spirit.d = spirit.d-1==-1 ? 3 : spirit.d-1; // 출구는 반시계 방향으로 이동
                        continue;
                    }
                }
            }
            // (3) 동쪽 방향으로 회전하면서 남쪽으로 이동
            if(spirit.c <= c-2) {
                if(map[spirit.r-1][spirit.c+1]==0 && map[spirit.r][spirit.c+2]==0 && map[spirit.r+1][spirit.c+1]==0) {
                    if(map[spirit.r+1][spirit.c+2]==0 && map[spirit.r+2][spirit.c+1]==0) {
                        spirit.r++;
                        spirit.c++;
                        spirit.d = spirit.d+1==4 ? 0 : spirit.d+1; // 출구는 시계 방향으로 이동
                        continue;
                    }
                }
            }
            
            // (1)~(3)에 해당되지 않아, 이동할 수 없으면 반복문 종료
            break;
        }

        // * 예외 : 남쪽으로 이동했음에도 만약 골렘이 숲을 벗어난 상태이면 숲을 비우기
        if(spirit.r < 4) {
            initMap();
            return new Spirit(-1, -1, -1);
        }
        // 그렇지 않다면, map 배열에 골렘의 위치 저장
        else {
            map[spirit.r][spirit.c] = 3; // 골렘의 중심은 3으로 저장
            for(int i=0;i<4;i++) {
                // 출구는 2로 저장하고, 나머지는 1로 저장
                map[spirit.r+dr[i]][spirit.c+dc[i]] = spirit.d==i ? 2 : 1;
            }

            return spirit;
        }
    }

    // 3. 정령을 가장 남쪽으로 이동시키고 최종 위치를 ans에 더하는 함수 (BFS 이용)
    public static void moveSpirit(Spirit spirit) {
        boolean[][] visit = new boolean[r+3][c+1]; // 각 칸의 방문 여부 체크
        Queue<Spirit> q = new LinkedList<>();
        q.add(spirit);
        visit[spirit.r][spirit.c] = true;

        int maxR = 0; // 정령이 갈 수 있는 칸 중 가장 큰 행의 번호
        while(!q.isEmpty()) {
            Spirit cur = q.poll();
            if(cur.r > maxR) maxR = cur.r;

            // 상하좌우 탐색
            for(int i=0;i<4;i++) {
                Spirit next = new Spirit(cur.r+dr[i], cur.c+dc[i], cur.d);

                if(next.r<=2 || next.r>r+2 || next.c<=0 || next.c>c) continue; // 숲의 범위를 벗어나면 넘어가기
                if(visit[next.r][next.c]) continue; // 이미 방문한 칸이면 넘어가기

                /* (1) 현재 위치가 출구이면, 인접한 골렘 어디든 이동 가능
                (2) 현재 위치가 골렘의 중심이면, 상하좌우 이동 가능
                (3) 현재 위치가 (1),(2)에 해당하지 않으면, 중심으로만 이동 가능
                */
                if(map[cur.r][cur.c] == 2 && map[next.r][next.c] != 0
                || map[cur.r][cur.c] == 3
                || map[cur.r][cur.c] == 1 && map[next.r][next.c] == 3) {
                        q.add(next);
                        visit[next.r][next.c] = true;
                }
            }
        }

        ans += maxR-2; // 최종 위치를 ans에 더하기
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 숲의 세로 크기
        c = Integer.parseInt(st.nextToken()); // 숲의 가로 크기
        k = Integer.parseInt(st.nextToken()); // 정령의 수
        map = new int[r+3][c+1];              // 숲 (0: 빈칸, 1: 골렘, 2: 출구, 3: 골렘의 중심)

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine());
            int ci = Integer.parseInt(st.nextToken()); // 각 골렘이 출발하는 열
            int di = Integer.parseInt(st.nextToken()); // 각 골렘의 출구 방향 정보

            Spirit spirit = new Spirit(1, ci, di);
            spirit = moveGolem(spirit);

            // 숲을 비우지 않았을 때만, 정령 이동시키기
            if(spirit.r != -1) moveSpirit(spirit);
        }

        System.out.println(ans);
    }
}
