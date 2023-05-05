import java.util.*;

class Pos implements Comparable<Pos>{
    int x;
    int y;
    int count;
    
    Pos(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
    
    @Override
    public int compareTo(Pos o1){
        return this.count - o1.count;
    }
}

class Solution {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] map;
    static int N, M, startX, startY;
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        
        for(int i = 0; i < N; i++){
            String line = board[i];
            
            for(int j = 0; j < M; j++){
                char c = line.charAt(j);
                
                if(c == 'R'){
                    startX = j;
                    startY = i;
                }
                
                map[i][j] = c;
            }
        }
        
        answer = bfs();
        
        return answer;
    }
    
    static int bfs(){
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        queue.offer(new Pos(startX, startY, 0));
        visited[startY][startX] = true;

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            if(map[cur.y][cur.x] == 'G'){
                return cur.count;
            }

            for(int i = 0; i < 4; i++){
                int[] pos = straight(i, cur.x, cur.y);

                int nextX = pos[0];
                int nextY = pos[1];

                if(visited[nextY][nextX]) continue;

                visited[nextY][nextX] = true;
                queue.offer(new Pos(nextX, nextY, cur.count + 1));
            }
        }

        return -1;
    }

    static int[] straight(int dir, int x, int y){
        int[] pos = new int[2];
        int nextX = x;
        int nextY = y;

        while(true){
            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) break;

            if(map[nextY][nextX] == 'D') break;

            nextX += directions[dir][0];
            nextY += directions[dir][1];
        }

            pos[0] = nextX - directions[dir][0];
            pos[1] = nextY - directions[dir][1];    
            return pos;
        }
    }   

