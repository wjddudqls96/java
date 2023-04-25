import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int index = 0; index < commands.length; index++){
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            
            List<Integer> list = new ArrayList<>();
            
            for(int t = i - 1; t < j; t++){
                list.add(array[t]);
            }
            
            Collections.sort(list);
            
            answer[index] = list.get(k - 1);
        }
        
        
        return answer;
    }
}