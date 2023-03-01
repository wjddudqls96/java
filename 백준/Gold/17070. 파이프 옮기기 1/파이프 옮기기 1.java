import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int y, x, type;

	public Pos(int x, int y, int type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}
	
}

class Main {
	static int N, count;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(1, 0);
		
		System.out.println(count);
	}
	
	
	static void bfs(int startX, int startY) {
		int[][] direction = {{1, 0},{0, 1},{1, 1}};
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(startX, startY, 0));
		
		// 0 가로 1 세로 2 대각선
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			if(pos.x == N - 1 && pos.y == N -1) {
				count++;
			}
			
			switch (pos.type) {
				case 0:
					goRight(queue, pos);
					goDegak(queue, pos);
					break;
				case 1:
					goDown(queue, pos);
					goDegak(queue, pos);
					break;
				case 2:
					goRight(queue, pos);
					goDown(queue, pos);
					goDegak(queue, pos);
					break;
			}
		}
	}
	
	static void goRight(Queue<Pos> queue, Pos pos) {
		int nextX = pos.x + 1;
		int nextY = pos.y;
		
		if(!isPossible(nextX, nextY)) return;
		
		if(map[nextY][nextX] != 1) {
			queue.offer(new Pos(nextX, nextY, 0));
		}
	}
	
	static void goDown(Queue<Pos> queue, Pos pos) {
		int nextX = pos.x;
		int nextY = pos.y + 1;
		
		if(!isPossible(nextX, nextY)) return;
		
		if(map[nextY][nextX] != 1) {
			queue.offer(new Pos(nextX, nextY, 1));
		}
	}
	
	static void goDegak(Queue<Pos> queue, Pos pos) {
		int nextX = pos.x + 1;
		int nextY = pos.y + 1;
		
		if(!isPossible(nextX, nextY)) return;
		
		if(map[nextY][nextX] != 1 && map[nextY - 1][nextX] != 1 && map[nextY][nextX - 1] != 1) {
			queue.offer(new Pos(nextX, nextY, 2));
		}
	}
	
	static boolean isPossible(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
}