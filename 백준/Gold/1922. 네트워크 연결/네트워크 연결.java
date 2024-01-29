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

class Node implements Comparable<Node>{
	int vertex;
	int weight;
	
	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o1) {
		return this.weight - o1.weight;
	}
}

public class Main {
	static int N, M;
	static ArrayList<Node>[] matrix;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		
		matrix = new ArrayList[N + 1];
		
		for(int i = 0; i <= N; i++) {
			matrix[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			matrix[a].add(new Node(b, weight));
			matrix[b].add(new Node(a, weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];
		int result = 0;
		
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visit[cur.vertex]) continue;
			
			result += cur.weight;
			visit[cur.vertex] = true;
			
			for(Node next : matrix[cur.vertex]) {
				
				if(visit[next.vertex]) continue;
				
				pq.offer(new Node(next.vertex, next.weight));
			}
			
		}
		
		System.out.println(result);
	}

	
}