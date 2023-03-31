import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M, total;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Pos> cheese = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 1) {
					total++;
				}
			}
		}
		
		
		int temp = total;
		int cnt = 0;
		while(true) {
			cnt++;
			bfs();
			
			while(!cheese.isEmpty()) {
				Pos pos = cheese.poll();
				map[pos.y][pos.x] = 0;
				total--;
			}
			
			
			
			if(total == 0) {
				System.out.println(cnt);
				System.out.println(temp);
				break;
			}
			temp = total;
		}
		
	}
	
	static void bfs() {
		int[][] directions = {{1,0},{-1,0},{0, 1},{0, -1}};
		Queue<Pos> queue = new ArrayDeque<>();
		visited = new boolean[N][M];
		
		queue.add(new Pos(0, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + directions[i][0];
				int nextY = cur.y + directions[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(visited[nextY][nextX]) continue;
				
				if(map[nextY][nextX] == 1) {
					visited[nextY][nextX] = true;
					cheese.offer(new Pos(nextX, nextY));
					continue;
				}
				
				visited[nextY][nextX] = true;
				queue.offer(new Pos(nextX, nextY));
			}
		}
	}
	
}