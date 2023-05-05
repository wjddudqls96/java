import java.util.*;

class Pos{
    int x;
    int y;
    int count;
    
    Pos(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
class Solution {
    static char[][] map;
    static int N, M;
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        int lX = 0, lY = 0;
        
        for(int i = 0; i < N; i++){
            String line = maps[i];
            for(int j = 0; j < M; j++){
                char c = line.charAt(j);
                
                if(c == 'S'){
                    startX = j;
                    startY = i;
                }
                
                if(c == 'E'){
                    endX = j;
                    endY = i;
                }
                
                if(c == 'L'){
                    lX = j;
                    lY = i;
                }
                
                map[i][j] = c;
            }
        }
        
        int result = bfs(startX, startY, lX, lY);
        
        if(result == -1){
            return -1;
        }
        
        answer += result;
        
        result = bfs(lX, lY, endX, endY);
        
        if(result == -1){
            return -1;
        }
        
        answer += result;
        return answer;
    }
    
    static int bfs(int sX, int sY, int eX, int eY){
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        boolean[][] visited = new boolean[N][M];
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(sX, sY, 0));
        visited[sY][sX] = true;
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            
            if(cur.x == eX && cur.y == eY){
                return cur.count;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = cur.x + directions[i][0];
                int nextY = cur.y + directions[i][1];
                
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                if(map[nextY][nextX] == 'X' || visited[nextY][nextX]) continue;
                
                queue.offer(new Pos(nextX, nextY, cur.count + 1));
                visited[nextY][nextX] = true;
            }
        }
        
        return -1;
    }
}