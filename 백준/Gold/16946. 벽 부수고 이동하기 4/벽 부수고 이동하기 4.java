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
	static int N, M, cnt;
	static int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	static int[][] map, result;
	static boolean[][] visit;
	static List<Integer> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	result = new int[N][M];
    	visit = new boolean[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		String str = in.readLine();
    		
    		for(int j = 0; j < M; j++) {
    			int num = str.charAt(j) - '0';
    			
    			if(num == 1) {
    				num = -1;
    			}
    			
    			map[i][j] = num;
    		}
    	}
    	
    	list = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(map[i][j] == 0 && !visit[i][j]) {
    				list.add(bfs(j, i));
    				cnt++;
    			}
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			sb.append(getResult(j, i));
    		}
    		sb.append("\n");
    	}
    	
    	
    	System.out.println(sb);
	}
	
	static int getResult(int startX, int startY) {
		int sum = 1;
		HashSet<Integer> set = new HashSet<>();
		
		
		if(map[startY][startX] != -1) {
			return 0;
		}
		
		
		for(int i = 0; i < 4; i++) {
			int nextX = startX + dir[i][0];
			int nextY = startY + dir[i][1];
			
			if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
			
			if(map[nextY][nextX] == -1) continue;
			
			set.add(map[nextY][nextX]);
		}

		for(int num : set) {
			sum += list.get(num);
		}
		
		return sum % 10;
	}
	
	static int bfs(int startX, int startY) {
		Queue<Node> queue = new ArrayDeque<>();
		int count = 1;
		
		visit[startY][startX] = true;
		map[startY][startX] = cnt;
		queue.offer(new Node(startX, startY));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + dir[i][0];
				int nextY = cur.y + dir[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(visit[nextY][nextX]) continue;
				
				if(map[nextY][nextX] != 0) continue;
				
				visit[nextY][nextX] = true;
				map[nextY][nextX] = cnt;
				queue.offer(new Node(nextX, nextY));
				count++;
			}
		}
		
		return count;
	}
}