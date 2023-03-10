import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M, max;
	static int[][] map, temp;
	static boolean[][] visited;
	static ArrayList<Node> list;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 2) {
					list.add(new Node(j, i));
				}
				map[i][j] = num;
			}
		}
		
		max = Integer.MIN_VALUE;
		combination(0, 0);
		
		System.out.println(max);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == 3) {
			temp = new int[N][M];
			for(int i = 0; i < N; i++) {
				temp[i] = Arrays.copyOf(map[i], map[i].length);
			}
			
			bfs();
			
			int safeCnt = 0;
			for(int[] t : temp) {
				for(int num : t) {
					if(num == 0) {
						safeCnt++;
					}
				}
			}
			
			if(max < safeCnt) {
				max = safeCnt;
			}
			return;
		}
		
		for(int i = start; i < N*M; i++) {
			int nextX = i % M;
			int nextY = i / M;
			
			if(map[nextY][nextX] == 0) {
				map[nextY][nextX] = 1;
				combination(cnt + 1, i + 1);
				map[nextY][nextX] = 0;
			}
		}
	}

	private static void bfs() {
		int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		Queue<Node> queue = new ArrayDeque<Node>();
		visited = new boolean[N][M];
		
		for(int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			visited[node.y][node.x] = true;
			queue.add(node);
		}
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			visited[cur.y][cur.x] = true;
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + directions[i][0];
				int nextY = cur.y + directions[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextY][nextX]) continue;
				
				if(temp[nextY][nextX] == 1) continue;
				
				visited[nextY][nextX] = true;
				temp[nextY][nextX] = 2;
				queue.offer(new Node(nextX, nextY));
			}
		}
	}
}