import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.PortableInterceptor.INACTIVE;

class Pos{
	int x;
	int y;
	int count;
	
	Pos(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}
	
	
}

class Solution {
	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					bfs(j,i);
				}
			}
			
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int startX, int startY) {
		int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.offer(new Pos(startX, startY, 0));
		visited[startY][startX] = true;
		int temp = -1;
		int cnt = 0;
		Pos last = null; 
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			last = current;
			// 한바퀴가 끝난다면
			if(temp != current.count) {
				int k = current.count;
				int cost = k * k  + (k - 1) * (k - 1);
				int result = cnt * M - cost;
				if(result >= 0) {
					if(max < cnt) {
						max = cnt;
					}
				}
			}
			
			// 서비스 집이 있다면
			if(map[current.y][current.x] == 1) {
				cnt++;
			}
			
			
			
			temp = current.count;
			
			for(int i = 0; i < 4; i++) {
				int nextX = current.x + directions[i][0];
				int nextY = current.y + directions[i][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextY][nextX]) continue;
				
				visited[nextY][nextX] = true;
				queue.offer(new Pos(nextX, nextY, current.count + 1));
			}
		}
		
		int k = last.count;
		int cost = k * k  + (k - 1) * (k - 1);
		int result = cnt * M - cost;
		if(result >= 0) {
			if(max < cnt) {
				max = cnt;
			}
		}
	}
}