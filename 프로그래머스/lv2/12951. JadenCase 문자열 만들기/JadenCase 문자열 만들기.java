import java.util.*;
import java.util.regex.*;

class Solution {
    public String solution(String s) {
        
        String[] split = s.split(" ");
        
        String result = " ";
        char temp = ' ';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c != ' '){
                // 문자의 첫번쨰라면
                if(temp == ' '){
                    c = Character.toUpperCase(c);
                }
                else{
                    c = Character.toLowerCase(c);
                }
            }
            
            temp = c;
            result += Character.toString(c);
        }
        
        
        
        return result.substring(1, result.length());
    }
}