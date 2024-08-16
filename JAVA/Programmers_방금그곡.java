import java.util.*;

class Solution {
    // 1. A#, C#, D#, F#, G#을 각각 a, c, d, g로 변환
    static String changeMusic(String music) {
        music = music.replace("A#", "a")
            .replace("B#", "b")
            .replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g");
            
        return music;
    }
    
    // 2. 재생 시간 구하는 함수
    static int getPlayTime(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        
        return (Integer.parseInt(end[0])-Integer.parseInt(start[0]))*60+Integer.parseInt(end[1])-Integer.parseInt(start[1]);
    }
    
    // 3. 재생 시간만큼 이어붙인 악보 구하는 함수
    static String getMelody(String music, int playTime) {
        int musicLen = music.length();
        
        String melody = music.repeat(playTime/musicLen);
        melody += music.substring(0, playTime%musicLen);
        
        return melody;
    }
    
    public String solution(String m, String[] musicinfos) {
        ArrayList<String[]> list = new ArrayList<>();
        m = changeMusic(m);
        
        for(int i=0;i<musicinfos.length;i++) {
            String[] info = musicinfos[i].split(",");
            info[3] = changeMusic(info[3]);
            
            // 재생시간 계산
            int playTime = getPlayTime(info[0], info[1]);
            
            // 음을 재생시간 길이만큼 이어붙이기
            String melody = getMelody(info[3], playTime);
            
            // 해당 문자열에 m이 포함되어있는지 체크
            if(melody.contains(m)) {
                // 포함되어 있다면 arraylist에 음악 제목, 재생시간, 인덱스 저장
                    list.add(new String[]{info[2], Integer.toString(playTime), Integer.toString(i)});
            }
        }
        
        // arraylist에 저장된 음악이 없다면 “(None)” 반환
        if(list.size() == 0) return "(None)";
        
        Collections.sort(list, new Comparator<String[]>() {
            public int compare(String[] s1, String[] s2) {
                if(Integer.parseInt(s2[1]) == Integer.parseInt(s1[1])) {
                    return Integer.parseInt(s1[2])-Integer.parseInt(s2[2]);
                }
                return Integer.parseInt(s2[1])-Integer.parseInt(s1[1]);
            }
        });
        
        return list.get(0)[0];
    }
}
