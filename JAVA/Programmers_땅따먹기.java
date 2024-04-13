// 첫 번째 방법
import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
        // 같은 열을 연속해서 밟을 수 없는 특수 규칙
        for(int i=0;i<land.length;i++) {
            if(i==0) continue;
            
            land[i][0] = Math.max(land[i][0]+land[i-1][1], Math.max(land[i][0]+land[i-1][2], land[i][0]+land[i-1][3]));
            land[i][1] = Math.max(land[i][1]+land[i-1][0], Math.max(land[i][1]+land[i-1][2], land[i][1]+land[i-1][3]));
            land[i][2] = Math.max(land[i][2]+land[i-1][0], Math.max(land[i][2]+land[i-1][1], land[i][2]+land[i-1][3]));
            land[i][3] = Math.max(land[i][3]+land[i-1][0], Math.max(land[i][3]+land[i-1][1], land[i][3]+land[i-1][2]));
        }
        
        Arrays.sort(land[land.length-1]);
        answer = land[land.length-1][3];
        
        return answer;
    }
}

// 두 번째 방법
/*
import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
        // 같은 열을 연속해서 밟을 수 없는 특수 규칙
        for(int i=0;i<land.length;i++) {
            if(i==0) continue;
            
            for(int j=0;j<4;j++) {
                int temp = land[i][j];
                
                for(int k=0;k<4;k++) {
                    if(j!=k) {
                        land[i][j] = Math.max(land[i][j], temp+land[i-1][k]);
                    }
                }
            }
        }
        
        Arrays.sort(land[land.length-1]);
        answer = land[land.length-1][3];
        
        return answer;
    }
}
*/
