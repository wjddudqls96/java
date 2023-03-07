import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
}

class Main {
	static int N, M, X, Max;
	static int INF = Integer.MAX_VALUE;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> adjList, reversed;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<>();
		reversed = new ArrayList<>();
		
		for(int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<>());
			reversed.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(new Node(to, distance));
			reversed.get(to).add(new Node(from, distance));
		}
		
		Max = Integer.MIN_VALUE;
		
		
		int[] result1 = test(adjList, X);
		int[] result2 = test(reversed, X);
		
		for(int i = 1; i <= N; i++) {
			if(result2[i] == INF) continue;
			result1[i] += result2[i];
		}
		
		for(int i = 0; i < result1.length; i++) {
			if(result1[i] != INF && Max < result1[i]) {
				Max = result1[i];
			}
		}
		
		System.out.println(Max);
	}
	
	static int[] dijkstra(ArrayList<ArrayList<Node>> temp) {
		distance = new int[N +1];
		Arrays.fill(distance, INF);
		visited = new boolean[N + 1];
		
		distance[X] = 0;
		
		int min, current;
		for(int c = 1; c <= N; c++) {
			current = -1;
			min = INF;
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && min > distance[i]) {
					current = i;
					min = distance[i];
				}
			}
			
			if(current == -1) break;
			
			visited[current] = true;
			
			for(int i = 1; i <= N; i++) {
				ArrayList<Node> list = temp.get(current);
				
				for(Node node : list) {
					if(node.num == i) {
						if(!visited[i] && node.distance != 0 && distance[i] > min + node.distance) {
							distance[i] = min + node.distance;
							break;
						}
					}
				}
			}
		}
		
		return distance;
	}
	
	static int[] test(ArrayList<ArrayList<Node>> temp, int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		
		distance = new int[N +1];
		Arrays.fill(distance, INF);
		visited = new boolean[N + 1];
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int num = cur.num;
			
			if(visited[num]) continue;
			
			visited[num] = true;
			
			for(Node next : temp.get(num)) {
				if(!visited[next.num] && distance[next.num] > distance[num] + next.distance) {
					distance[next.num] = distance[num] + next.distance;
					queue.offer(new Node(next.num, distance[next.num]));
				}
			}
		}
		
		return distance;
	}
}