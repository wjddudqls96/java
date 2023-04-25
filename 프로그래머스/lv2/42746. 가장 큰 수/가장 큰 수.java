import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] sArr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            sArr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(sArr, (o1, o2) -> {
            return -(o1 + o2).compareTo(o2 + o1);
        });
            
        for(int i = 0; i < numbers.length; i++){
            answer += sArr[i];
        }
        
        if(answer.charAt(0) == '0'){
            return "0";
        }
        
        return answer;
    }
}