import java.util.*;

class Pos{
    int x;
    int y;
    int cnt;
    
    Pos(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}


class Solution {
    static int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    static int result = -1;
    public int solution(int[][] maps) {
        bfs(maps);
        return result;
    }
    
    static void bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pos> queue = new ArrayDeque<>();
        
        visited[0][0] = true;
        queue.offer(new Pos(0, 0, 1));
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            
            if(cur.x == m - 1 && cur.y == n - 1){
                result = cur.cnt;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = cur.x + directions[i][0];
                int nextY = cur.y + directions[i][1];
                
                if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
                
                if(maps[nextY][nextX] == 0 || visited[nextY][nextX]) continue;
                
                visited[nextY][nextX] = true;
                queue.offer(new Pos(nextX, nextY, cur.cnt + 1));
            }
        }
    }
}