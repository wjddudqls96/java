import java.util.*;
import java.math.*;

class Job implements Comparable<Job>{
    int start;
    int time;
    
    public Job(int start, int time){
        this.start = start;
        this.time = time;
    }
    
    @Override
    public String toString(){
        return this.start + " " + this.time;
    }
    
    @Override
    public int compareTo(Job o1){
        return this.time - o1.time;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        List<Job> list = new ArrayList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int size = jobs.length;
        
        for(int i = 0; i < size; i++){
            list.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        
        
        Collections.sort(list, (o1, o2) -> o1.start - o2.start);
        
        
        int end = 0;
        int cnt = 0;
        int index = 0;
        int answer = 0;
        
        while(cnt < list.size()){
            while(index < list.size() && list.get(index).start <= end){
                pq.offer(list.get(index++));
            }
            
            // 초기 그게 없음
            if(pq.isEmpty()){
                end = list.get(cnt).start;
            }
            else{
                Job job = pq.poll();
                cnt++;
                answer += job.time + end - job.start;
                end += job.time;
            }
        }
        
        
        return (int) Math.floor(answer / size);
    }
}