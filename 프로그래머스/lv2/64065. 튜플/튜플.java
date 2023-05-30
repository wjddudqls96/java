import java.util.*;

class Num implements Comparable<Num>{
    int num;
    int count;
    
    Num(int num, int count){
        this.num = num;
        this.count = count;
    }
    
    @Override
    public int compareTo(Num o1){
        return o1.count - this.count;
    }
}

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Num> pq = new PriorityQueue<>();
        
        
        s = s.replaceAll("[{}]", "");
        String[] split = s.split(",");
        
        for(String str : split){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for(String key : map.keySet()){
            pq.offer(new Num(Integer.parseInt(key), map.get(key)));
        }
        
        int[] answer = new int[pq.size()];
        
        int index = 0;
        while(!pq.isEmpty()){
            answer[index++] = pq.poll().num;
        }
        
        return answer;
    }
}