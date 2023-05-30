import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        
        // 루프를 돌면서 확인
        for(int i = 0; i <= discount.length - 10; i++){
            Map<String, Integer> temp = getNewMap(map);
            boolean flag = true;
            
            for(int j = i; j < i + 10; j++){
                if(temp.containsKey(discount[j])){
                    temp.put(discount[j], temp.get(discount[j]) - 1);
                }
                else{
                    flag = false;
                    break;
                }
            }
            
            if(flag && isZero(temp)){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static boolean isZero(Map<String, Integer> map){
        for(String key : map.keySet()){
            if(map.get(key) != 0) return false;
        }
        return true;
    }
    
    static Map<String, Integer> getNewMap(Map<String, Integer> map){
        Map<String, Integer> newMap = new HashMap<>();
        
         for(String key : map.keySet()){
            newMap.put(key, map.get(key));
        }
        
        return newMap;
    }
}