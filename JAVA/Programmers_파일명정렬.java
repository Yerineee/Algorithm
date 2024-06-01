import java.util.*;

class Solution {
    // HEAD, NUMBER 부분을 나누어 배열로 반환
    public static String[] splitName(String name)  {
        String[] result = name.split("[^0-9]+");
        
        // 숫자 전까진 HEAD (대문자로 변환)
        result[0] = name.split(result[1])[0].toUpperCase();
        
        return result;
    }
    
    public String[] solution(String[] files) {
        ArrayList<String> list = new ArrayList(Arrays.asList(files));
        
        Arrays.sort(files, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] name1 = splitName(s1);
                String[] name2 = splitName(s2);
                
                // HEAD가 같다면 NUMBER로 비교
                if(name1[0].equals(name2[0])) {
                    // NUMBER도 같다면 입력 순서로 비교
                    if(Integer.parseInt(name1[1])==Integer.parseInt(name2[1])) {
                        return list.indexOf(s1)-list.indexOf(s2);
                    }
                    
                    return Integer.parseInt(name1[1])-Integer.parseInt(name2[1]);
                }
                
                // HEAD로 비교
                return name1[0].compareTo(name2[0]);
            }
        });
        
        return files;
    }
}
