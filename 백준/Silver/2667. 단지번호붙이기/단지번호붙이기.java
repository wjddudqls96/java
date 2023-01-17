import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
class Pos{
	int x;
	int y;
	int num;
	
	public Pos(int x, int y, int num) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Main {
	static Pos[][] map;
    static boolean[][] visited;
    static int N;
    static int count;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new Pos[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
        	String line = in.readLine();
        	for(int j = 0; j < N; j++) {
        		int num = line.charAt(j) - '0';
        		map[i][j] = new Pos(j, i, num);
        	}
        }
        
        count = 0;
        list = new ArrayList<>();
        bfs();
        System.out.println(count);
        Collections.sort(list);
        for(int num : list) {
        	System.out.println(num);
        }
        
    }

    static void bfs() {
    	int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    	Queue<Pos> queue = new LinkedList<>();
    	
    	for(int y = 0; y < N; y++) {
    		for(int x = 0; x < N; x++) {
    			if(map[y][x].num == 1 && !visited[y][x]) {
    				int cnt = 1;
    				queue.add(map[y][x]);
    				visited[y][x] = true;
    				count++;
    				while(!queue.isEmpty()) {
    					Pos pos = queue.poll();
    					
    					for(int i = 0; i < 4; i++) {
    						int nextX = pos.x + direction[i][0];
    						int nextY = pos.y + direction[i][1];
    						
    						if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextY][nextX] || map[nextY][nextX].num != 1) continue;
    						
    						cnt++;
    						visited[nextY][nextX] = true;
    						queue.add(map[nextY][nextX]);
    					}
    				}
    				list.add(cnt);
    			}
    		}
    	}
    }
}
