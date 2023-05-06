import java.util.*;

class Pos {
    int x;
    int count;
    
    Pos(int x, int count){
        this.x = x;
        this.count = count;
    }
}
class Solution {
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }
    
    static int bfs(int x, int y, int n){
        int[] directions = {n, 2, 3};
        Queue<Pos> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        
        queue.offer(new Pos(x, 0));
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            
            if(cur.x == y){
                return cur.count;
            }
            
            for(int i = 0; i < 3; i++){
                int next = cur.x;
                if(i == 0){
                    next += directions[i];
                }
                else{
                    next *= directions[i];
                }
                 
                
                if(next > y) continue;
                
                if(set.contains(next)) continue;
                
                queue.offer(new Pos(next, cur.count + 1));
                set.add(next);
            }
        }
        
        return -1;
    }
}