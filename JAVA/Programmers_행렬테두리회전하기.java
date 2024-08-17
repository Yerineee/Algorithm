import java.util.*;

class Solution {
    static int[][] map;
    static int[] answer;
    
    // 행렬 회전한 후 가장 작은 숫자 반환하는 함수
    static int rotateArr(int[] query) {
        int startX = query[0]-1, startY = query[1]-1;
        int endX = query[2]-1, endY = query[3]-1;
        
        int startNum = map[startX][startY]; // map[startX][startY] 값 임시로 저장
        int min = startNum; // 회전하는 숫자들 중 가장 작은 수 저장
        
        // 왼쪽 위로 이동
        for(int i=startX;i<endX;i++) {
            map[i][startY] = map[i+1][startY];
            min = Math.min(min, map[i][startY]);
        }
        
        // 아랫줄 좌측으로 이동
        for(int i=startY;i<endY;i++) {
            map[endX][i] = map[endX][i+1];
            min = Math.min(min, map[endX][i]);
        }
        
        // 오른쪽 아래로 이동
        for(int i=endX;i>startX;i--) {
            map[i][endY] = map[i-1][endY];
            min = Math.min(min, map[i][endY]);
        }
        
        // 윗줄 우측으로 이동
        for(int i=endY;i>startY+1;i--) {
            map[startX][i] = map[startX][i-1];
            min = Math.min(min, map[startX][i]);
        }
        
        map[startX][startY+1] = startNum;
        
        return min;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        map = new int[rows][columns];
        
        // 행렬 초기화
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                map[i][j] = i*columns+j+1;
            }
        }
        
        // queries에 따라 행렬 회전
        for(int i=0;i<queries.length;i++) {
            answer[i] = rotateArr(queries[i]);
        }
        
        return answer;
    }
}
