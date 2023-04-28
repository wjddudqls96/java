import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pickCnt = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        if(pickCnt > map.size()){
            answer = map.size();
        }
        else{
            answer = pickCnt;
        }
        
        return answer;
    }
}