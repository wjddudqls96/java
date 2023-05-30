import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();

        for(long i = left; i <= right; i++){
            list.add(Math.max((int)(i / n), (int)(i % n)) + 1);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i ++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}