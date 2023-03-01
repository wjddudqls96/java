import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int originTime;
	int time;
	
	Pos(int x, int y, int originTime,int time){
		this.x = x;
		this.y = y;
		this.originTime = originTime;
		this.time = time;
	}
	
	public int compareTo(Pos o) {
		return o.originTime - this.originTime;
	}
}
public class Solution {
	static int R,C, N, M, K, T;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Pos> queue, temp;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			N = R + 2 * K + 4;
			M = C + 2 * K + 4;
			
			map = new int[N][M];
			visited = new boolean[N][M];
			queue = new PriorityQueue<>();
			temp = new ArrayDeque<>();
			
			for(int i = N/2-1; i < N/2-1+R; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = M/2-1; j < M/2-1+C; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num != 0) {
						queue.offer(new Pos(j, i, num, num * 2));
						map[i][j] = num;
						visited[i][j] = true;
					}
				}
			}
			
			bfs();
			
			sb.append("#" + t + " " + queue.size()).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};
		for(int t = 1; t <= K; t++) {
			while(!queue.isEmpty()) {
				Pos current = queue.poll();
				
				current.time -= 1;
				
				if(current.originTime > current.time) {
					for(int i = 0; i < 4; i++) {
						int nextX = current.x + direction[i][0];
						int nextY = current.y + direction[i][1];
						
						if(nextX < 0 || nextX > M || nextY < 0 || nextY > N) continue;
						
						if(!visited[nextY][nextX]) {
							map[nextY][nextX] = current.originTime;
							temp.offer(new Pos(nextX, nextY, current.originTime, current.originTime * 2));
							visited[nextY][nextX] = true;
						}
					}
				}
				if(current.time != 0) {
					temp.offer(new Pos(current.x, current.y, current.originTime, current.time));
				}
			}
			
			while(!temp.isEmpty()) {
				queue.offer(temp.poll());
			}
		}
	}
}