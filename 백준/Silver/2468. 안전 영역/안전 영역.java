import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
	int x;
	int y;
	int deep;
	
	Pos(int x, int y, int deep){
		this.x = x;
		this.y = y;
		this.deep = deep;
	}
}


public class Main {
	static int N;
	static Pos[][] map;
	static boolean[][] visited;
	static boolean[][] drowned;
	static int count;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new Pos[N][N];
		
		int maxDeep = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				if(maxDeep < Integer.parseInt(split[j])) {
					maxDeep = Integer.parseInt(split[j]);
				}
				map[i][j] = new Pos(j, i, Integer.parseInt(split[j]));
			}
		}
		max = Integer.MIN_VALUE;
		count = 0;
		// bfs or 물에잠기는 함수
		for(int i = 0; i <= maxDeep; i++) {
			visited = new boolean[N][N];
			drowned = new boolean[N][N];
			drown(i);
			bfs();
			if(max < count) {
				max = count;
			}
			count = 0;
		}
		
		System.out.println(max);
		
	}
	
	static void drown(int num) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(num >= map[i][j].deep) {
					drowned[i][j] = true;
				}
			}
		}
	}
	
	static void bfs() {
		int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		Queue<Pos> queue = new LinkedList<Pos>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!drowned[i][j] && !visited[i][j]) {
					queue.add(map[i][j]);
					visited[i][j] = true;
					count++;
					while(!queue.isEmpty()) {
						Pos pos = queue.poll();
						for(int r = 0; r < 4; r++) {
							int nextX = pos.x + direction[r][0];
							int nextY = pos.y + direction[r][1];
							
							if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextY][nextX] || drowned[nextY][nextX]) 
								continue;
							
							visited[nextY][nextX] = true;
							queue.add(map[nextY][nextX]);
						}
					}
				}
			}
		}
	}
}
