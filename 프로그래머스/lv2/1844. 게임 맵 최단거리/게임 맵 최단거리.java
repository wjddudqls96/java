import java.util.*;

class Pos {
    int x;
    int y;
    int count;
    
    public Pos(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    int N, M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        
        Pos pos = bfs(0, 0, visited, maps);
        
        return pos.count;
    }
    
    
    public Pos bfs(int startX, int startY, boolean[][] visited, int[][] maps){
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Pos> queue = new ArrayDeque();
        queue.offer(new Pos(startX, startY, 1));
        visited[startY][startX] = true;
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            
            if(cur.x == M - 1 && cur.y == N - 1){
                return cur;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = cur.x + direction[i][0];
                int nextY = cur.y + direction[i][1];
                
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                
                if(visited[nextY][nextX]) continue;
                
                if(maps[nextY][nextX] == 0) continue;
                
                visited[nextY][nextX] = true;
                queue.offer(new Pos(nextX, nextY, cur.count + 1));
            }
        }
        
        return new Pos(-1, -1, -1);
    }
}