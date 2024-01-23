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
	int count;
	int distance;
	
	public Node(int x, int y, int count, int distance) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.distance = distance;
	}
}

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	visit = new boolean[N][M][K + 1];
    	
    	for(int i = 0; i < N; i++) {
    		String str = in.readLine();
    		
    		for(int j = 0; j < M; j++) {
    			map[i][j] = str.charAt(j) - '0';
    		}
    	}
    	
    	System.out.println(bfs());
	}
	
	static int bfs() {
		int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		Queue<Node> queue =  new ArrayDeque<>();
		queue.offer(new Node(0, 0, 0, 1));
		visit[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			
			if(cur.x == M - 1 && cur.y == N - 1) {
				return cur.distance;
			}
			
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + dir[i][0];
				int nextY = cur.y + dir[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(map[nextY][nextX] == 1) {
					if(cur.count == K) continue;
					
					if(visit[nextY][nextX][cur.count + 1]) continue;
					
					queue.offer(new Node(nextX, nextY, cur.count + 1, cur.distance + 1));
					visit[nextY][nextX][cur.count + 1] = true;
				}
				else if(map[nextY][nextX] == 0) {
					
					if(visit[nextY][nextX][cur.count]) continue;
					
					queue.offer(new Node(nextX, nextY, cur.count, cur.distance + 1));
					visit[nextY][nextX][cur.count] = true;
				}
				
				
			}
		}
		
		return -1;
	}
}