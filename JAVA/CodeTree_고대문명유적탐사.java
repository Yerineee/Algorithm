import java.util.*;
import java.io.*;

// 좌표 클래스
class Point {
    int r, c; // 행, 열

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class CodeTree_2 {
    static int k, m, ans;
    static ArrayList<Integer> wall = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 배열을 시계 방향으로 90도 회전하는 함수 (rotateCnt는 90도 회전 횟수로, 180도 회전 시 rotateCnt=2)
    public static int[][] rotateMap(int[][] map, Point center, int rotateCnt) {
        int[][] rotatedMap = new int[5][5];
        for(int r=0;r<5;r++) {
            for(int c=0;c<5;c++) {
                if(r>=center.r-1 && r<=center.r+1 && c>=center.c-1 && c<=center.c+1) continue;
                rotatedMap[r][c] = map[r][c];
            }
        }

        for(int cnt=0;cnt<rotateCnt;cnt++) {
            int[][] grid = new int[3][3];

            // 90도 회전시킨 3*3 격자 저장하기
            int num = 0;
            for(int c=center.c-1;c<=center.c+1;c++) {
                for(int r=center.r+1;r>=center.r-1;r--) {
                    grid[num/3][num%3] = map[r][c];
                    num++;
                }
            }

            num = 0;
            for(int r=center.r-1;r<=center.r+1;r++) {
                for(int c=center.c-1;c<=center.c+1;c++) {
                    rotatedMap[r][c] = grid[num/3][num%3];
                    num++;
                }
            }
        }

        return rotatedMap;
    }

    // 3개 이상 연결된 유물 조각 위치 구하는 함수
    public static ArrayList<Point> getTreasure(int[][] map) {
        ArrayList<Point> treasure = new ArrayList<>(); // 3개 이상 연결된 유물 조각 위치
        boolean[][] visit = new boolean[5][5]; // 유물 조각 방문 여부
        Queue<Point> q = new LinkedList<>();
        
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                // BFS 이용해서 서로 연결된 유물 조각 찾기
                if(visit[i][j]) continue;

                q.clear();
                ArrayList<Point> temp =new ArrayList<>();

                q.add(new Point(i, j));
                temp.add(new Point(i, j));
                visit[i][j] = true;

                while(!q.isEmpty()) {
                    Point cur = q.poll();

                    for(int k=0;k<4;k++) {
                        Point next = new Point(cur.r+dr[k], cur.c+dc[k]);

                        if(next.r<0 || next.r>=5 || next.c<0 || next.c>=5 || visit[next.r][next.c]) continue;

                        if(map[cur.r][cur.c] == map[next.r][next.c]) {
                            q.add(next);
                            temp.add(next);
                            visit[next.r][next.c] = true;
                        }
                    }
                }

                // 3개 이상 연결된 유물 조각이면 treasure에 저장
                if(temp.size() >= 3) {
                    for(int k=0;k<temp.size();k++) {
                        treasure.add(temp.get(k));
                    }
                }
            }
        }

        return treasure;
    }

    public static void printMap(int[][] map) {
        System.out.println("***************");
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken()); // 탐사 반복 횟수 k
        m = Integer.parseInt(st.nextToken()); // 벽면에 적힌 유물 조각의 개수 m

        // 유물 조각에 적힌 숫자 저장
        int[][] map = new int[5][5];
        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽면에 적힌 유물 조각 번호 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            wall.add(Integer.parseInt(st.nextToken()));
        }

        for(int turn=0;turn<k;turn++) {
            ans = 0;

            // (1) 탐사
            // 획득 가치가 최대이고, 회전각도가 작고, 열이 작고, 행이 작은 경우 저장
            int maxValue = 0, rotateCnt = 4;
            Point center = new Point(1, 1);

            for(int c=1;c<=3;c++) {
                for(int r=1;r<=3;r++) {
                    for(int cnt=1;cnt<=3;cnt++) {
                        int[][] rotatedMap = rotateMap(map, new Point(r, c), cnt);
                        int value = getTreasure(rotatedMap).size();

                        if(value > maxValue
                        || value == maxValue && cnt < rotateCnt) {
                            maxValue = value;
                            rotateCnt = cnt;
                            center = new Point(r, c);
                        }
                    }
                }
            }

            // 유물을 획득할 수 없다면 모든 탐사 즉시 종료
            if(maxValue == 0) return;

            // 위에서 구한 회전 방법에 따라 유적지 회전
            map = rotateMap(map, center, rotateCnt);

            // (2) 유물 연쇄 획득
            while(true) {
            	printMap(map);
            	
                ArrayList<Point> treasure = getTreasure(map);

                if(treasure.size() == 0) break; // 3개 이상 연결된 유물 조각이 없다면, 연쇄 획득 종료

                ans += treasure.size();
                
                // 열 번호 낮은 순, 행 번호 높은 순으로 유물 위치 정렬
                Collections.sort(treasure, new Comparator<Point>() {
                    public int compare(Point p1, Point p2) {
                        if(p1.c == p2.c) {
                            return p2.r-p1.r;
                        }
                        return p1.c-p2.c;
                    }
                });

                for(int i=0;i<treasure.size();i++) {
                    Point cur = treasure.get(i);

                    map[cur.r][cur.c] = wall.get(0); // 발견한 유물 조각은 벽면에 적힌 숫자로 채우기
                    wall.remove(0); // 벽면에 적힌 숫자 이용한 이후에는 삭제
                }
            }

            // 해당 턴에서 획득한 유물 가치의 총합 출력
            System.out.print(ans+" ");
        }
    }
}
