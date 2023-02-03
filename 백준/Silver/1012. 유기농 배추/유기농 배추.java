import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] map;
	static int N,M;
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(in.readLine());
    	
    	for(int testCase = 0; testCase < T; testCase++) {
    		
    		String[] split = in.readLine().split(" ");
    		N = Integer.parseInt(split[0]);
    		M = Integer.parseInt(split[1]);
    		int K = Integer.parseInt(split[2]);
    		
    		map = new int[M][N];
    		
    		for(int i = 0; i < K; i++) {
    			String[] line = in.readLine().split(" ");
    			int x = Integer.parseInt(line[0]);
    			int y = Integer.parseInt(line[1]);
    			
    			map[y][x] = 1; 
    		}
    				
    		int count = 0;
    		
    		for(int i = 0; i < M; i++) {
    			for(int j = 0; j < N; j++) {
    				if(map[i][j] == 1) {
    					bfs(j,i);
    					count++;
    				}
    			}
    		}
    		
    		System.out.println(count);
    		
    	}
    }

	private static void bfs(int x, int y) {
		int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(x, y));
		map[y][x] = 0;
		
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = current.x + directions[i][0];
				int nextY = current.y + directions[i][1];
				
				if(nextX < N && nextX >= 0 && nextY >= 0 && nextY < M && map[nextY][nextX] == 1) {
					queue.add(new Pos(nextX, nextY));
					map[nextY][nextX] = 0;
				}
			}
		}
	}
}