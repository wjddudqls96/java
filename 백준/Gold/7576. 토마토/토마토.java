import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
    int x;
    int y;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] map, count;
    // 1 방문, 2 방문x, -1 없음
    static boolean[][] visited;
    static ArrayList<Pos> startPosList;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] split = in.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        visited = new boolean[M][N];
        startPosList = new ArrayList<>();
        count = new int[M][N];

        for(int i = 0; i < M; i++) {
            String[] line = in.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                if(line[j].equals("1")) {
                    visited[i][j] = true;
                    startPosList.add(new Pos(j,i));
                }
                else if(line[j].equals("-1")) {
                    visited[i][j] = true;
                    count[i][j] = -1;
                }
            }
        }

        bfs();

        for(Pos start : startPosList) {
            count[start.y][start.x] = -1;
        }

        int max = Integer.MIN_VALUE;
        boolean flag = false;
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(count[i][j] == 0) {
                    flag = true;
                }
                if(max < count[i][j]) {
                    max = count[i][j];
                }
            }
        }

        if(flag && max != -1) {
            System.out.println(-1);
        }
        else if(max == -1) {
        	System.out.println(0);
        }
        else {
        	System.out.println(max);
        }


    }

    static void bfs() {
        int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<Pos> queue = new LinkedList<Pos>();

        for(Pos start : startPosList) {
            count[start.y][start.x] = 0;
            queue.add(start);
        }

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = pos.x + direction[i][0];
                int nextY = pos.y + direction[i][1];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextY][nextX]) {
                    count[nextY][nextX] = count[pos.y][pos.x] + 1;
                    visited[nextY][nextX] = true;
                    queue.add(new Pos(nextX, nextY));
                }
            }
        }


    }
}