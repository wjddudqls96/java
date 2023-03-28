import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M, Count;
	static int[][] map, count;
	static boolean[][] visited;
	static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<Pos> deleteQueue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					Count++;
				}
				map[i][j] = num;
			}
		}
		
		int time = 0;
		while(true) {
			time++;
			visited = new boolean[N][M];
			count = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(i == 0 || j == 0 || i == N - 1 || j == M - 1) {
						if(!visited[i][j]) {
							bfs(j, i);
						}
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(count[i][j] >= 2) {
						Count--;
						map[i][j] = 0;
					}
				}
			}
			
			if(Count == 0) {
				break;
			}
		}
		
		System.out.println(time);
	}
	
	static void bfs(int startX, int startY) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(startX, startY));
		visited[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + directions[i][0];
				int nextY = cur.y + directions[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(visited[nextY][nextX]) continue;
				
				if(map[nextY][nextX] == 1) {
					count[nextY][nextX]++;
				}
				else {
					queue.offer(new Pos(nextX, nextY));
					visited[nextY][nextX] = true;
				}
			}
		}
	}
}