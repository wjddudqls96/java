import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int num;
	int distance;
	
	public Node(int num, int distance) {
		super();
		this.num = num;
		this.distance = distance;
	}
	
	public int compareTo(Node o1) {
		return this.distance - o1.distance;
	}

	@Override
	public String toString() {
		return "Node [num=" + num + ", distance=" + distance + "]";
	}
	
}

public class Main {
	static int V, E, max, NodeCnt;
	static ArrayList<ArrayList<Node>> adjList;
	static int[] distances;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<>();
		for(int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			adjList.get(to).add(new Node(from, distance));
			adjList.get(from).add(new Node(to, distance));
		}
		
		st = new StringTokenizer(in.readLine());
		
		int index1 = Integer.parseInt(st.nextToken());
		int index2 = Integer.parseInt(st.nextToken());
		boolean flag = false;
		boolean flag2 = false;
		
		dijkstra(index1);
		
		int result = 0;
		int result2 = 0;
		
		if(distances[1] == Integer.MAX_VALUE || distances[index2] == Integer.MAX_VALUE) {
			flag = true;
		}
		
		if(distances[V] == Integer.MAX_VALUE) {
			flag2 = true;
		}
		
		result += distances[1];
		result += distances[index2];
		result2 += distances[V];
		
		
		dijkstra(index2);
		
		if(distances[1] == Integer.MAX_VALUE || distances[index1] == Integer.MAX_VALUE) {
			flag2 = true;
		}
		
		if(distances[V] == Integer.MAX_VALUE) {
			flag = true;
		}
		
		result += distances[V];
		result2 += distances[1];
		result2 += distances[index1];
		
	
		
		if(flag && flag2) {
			System.out.println(-1);
		}
		else if(flag) {
			System.out.println(result2);
		}
		else if(flag2) {
			System.out.println(result);
		}
		else {
			System.out.println(Math.min(result, result2));
		}
	}
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[V + 1];
		distances = new int[V + 1];
		
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[start] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(visited[cur.num]) continue;
			
			visited[cur.num] = true;
			
			ArrayList<Node> list = adjList.get(cur.num);
			
			for(Node next : list) {
				if(!visited[next.num] && distances[next.num] > distances[cur.num] + next.distance) {
					distances[next.num] = distances[cur.num] + next.distance;
					queue.offer(new Node(next.num, distances[next.num]));
				}
			}
		}
	}
}