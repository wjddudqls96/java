import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while(true){
            
            if(pq.size() == 1){
                if(pq.peek() < K){
                    return -1;
                }
            }
            
            if(pq.peek() >= K) break;
            
            int sum = pq.poll() + (pq.poll() * 2);
            pq.offer(sum);
            cnt++;
        }
        return cnt;
    }
}