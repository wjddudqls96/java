import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int index;
	int weight;
	
	public Node(int index, int weight) {
		super();
		this.index = index;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [index=" + index + ", weight=" + weight + "]";
	}
}

public class Main {
	static int V, E;
	static ArrayList<ArrayList<Node>> matrix;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		matrix = new ArrayList<>();
		
		st = new StringTokenizer(in.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		int start = Integer.parseInt(in.readLine());
		
		for(int i = 0; i <= V; i++) {
			matrix.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			matrix.get(u).add(new Node(v, w));
		}

		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V + 1]; // 출발정점에서 자신까지 오는 최소 비용.
		boolean[] visited = new boolean[V + 1]; // 경우지로 고려된 정점여부

		Arrays.fill(distance, INF); // 최소값이 갱신 로직을 반영해야하므로 큰값으로 초기화
		distance[start] = 0;
		
		int min, current;
		for(int c = 1; c <= V; c++) {
			// step 1 : 경우지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = -1;
			min = INF;
			
			for(int i = 1; i <= V; i++) {
				if(!visited[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			
			if(current == -1) break;
			
			visited[current] = true;
			
			// step 2 :  위에서 선택된 정점을 경유지로 해서 갈수 있는 다른 미방문 인접정점과의 비용 최소값 갱신
			
			
			for(Node node : matrix.get(current)) {
				int index = node.index;
				if(!visited[index] && node.weight != 0 && distance[index] > min + node.weight) {
					distance[index] = min + node.weight;
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == INF) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(distance[i]).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	
}