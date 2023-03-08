import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
	int num;
	int distance;
	
	public Node(int num, int distance) {
		super();
		this.num = num;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Node [num=" + num + ", distance=" + distance + "]";
	}
	
}

public class Main {
	static int V, max, NodeCnt;
	static ArrayList<ArrayList<Node>> adjList;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		V = Integer.parseInt(in.readLine().trim());
		
		adjList = new ArrayList<>();
		
		for(int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int v = 0; v < V; v++) {
			st = new StringTokenizer(in.readLine().trim());
			int vertex = Integer.parseInt(st.nextToken());

			int to = -1;
			while((to = Integer.parseInt(st.nextToken())) != -1) {
				int distance = Integer.parseInt(st.nextToken());
				
				adjList.get(vertex).add(new Node(to, distance));
			}
		}
	
		max = Integer.MIN_VALUE;
		
		visited = new boolean[V + 1];
		dfs(1, 0);
		
		visited = new boolean[V + 1];
		dfs(NodeCnt, 0);
		
		System.out.println(max);
	}
	
	static void dfs(int num, int distance) {
		
		
		if(max < distance) {
			max = distance;
			NodeCnt = num;
		}
		
		ArrayList<Node> list = adjList.get(num);
		visited[num] = true;
		
		for(int i = 0; i < list.size(); i++) {
			Node next = list.get(i);
			
			if(visited[next.num]) continue;
			
			visited[next.num] = true;
			dfs(next.num, distance + next.distance);
			visited[next.num] = false;
		}
	}
}