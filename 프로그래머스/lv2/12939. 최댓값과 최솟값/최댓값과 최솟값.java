import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String str : split){
            int num = Integer.parseInt(str);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        answer = map.firstKey() + " " + map.lastKey();
        return answer;
    }
}