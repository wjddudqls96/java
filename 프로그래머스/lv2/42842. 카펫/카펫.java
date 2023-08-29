import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        
        for(int i = 3; i < size; i++){
            int j = size / i;
            
            if(size % i == 0 && j >= 3){
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                
                if(yellow == (col - 2) * (row - 2)){
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }
        return answer;
    }
}