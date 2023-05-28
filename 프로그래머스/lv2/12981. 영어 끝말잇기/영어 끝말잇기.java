import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        char end = '!';
        boolean success = true;
        
        for(int round = 0; round < words.length / n; round++){
            if(!success) break;
            
            for(int i = 0; i < n; i++){
                int index = i + (round * n);
                String word = words[index];
                
                if(set.contains(word) || (end != '!' && word.charAt(0) != end)){
                    answer[0] = i + 1;
                    answer[1] = round + 1;
                    success = false;
                    break;
                }
                
                set.add(word);
                end = word.charAt(word.length() - 1);
            }
        }
        
        if(success){
            answer[0] = 0;
            answer[1] = 0;
        }
        
        return answer;
    }
}