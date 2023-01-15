package solution_D4_supplyRoad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Land implements Comparable<Land>{
	int num;
	int x;
	int y;
	
	Land(int num, int x, int y){
		this.num = num;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Land land) {
		if(this.num < land.num) {
			return -1;
		}
		else if(land.num < this.num) {
			return 1;
		}
		return 0;
	}
}

public class Solution {
	static int min;
	static int[][] dp;
	static PriorityQueue<Land> pq;
	static int N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/solution_D4_supplyRoad/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine());
			Land[][] map = new Land[N][N];
			dp = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = in.readLine();
				for(int j = 0; j < N; j++) {
					int num = line.charAt(j) - '0';
					map[i][j] = new Land(num, j, i);
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			pq = new PriorityQueue<>();
			dp[0][0] = 0;
			
			dijkstra(map, 0, 0);
			
			sb.append("#" + testCase + " " + dp[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra(Land[][] map, int x, int y) {
		int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
		pq.add(map[y][x]);
		
		while(!pq.isEmpty()) {
			Land currentLand = pq.poll();
			if(currentLand.num > dp[currentLand.y][currentLand.x]) continue;
			
			for(int i = 0; i < 4; i++) {
				int nextX = currentLand.x + direction[i][0];
				int nextY = currentLand.y + direction[i][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
				
				int nextNum = currentLand.num + map[nextY][nextX].num;
				if(dp[nextY][nextX] > dp[currentLand.y][currentLand.x] + map[nextY][nextX].num) {
					dp[nextY][nextX] = dp[currentLand.y][currentLand.x] + map[nextY][nextX].num;
					pq.add(map[nextY][nextX]);
				}
			}
		}
	}
}
