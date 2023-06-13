import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 65; i <= 90; i++){
            map.put(Character.toString((char) i), i - 64);
        }
        
        for(int i = 0; i < msg.length(); i++){
            int printNum = -1;
            boolean isEnd = false;
            // 사전에 없을떄 까지 문자열 찾기.
            for(int j = i; j < msg.length(); j++){
                String str = msg.substring(i, j + 1);
                
                if(!map.containsKey(str)){
                    map.put(str, map.size() + 1);
                    i = j - 1;
                    break;
                }
                else{
                    printNum = map.get(str);
                    
                    if(j == msg.length() - 1){
                        isEnd = true;
                    }
                }
            }
            
            list.add(printNum);
            
            if(isEnd) break;
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}