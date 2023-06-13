import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int num = 0;
        
        while(str.length() < t * m){
            str += Integer.toString(num++, n);
        }
        
        
        
        for(int i = 0; i < str.length(); i++){
            if(i % m == p - 1 && answer.length() < t){
                answer += str.charAt(i);
            }
        }
        
        answer = answer.toUpperCase();
        
        return answer;
    }
}