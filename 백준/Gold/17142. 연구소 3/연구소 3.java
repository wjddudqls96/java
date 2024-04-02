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
	private static int N, M, size, Min;
	private static int[][] map;
	private static boolean[] visit;
	private static ArrayList<Pos> virusList;
	private static int emptyCount = 0;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		virusList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 2) {
					virusList.add(new Pos(j, i, 0));
				}
				else if(num == 0) {
					emptyCount++;
				}
			}
		}
		
		
		Min = Integer.MAX_VALUE;
		size = virusList.size();
		visit = new boolean[size];
		combi(0, 0);
		
		if(Min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else if(emptyCount == 0) {
			System.out.println(0);
		}
		else {
			System.out.println(Min);
		}
		
		
	}
	
	static void combi(int idx, int count) {
		if(count == M) {
			ArrayList<Pos> activeList = new ArrayList<>();
			
			for(int i = 0; i < visit.length; i++) {
				if(visit[i]) {
					activeList.add(virusList.get(i));
				}
			}
			
			// BFS 시작 
			int result = bfs(activeList);
			
			if(result != -1) {
				Min = Math.min(Min, result);
			}
			
			return;
		}
		 
		for(int i = idx; i < size; i++) {
			if(!visit[i]) {
				visit[i] = true;
				combi(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}
	
	
	static int bfs(ArrayList<Pos> activeList) {
		int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};
		boolean[][] visit = new boolean[N][N];
		Queue<Pos> queue = new ArrayDeque<>();
		int spreadCount = 0;
		int max = Integer.MIN_VALUE;
		
		for(Pos active: activeList) {
			visit[active.y][active.x] = true;
			queue.offer(active);
		}
		
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			
			if(map[current.y][current.x] == 0) {
				max = Math.max(max, current.count);
			}
			
			
			for(int i = 0; i < 4; i++) {
				int nextX = current.x + dir[i][0];
				int nextY = current.y + dir[i][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
				
				if(visit[nextY][nextX]) continue;
				
				if(map[nextY][nextX] == 1) continue;
				
				if(map[nextY][nextX] == 0) {
					spreadCount++;
				}
				
				visit[nextY][nextX] = true;
				queue.offer(new Pos(nextX, nextY, current.count + 1));
				
			}
		}
		
		// 검사 시작
		if(spreadCount == emptyCount) {
			return max;
		}
		else {
			return -1;
		}
	}

}