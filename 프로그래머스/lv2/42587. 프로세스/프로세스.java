import java.util.*;

class Num {
    int value;
    boolean isSelect;
    
    Num(int value, boolean isSelect){
        this.value = value;
        this.isSelect = isSelect;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Num> queue = new ArrayDeque<>();
        int answer = 1;
    
        for(int i = 0; i < priorities.length; i++){
            int prior = priorities[i];
            map.put(prior, map.getOrDefault(prior, 0) + 1);
            
            if(i == location){
                queue.offer(new Num(prior, true));
            }
            else{
                queue.offer(new Num(prior, false));
            }
        }
        
        while(!queue.isEmpty()){
            Num num = queue.poll();
            if(isPossible(num.value, map)){
                if(num.isSelect) break;
                
                map.put(num.value, map.get(num.value) - 1);
                answer++;
            }
            else{
                queue.offer(num);
            }
        }
        return answer;
    }
    
    static boolean isPossible(int num, Map<Integer, Integer> map){
        for(int key : map.keySet()){
            if(key > num && map.get(key) != 0){
                return false;
            }
        }
        
        return true;
    }
}