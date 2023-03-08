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
		V = Integer.parseInt(in.readLine());
		E = Integer.parseInt(in.readLine());
		
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
		}
		
		st = new StringTokenizer(in.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
	
		System.out.println(distances[end]);
	}
	
	static void dijkstra(int start) {
		distances = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
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