import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        String[] split = s.split(" ");
        
        for(String str : split){
            map.put(Integer.parseInt(str), 0);
        }
        
        answer = map.firstKey() + " " + map.lastKey();
        return answer;
    }
}