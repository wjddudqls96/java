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
	int num;
	int count;
	
	public Node(int num, int count) {
		this.num = num;
		this.count = count;
	}
}

public class Main {
	static int N, K;
	static int[] parents;
	static final int BORDER = 100001;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parents = new int[BORDER];
		
		int count = bfs(N);
		
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int num = K;
		
		while(num != N) {
			stack.push(parents[num]);
			num = parents[num];
		}
		
		sb.append(count).append("\n");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb);
		
	}
	
	static int bfs(int start) {
		int[][] dir = {{1, 1}, {1, -1}, {2, 0}};
		
		boolean[] visit = new boolean[BORDER];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.num == K) {
				return cur.count;
			}
			
			for(int i = 0; i < 3; i++) {
				int next = (cur.num * dir[i][0]) + dir[i][1];
				
				if(next < 0 || next >= BORDER) continue;
				
				if(visit[next]) continue;
				
				queue.add(new Node(next, cur.count + 1));
				visit[next] = true;
				parents[next] = cur.num;
			}
		}
		
		return -1;
	}
}