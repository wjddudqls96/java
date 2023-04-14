import java.util.*;

class Truck{
    int weight;
    int time;
    
    public Truck(int weight, int time){
        this.weight = weight;
        this.time = time;
    }
    
    @Override
    public String toString(){
        return weight + " " + time;
    }
}

class Solution {
    static Queue<Truck> bridge;
    static List<Truck> onLoad;
    static int startIndex, w;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        bridge = new ArrayDeque<>();
        onLoad = new ArrayList<>();
        
        int cnt = 0;
        while(true){
            if(bridge.isEmpty() && startIndex == truck_weights.length) break;
            
            // 1. 다리를 지날 수 있는지 확인하고 옮긴다.
            while(!bridge.isEmpty() && bridge.peek().time == 0){
                Truck t = bridge.poll();
                w -= t.weight;
                onLoad.add(t);
            }
            // 2. 트럭을 다리에 올릴 수 있는지 확인하고 옮긴다.
            onBridge(truck_weights, weight, bridge_length);
            // 3. 트럭의 시간을 1 줄인다.
            for(Truck t : bridge){
                t.time--;
            }
            cnt++;
        }
        
       answer = cnt;
        
        return answer;
    }
    
    static void onBridge(int[] truck_weights, int weight, int bridge_length){
        if(startIndex == truck_weights.length) return;
        
        int tweight = truck_weights[startIndex];
        
        if(!isPossibleOnBridge(tweight, weight)) return;  
        
        Truck t = new Truck(tweight, bridge_length);
        bridge.offer(t);
        w += tweight;
        startIndex += 1;
    }
    
    // 다리에 올릴 수 있는지 확인해야된다.
    static boolean isPossibleOnBridge(int tweight, int weight){
        if(tweight + w <= weight){
            return true;
        }
        return false;
    }
}