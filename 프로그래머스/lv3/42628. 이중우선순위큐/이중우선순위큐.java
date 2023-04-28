import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int size = 0;
        
        for(String op : operations){
            
            if(op.equals("D 1")){
                if(size > 0){
                    int num = pqMax.poll();
                    pqMin.remove(num);
                    size--;
                }
            }
            else if(op.equals("D -1")){
                if(size > 0){
                    int num = pqMin.poll();
                    pqMax.remove(num);
                    size--;
                }
            }
            else{
                String[] split = op.split(" ");
                int num = Integer.parseInt(split[1]);
                pqMin.offer(num);
                pqMax.offer(num);
                size++;
            }
        }
        
        if(size == 0){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        
        return answer;
    }
}