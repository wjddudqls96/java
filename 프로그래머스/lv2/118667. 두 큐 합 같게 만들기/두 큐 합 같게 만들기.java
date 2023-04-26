import java.util.*;

class Solution {
    static Queue<Integer> q1, q2;
    static long sum1, sum2;
    public int solution(int[] queue1, int[] queue2) {
        // 1. 각 큐의 총합을 저장한다. long 타입으로 저장
        init(queue1, queue2);
        
        // 2. 두개를 비교하면서 크면 작은쪽에 주고 작으면 큰쪽에서 들고온다.
        int cnt = 0;
        
        while(sum1 != sum2){
            if(sum1 > sum2){
                int num = q1.poll();
                q2.offer(num);
                sum1 -= (long) num;
                sum2 += (long) num;
            }
            else if(sum1 < sum2){
                int num = q2.poll();
                q1.offer(num);
                sum2 -= (long) num;
                sum1 += (long) num;
            }
            cnt++;
            
            // 빼고 추가하는 작업이 큐들이 가지고있는 것들 전부 실행하면 -1? 불안하니깐 50 추가
            if(cnt > queue1.length + queue2.length + 50) return -1;
        }
        
        return cnt;
    }
    
    public void init(int[] queue1, int[] queue2){
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++){
            sum1 += (long) queue1[i];
            q1.offer(queue1[i]);
        }
        
        for(int i = 0; i < queue2.length; i++){
            sum2 += (long) queue2[i];
            q2.offer(queue2[i]);
        }
    }
}