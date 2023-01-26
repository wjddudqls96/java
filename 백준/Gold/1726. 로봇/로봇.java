import java.io.*;
import java.util.*;

public class Main {

	static class Robot {
		int x, y, d;

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static int N, M;
	public static Robot start, end;
	public static int[][] map;
	public static boolean[][][] v;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[4][N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			if (i == 0)
				start = new Robot(x, y, d);
			else
				end = new Robot(x, y, d);
		}
		if (isAnswer(start.x, start.y, start.d))
			System.out.println(0);
		else 
			System.out.println(bfs());
	}
	
	
	public static int bfs() {
		Queue<Robot> que = new LinkedList<>();
		que.offer(start);
		v[start.d][start.x][start.y] = true;
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int size = que.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				Robot cur = que.poll();
				for (int i = 1; i <= 3; i++) {
					int nx = cur.x+dx[cur.d]*i;
					int ny = cur.y+dy[cur.d]*i;
					
					if (!isBoundary(nx, ny) || map[nx][ny] == 1) break;
					if (v[cur.d][nx][ny]) continue;
					if (isAnswer(nx, ny, cur.d)) return cnt;
					
					que.offer(new Robot(nx, ny, cur.d));
					v[cur.d][nx][ny] = true;
				}
				for (int i = 0; i < 2; i++) {
					int nd = turn(cur.d, i);
					if (v[nd][cur.x][cur.y]) continue;
					if (isAnswer(cur.x, cur.y, nd)) return cnt;
					
					que.offer(new Robot(cur.x, cur.y, nd));
					v[nd][cur.x][cur.y] = true;
				}
			}
		}
		return cnt;
	}
	
	public static boolean isAnswer(int x, int y, int d) {
		return x == end.x && y == end.y && d == end.d; 
 	}
	
	public static int turn(int d, int order) {		
		switch (d) {
		case 0:
			return (order == 0)? 3:2;
		case 1:
			return (order == 0)? 2:3;
		case 2:
			return (order == 0)? 0:1;
		case 3:
			return (order == 0)? 1:0;
		}
		return 0;
	}
	
	public static boolean isBoundary(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}
}