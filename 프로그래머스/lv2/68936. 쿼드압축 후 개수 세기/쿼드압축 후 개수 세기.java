import java.util.*;

class Pos {
    int x;
    int y;
    int size;
    
    Pos(int x , int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
    
    @Override
    public String toString(){
        return this.x + " " + this.y + " " + this.size;
    }
}

class Solution {
    int n;
    public int[] solution(int[][] arr) {
        Queue<Pos> queue = new ArrayDeque<>();
        n = arr.length; // 한 변의 길이
        
        
        queue.offer(new Pos(0, 0, n));
        // 1. start 포인트 찾기
        
        int oneAnswer = 0;
        int zeroAnswer = 0;
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            
            int oneCnt = 0;
            int zeroCnt = 0;
            
            for(int i = cur.y; i < cur.y + cur.size; i++){
                for(int j = cur.x; j < cur.x + cur.size; j++){
                    if(arr[i][j] == 0) zeroCnt++;
                    if(arr[i][j] == 1) oneCnt++;
                }
            }
            
            // System.out.println(zeroCnt + " " + oneCnt);
            
            if(zeroCnt > 0 && oneCnt > 0){
                // 만약 개수가 같지않다면 첫 시작 좌표와 사이즈를 /2로 하여 큐에 다시 집어넣기
                
                if(cur.size == 1) continue;
                
                int nextSize = cur.size / 2;
                
                queue.offer(new Pos(cur.x, cur.y, nextSize));
                queue.offer(new Pos(cur.x + nextSize, cur.y, nextSize));
                queue.offer(new Pos(cur.x, cur.y + nextSize, nextSize));
                queue.offer(new Pos(cur.x + nextSize, cur.y + nextSize, nextSize));
            }
            else if(zeroCnt > 0){
                zeroAnswer++;
            }
            else if(oneCnt > 0){
                oneAnswer++;
            }
        
        }
        
        
        int[] answer = new int[2];
        answer[0] = zeroAnswer;
        answer[1] = oneAnswer;
        
        return answer;
    }
}