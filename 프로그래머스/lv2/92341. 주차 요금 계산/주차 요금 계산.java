import java.util.*;

class Car implements Comparable<Car>{
    int num;
    int pay;
    
    public Car(int num, int pay){
        this.num = num;
        this.pay = pay;
    }
    
    @Override
    public int compareTo(Car o1){
        return this.num - o1.num;
    }
    
    @Override
    public String toString(){
        return this.num + " " + this.pay;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> rMap = new HashMap<>();
        
        for(String record : records){
            String[] split = record.split(" ");
            String[] times = split[0].split(":");
            int hour = Integer.parseInt(times[0]);
            int minute = Integer.parseInt(times[1]);
            
            if(split[2].equals("IN")){
                rMap.put(split[1], hour * 60 + minute);
            }
            else{
                int startTime = rMap.get(split[1]);
                int differ = (hour * 60 + minute) - startTime;
                map.put(split[1], map.getOrDefault(split[1], 0) + differ);
                rMap.remove(split[1]);
            }
        }
        
        for(String key : rMap.keySet()){
            int end = (23 * 60) + 59;
            map.put(key, map.getOrDefault(key, 0) + end - rMap.get(key));
        }
        
        System.out.println(map);
        
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        for(String key : map.keySet()){
            int pay = 0;
             if(map.get(key) > fees[0]){
                pay = fees[1] + (int) Math.ceil((map.get(key) - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                pay = fees[1];
            }
            
            pq.offer(new Car(Integer.parseInt(key), pay));
        }
        
        
        
        int[] answer = new int[pq.size()];
        int index = 0;
        
        while(!pq.isEmpty()){
            answer[index++] = pq.poll().pay;
        }
        
        return answer;
    }
}