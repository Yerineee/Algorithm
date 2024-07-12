class Solution {
    static int[][] arr;
    static int[] dx = {0, 1, -1};
    static int[] dy = {1, 0, -1};
    
    // turn : 반시계 방향으로 돈 횟수
    public static void fillArr(int n, int turn, int num, int row, int col) {
        if(turn >= n) return;   // (n-1)번 반시계 방향으로 돌았다면 끝내기
        
        // 1. turn%3이 0이면, 수직 방향으로 1 이동
        // 2. turn%3이 1이면, 수평 방향으로 1 이동
        // 3. turn%3이 2이면, 대각선 방향으로 1 이동
        for(int i=0;i<n-turn;i++) {
            col += dx[turn%3];
            row += dy[turn%3];
            arr[row][col] = num++;
        }
        
        // 반시계 방향으로 돌기
        fillArr(n, turn+1, num, row, col);
    }
    
    public int[] solution(int n) {
        arr = new int[n][n];    // 달팽이 채우기 진행한 배열
        
        // 달팽이 채우기 진행
        fillArr(n, 0, 1, -1, 0);
        
        // arr의 모든 행을 순서대로 합친 새로운 배열
        int[] answer = new int[n*(n+1)/2];
        int idx = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
