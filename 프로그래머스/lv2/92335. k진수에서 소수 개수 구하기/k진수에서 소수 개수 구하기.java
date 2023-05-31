import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String change = Integer.toString(n, k);
        String[] split = change.split("0");
        
        for(String str : split){
            if(!str.equals("")){
                long num = Long.parseLong(str);
                if(isPrime(num)){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    static boolean isPrime(long n){
        
        if(n == 0 || n == 1) return false;
        
        if(n == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            //루트이하 수에서 나눠지는 수가 있으면 소수가 아님
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}