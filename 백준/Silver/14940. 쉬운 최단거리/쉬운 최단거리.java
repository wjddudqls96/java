import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Pos {
	int x;
	int y;
	int count;
	
	public Pos(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}


public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		int startX = 0;
		int startY = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 2) {
					startX = j;
					startY = i;
				}
				else {
					map[i][j] = num;
				}
			}
		}
		
		visited = new boolean[N][M];
		
		// BFS start
		bfs(startX, startY);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				if(map[i][j] == 1 && !visited[i][j]) {
					map[i][j] = -1;
				}
			}
		}
		
		for(int[] arr : map) {
			for(int num : arr) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs(int startX, int startY) {
		int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		Queue<Pos> queue = new ArrayDeque<>();
		
		visited[startY][startX] = true;
		queue.offer(new Pos(startX, startY, 0));
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + dir[i][0];
				int nextY = cur.y + dir[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(visited[nextY][nextX]) continue;
				
				if(map[nextY][nextX] == 0) continue;
				
				map[nextY][nextX] = cur.count + 1;
				visited[nextY][nextX] = true;
				queue.offer(new Pos(nextX, nextY, cur.count + 1));
			}
		}
	}
}