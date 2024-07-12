import java.util.*;

class Solution {
    static boolean[] check;     // 숫자 이용 여부 체크
    static String[] nums;
    static Set<String> ans = new HashSet<>(); // 만들어진 숫자 중복을 피하기 위함
    
    // 소수인지 판별하는 함수
    public boolean isPrimeNum(String number) {
        int num = Integer.parseInt(number);
        // 2 미만의 수는 소수가 아님
        if(num < 2) return false;
        
        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num%i == 0) return false;   // 약수를 가진다면 소수가 아님
        }
        
        return true;
    }
    
    public void search(String number) {        
        // 해당 숫자가 소수이면 ans 1 증가
        if(isPrimeNum(number)) ans.add(number);
        // 모든 숫자를 이용했을 경우 return
        if(number.length() == nums.length) return;
        
        // 다른 숫자 이용하여 새로운 수 만들기
        for(int i=0;i<nums.length;i++) {
            if(!check[i]) {
                check[i] = true;
                search(number+nums[i]);
                check[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        nums = numbers.split("");
        
        for(int i=0;i<nums.length;i++) {
            // 0으로 시작하는 숫자는 제외
            if(nums[i].equals("0")) continue;
            
            Arrays.fill(check, false);
            check[i] = true;
            search(nums[i]);
        }
        
        return ans.size();
    }
}
