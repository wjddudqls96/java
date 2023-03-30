import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
	public int compareTo(Pos o) {
		return this.count - o.count;
	}
	
	
}

public class Main {
	static int N, result;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int cnt = 1;
	    while((N = Integer.parseInt(in.readLine())) != 0) {
	    	map = new int[N][N];
	    	
	    	for(int i = 0; i < N; i++) {
	    		st = new StringTokenizer(in.readLine());
	    		for(int j = 0; j < N; j++) {
	    			int num = Integer.parseInt(st.nextToken());
	    			map[i][j] = num;
	    		}
	    	}
	    	
	    	bfs();
	    	System.out.println("Problem " + cnt + ": " + result);
	    	cnt++;
	    }
		
	}
	
	static void bfs() {
		int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		PriorityQueue<Pos> queue = new PriorityQueue<>();
		visited = new boolean[N][N];
		
		visited[0][0] = true;
		queue.offer(new Pos(0, 0, map[0][0]));
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			if(cur.x == N -1 && cur.y == N - 1) {
				result = cur.count;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + directions[i][0];
				int nextY = cur.y + directions[i][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
				
				if(visited[nextY][nextX]) continue;
				
				visited[nextY][nextX] = true;
				queue.offer(new Pos(nextX, nextY, cur.count + map[nextY][nextX]));
			}
		}
		
	}
}