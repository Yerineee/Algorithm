import java.util.*;

class Solution {
    // 해당 위치가 유효한지 확인 (좌표평면의 경계를 넘어가면 false 반환)
    public static boolean isValid(int row, int col) {
        if(Math.abs(row)>5 || Math.abs(col)>5) {
            return false;
        }
        
        return true;
    }
    
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        
        int row = 0;
        int col = 0;
        for(int i=0;i<dirs.length();i++) {
            String str = "";
            // 명령어 실행 시 이동하게 될 위치
            int tempR = row;
            int tempC = col;
            
            // str 변수에 현재 위치와 이동할 위치를 문자열로 저장
            switch(dirs.charAt(i)) {
                case 'U':
                    str = str+row+col+(row+1)+col;
                    tempR += 1;
                    break;
                case 'D':
                    str = str+(row-1)+col+row+col;
                    tempR -= 1;
                    break;
                case 'R':
                    str = str+row+col+row+(col+1);
                    tempC += 1;
                    break;
                default:
                    str = str+row+(col-1)+row+col;
                    tempC -= 1;
            }
            
            // 이동한 후의 위치가 유효하다면, set에 저장 후 row와 col 갱신
            if(isValid(tempR, tempC)) {
                set.add(str);
                row = tempR;
                col = tempC;
            }
        }
        
        return set.size();
    }
}
