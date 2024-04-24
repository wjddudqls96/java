import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}

public class Main {
    private static int N, M, Min = Integer.MAX_VALUE;
    private static boolean[][] map;
    private static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("./input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        Pos[] coins = new Pos[2];

        int index = 0;
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == '#') {
                    map[i][j] = true;
                } else if (c == 'o') {
                    coins[index++] = new Pos(j, i);
                }
            }
        }
        
        move(coins[0].x, coins[0].y, coins[1].x, coins[1].y, 0);
        System.out.println(Min == Integer.MAX_VALUE ? -1 : Min);
    }

    static void move(int x1, int y1, int x2, int y2, int count) {
    	
//    	System.out.println(count);
    	
        if (count >= 10 || count >= Min) return; 

        for (int[] dir : directions) {
        	
        	int nextX1 = x1 + dir[0];
        	int nextY1 = y1 + dir[1];
        	int nextX2 = x2 + dir[0];
        	int nextY2 = y2 + dir[1];
            
            boolean drop1 = drop(nextX1, nextY1);
            boolean drop2 = drop(nextX2, nextY2);

            if (drop1 && drop2) continue; 

            if (drop1 || drop2) {
                Min = Math.min(Min, count + 1);
                return;
            }

            if (map[nextY1][nextX1]) {
            	nextX1 = x1;
            	nextY1 = y1;
            }
            
            if (map[nextY2][nextX2]) {
            	nextX2 = x2;
            	nextY2 = y2;
            }
            
            move(nextX1, nextY1, nextX2, nextY2, count + 1);
        }
    }

    static boolean drop(int nextX, int nextY) {
        return nextX < 0 || nextY < 0 || nextX >= M || nextY >= N;
    }
}