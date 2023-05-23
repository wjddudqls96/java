import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int count = 1; count <= elements.length; count++){
            for(int i = 0; i < elements.length; i++){
                int sum = 0;
                
                for(int j = i; j < i + count; j++){
                    sum += elements[j % elements.length];
                }
                
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}