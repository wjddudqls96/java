import java.util.*;

class Dev{
    int progress;
    int speed;
    
    public Dev(int progress, int speed){
        this.progress = progress;
        this.speed = speed;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Dev> queue = new ArrayDeque<>();
        int[] results = new int[102];
        
        for(int i = 0; i < progresses.length; i++){
            queue.offer(new Dev(progresses[i], speeds[i]));
        }
        
        int temp = 0;
        while(!queue.isEmpty()){
            Dev dev = queue.poll();
            int p = dev.progress;
            int s = dev.speed;
            int work = 100 - p;
            
            int result = work / s;
            
            if(work % s > 0){
                result++;
            }
            
            if(result < temp){
                result = temp;
            }
            else{
                temp = result;
            }
            
            results[result]++;
        }
        
        for(int i = 0; i < results.length; i++){
            if(results[i] != 0){
                answer.add(results[i]);
            }
        }
        
        
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}