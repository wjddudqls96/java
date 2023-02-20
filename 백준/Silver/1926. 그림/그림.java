import java.io.*;
import java.util.*;

class Pos{
        int x;
        int y;
    
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
}

class Main {
    
	static int N,M,count;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    count = 1;
                    bfs(j, i);
                    list.add(count);
                }
            }
        }
        
        System.out.println(list.size());
        if(list.size() == 0){
            System.out.println(0);
        }
        else{
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));
        }
        
    }

    static void bfs(int startX, int startY){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(startX, startY));
        visited[startY][startX] = true;
        
        while(!queue.isEmpty()){
            Pos current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = current.x + directions[i][0];
                int nextY = current.y + directions[i][1];
                
                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !visited[nextY][nextX]){
                    if(map[nextY][nextX] == 1){
                        queue.offer(new Pos(nextX, nextY));
                        visited[nextY][nextX] = true;
                        count++;
                    }
                }
            }
        }
    }
}