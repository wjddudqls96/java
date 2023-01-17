import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Pos{
    int x;
    int y;
    char c;

    public Pos(int x, int y, char c) {
        super();
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

public class Main {
    static Pos[][] graphNomal;
    static Pos[][] graphUnNomal;
    static boolean[][] visited;
    static int N;
    static int result;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        graphNomal = new Pos[N][N];
        graphUnNomal = new Pos[N][N];
        visited = new boolean[N][N];

        // 두 그래프 완성
        for(int i = 0; i < N; i++) {
            String line = in.readLine();
            for(int j = 0; j < N; j++) {
                graphNomal[i][j] = new Pos(j, i, line.charAt(j));
                if(line.charAt(j) == 'R') {
                    graphUnNomal[i][j] = new Pos(j, i, 'G');
                }else {
                    graphUnNomal[i][j] = new Pos(j, i, line.charAt(j));
                }
            }
        }
        result = 0;
        // BFS 시작
        bfs(graphNomal,'R');
        bfs(graphNomal,'B');
        bfs(graphNomal,'G');
        System.out.print(result + " ");
        
        result = 0;
        for(int i = 0; i < visited.length; i++) {
        	Arrays.fill(visited[i], false);
        }
        
        
        bfs(graphUnNomal,'G');
        bfs(graphUnNomal,'B');
        System.out.print(result);
    }

    static void bfs(Pos[][] graph, char color) {
    	Queue<Pos> queue = new LinkedList<>();
        int[][] direction = {{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(graph[y][x].c == color && !visited[y][x]) {
                	visited[y][x] = true;
                	result++;
                	queue.add(graph[y][x]);
                	while(!queue.isEmpty()) {
                		Pos pos = queue.poll();
                		for(int i = 0; i < 4; i++) {
                    		int nextX = pos.x + direction[i][0];
                    		int nextY = pos.y + direction[i][1];
                    		
                    		if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextY][nextX] || graph[nextY][nextX].c != color) continue;
                    		
                    		visited[nextY][nextX] = true;
                    		queue.add(graph[nextY][nextX]);
                    	}
                	}
                	
                }
            }
        }
    }
}
