import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int num = 0;
        
        while(str.length() < t * m){
            str += Integer.toString(num++, n);
        }
        
        str = str.toUpperCase();
        
        for(int i = 0; i < str.length(); i++){
            if(i % m == p - 1 && answer.length() < t){
                answer += Character.toString(str.charAt(i));
            }
        }
        return answer;
    }
}