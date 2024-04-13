class Solution {
    static int answer = 10000;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void search(int[][] maps, int row, int col, boolean[][] check, int num) {
        
        // 상대팀 진영에 도착한 경우, answer 값 갱신
        if(row==maps.length-1 && col==maps[0].length-1) {
            answer = Math.min(answer, num);
            return;
        }
        
        // 위, 아래, 오른쪽, 왼쪽 방향 중 이동 가능한 방향으로 이동
        for(int i=0;i<4;i++) {
            int x = col+dx[i];
            int y = row+dy[i];
            if(x<0 || x>=maps[0].length || y<0 || y>=maps.length) continue;
            
            if(!check[y][x] && maps[y][x]==1) {
                check[y][x] = true;
                search(maps, y, x, check, num+1);
                check[y][x] = false;
            }
        }
    }
    
    public int solution(int[][] maps) {
        boolean[][] check = new boolean[maps.length][maps[0].length];   // 방문 확인을 위한 배열
        
        check[0][0] = true;
        search(maps, 0, 0, check, 1);
        
        // 상대 팀 진영에 도달하지 못한 경우
        if(answer == 10000) {
            answer = -1;
        }
        
        return answer;
    }
}
