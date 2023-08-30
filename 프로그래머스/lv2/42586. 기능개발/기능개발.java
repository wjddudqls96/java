import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        // 남은 일수 큐에 넣기
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            int mod = remain % speeds[i];
            int result = remain / speeds[i];
            
            if(mod > 0){
                result++;
            }
            
            queue.offer(result);
        }
        
        int max = queue.poll();
        int count = 1;
        
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            if(cur > max){
                max = cur;
                list.add(count);
                count = 1;
            }
            else{
                count++;
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}