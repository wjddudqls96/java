package solution_D5_Optimalpath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Coord{
	int x;
	int y;
	
	Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N;
	static Coord company;
	static Coord home;
	static Coord[] house;
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			sb.append("#" + testCase + " ");
			N = Integer.parseInt(in.readLine());
			
			String[] split = in.readLine().split(" ");
			
			company = new Coord(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			home = new Coord(Integer.parseInt(split[2]), Integer.parseInt(split[3]));
			house = new Coord[N];
			
			int houseIdx = 0;
			
			for(int i = 4; i < split.length; i++) {
				house[houseIdx++] = new Coord(Integer.parseInt(split[i]), Integer.parseInt(split[++i]));
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			dfs(0, company, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int visitCount, Coord prevCoord, int distance) {
		
		if(visitCount == N) {
			min(distance + getDistance(prevCoord, home));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(visitCount + 1, house[i], distance + getDistance(prevCoord, house[i]));
				visited[i] = false;
			}
		}
		
	}
	
	static int getDistance(Coord a, Coord b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	static void min(int num) {
		if(min > num){
			min = num;
		}
	}
}
