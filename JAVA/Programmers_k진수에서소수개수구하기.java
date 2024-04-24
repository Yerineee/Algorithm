class Solution {
    static int answer = 0;

    // num을 long 타입으로 선언하지 않으면 런타임 에러 발생
    public static void checkPrime(long num) {
        // num이 1이면 넘어가기
        if(num == 1) return;
        
        boolean flag = true;    // 소수인지 체크
        long sqrt = (long) Math.sqrt(num);  // num의 제곱근
        
        for(long i=2;i<=sqrt;i++) {
            // 소수가 아니면 반복문 빠져나가기
            if(num%i == 0) {
                flag = false;
                break;
            }
        }
        
        // 소수이면 answer 1 증가
        if (flag) answer++;
    }
    
    public int solution(int n, int k) {
        // k진수로 바꿨을 때의 수를 0을 기준으로 숫자 나누기
        String[] nums = Integer.toString(n, k).split("[0]+");
        
        // 소수 판별
        for(String num : nums) {
            checkPrime(Long.parseLong(num));
        }
        
        return answer;
    }
}
