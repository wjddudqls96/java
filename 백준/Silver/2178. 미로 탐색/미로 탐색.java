import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
	int x;
	int y;
	int num;
	
	Pos(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}



public class Main {
	static int N;
	static int M;
	static Pos[][] maze;
	static boolean[][] visited;
	static int min;
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	//시간 초과 남 ;;; 
//	static void dfs(int startX, int startY, int range) {
//		//범위 벗어나면 종료
//		if(startX < 0 || startX >= M | startY < 0 || startY >= N || visited[startY][startX] || maze[startY][startX] == 0) {
//			return;
//		}
//		
//		if(maze[startY][startX] == 1) {
//			range++;
//		}
//		
//		if(startX == M -1 && startY == N - 1) {
//			if(min > range) {
//				min = range;
//			}
//			visited[startY][startX] = false;
//			return;
//		}
//		visited[startY][startX] = true;
//		// 동서남북
//		dfs(startX - 1, startY, range);
//		dfs(startX + 1, startY, range);
//		dfs(startX, startY - 1, range);
//		dfs(startX, startY + 1, range);
//		
//		visited[startY][startX] = false;
//		
//	}
	
	static void bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(maze[0][0]);
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = pos.x + direction[i][0];
				int nextY = pos.y + direction[i][1];
				
				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
					continue;
				}
				
				if(visited[nextY][nextX] || maze[nextY][nextX].num == 0) {
					continue;
				}
				
				queue.add(maze[nextY][nextX]);
				maze[nextY][nextX].num = maze[pos.y][pos.x].num + 1;
				visited[nextY][nextX] = true;
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		maze = new Pos[N][M];
		visited = new boolean[N][M];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				int num = line.charAt(j) - '0';
				maze[i][j] = new Pos(j, i, num);
			}
		}
		
		bfs();
		System.out.println(maze[N-1][M-1].num);
	}
}
