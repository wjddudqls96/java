import java.util.*;

class Pos {
    int x;
    int y;
    
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String line = maps[i];
            
            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j);
                
                if(c == 'X'){
                    map[i][j] = -1;
                }
                else{
                    map[i][j] = c - '0';
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != -1 && !visited[i][j]){
                    int sum = bfs(j, i);
                    list.add(sum);
                }
            }
        }
        
        if(list.isEmpty()){
            return new int[]{-1};
        }
        else{
            Collections.sort(list);
            
            int[] arr = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                arr[i] = list.get(i);
            }
            
            return arr;
        }
    }
    
    static int bfs(int startX, int startY){
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        int sum = 0;
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(startX, startY));
        visited[startY][startX] = true;
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            sum += map[cur.y][cur.x];
            
            for(int i = 0; i < 4; i++){
                int nextX = cur.x + directions[i][0];
                int nextY = cur.y + directions[i][1];
                
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                
                if(visited[nextY][nextX] || map[nextY][nextX] == -1) continue;
                
                visited[nextY][nextX] = true;
                queue.offer(new Pos(nextX, nextY));
            }
        }
        
        return sum;
    }
}