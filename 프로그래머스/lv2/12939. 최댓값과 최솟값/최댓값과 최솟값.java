import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 1. 삽입과 삭제가 logN, 마지막 원소 탐색할 경우 logN -> NlogN + logN
        // 2. 즉 ArrayList를 만든뒤 (1) Collections.sort를 이용하면 NlogN, 첫번째 (1), 마지막 (1) -> NlogN
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        String[] split = s.split(" ");
        
        for(String str : split){
            map.put(Integer.parseInt(str), 0);
        }
        
        answer = map.firstKey() + " " + map.lastKey();
        
        // 즉 데이터가 하나 들어오고 정렬하고 또 들어오고 정렬하는 방식은 TreeMap 그렇지 않은 경우는 sort함수 사용해서 풀이!
        return answer;
    }
}