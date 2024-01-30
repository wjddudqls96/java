import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M;
	static boolean[][] visit;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count;
		int time = 0;
		while(true) {
			count = 0;
			visit = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					
					if(map[i][j] > 0 && !visit[i][j]) {
						bfs(j, i);
					}
				}
			}
			
			visit = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					
					if(map[i][j] > 0 && !visit[i][j]) {
						check(j, i);
						count++;
					}
				}
			}
			
			time++;
			
			if(count == 0) {
				time = 0;
				break;
			}
			else if(count >= 2) {
				break;
			}
		}
		
		System.out.println(time);
	}
	
	static void check(int startX, int startY) {
		int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		Queue<Node> queue = new ArrayDeque<>();
		
		queue.offer(new Node(startX, startY));
		visit[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + dir[i][0];
				int nextY = cur.y + dir[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(visit[nextY][nextX]) continue;
				
				if(map[nextY][nextX] <= 0) continue;
				
				queue.offer(new Node(nextX, nextY));
				visit[nextY][nextX] = true;
			}
		}
	}
	
	static void bfs(int startX, int startY) {
		int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		Queue<Node> queue = new ArrayDeque<>();
		
		queue.offer(new Node(startX, startY));
		visit[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + dir[i][0];
				int nextY = cur.y + dir[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(visit[nextY][nextX]) continue;
				
				if(map[nextY][nextX] <= 0) {
					map[cur.y][cur.x]--;
				}
				else {
					queue.offer(new Node(nextX, nextY));
					visit[nextY][nextX] = true;
				}
			}
		}
	}
}