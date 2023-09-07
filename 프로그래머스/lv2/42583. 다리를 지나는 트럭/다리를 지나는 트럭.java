import java.util.*;

class Truck {
    int weight;
    int time;
    
    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new ArrayDeque<>();
        
        int time = 0;
        int index = 0;
        int bridgeWeight = 0;
        
        while(true){
            if(queue.isEmpty() && truck_weights.length == index) break;
            
            // 1.다리를 지날 수 있다면 지나간다.
            if(!queue.isEmpty() && queue.peek().time == 0){
                Truck truck = queue.poll();
                bridgeWeight -= truck.weight;
            }
            
            // 2. 만약 다리에 올릴 수 있다면. 다리에 올린다.
            if(truck_weights.length > index) {
                int cur = truck_weights[index];
            
                if(bridgeWeight + cur <= weight){
                    queue.offer(new Truck(cur, bridge_length));
                    bridgeWeight += cur;
                    index++;
                }
            }

            // 3. 다리위의 트럭 1 감소
            for(Truck truck : queue){
                truck.time--;
            }
            
            time++;
        }
        
        return time;
    }
}