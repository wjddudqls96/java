import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node implements Comparable<Node>{
	int end;
	int cost;
	
	public Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o1) {
		return this.cost - o1.cost;
	}
}


public class Main {
	static int V, E;
	static ArrayList<ArrayList<Node>> adjList;
	static int[] distances;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<>();
		
		for(int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList.get(start).add(new Node(end, cost));
			adjList.get(end).add(new Node(start, cost));
		}
		
		dijkstra(1);
		
		System.out.println(distances[V]);
	}
	
	static void dijkstra(int start) {
		distances = new int[V + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		boolean[] visited= new boolean[V + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		distances[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.end]) continue;
			
			visited[cur.end] = true;
			
			for(Node next : adjList.get(cur.end)) {
				if(!visited[next.end] && distances[next.end] > distances[cur.end] + next.cost) {
					distances[next.end] = distances[cur.end] + next.cost;
					pq.offer(new Node(next.end, distances[next.end]));
				}
			}
		}
 	}
}