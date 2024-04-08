import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int target;
	int weight;
	
	public Node(int target, int weight) {
		this.target = target;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return this.target + " " + this.weight;
	}
}

public class Main {
	private static int N, Q;
	private static List<Node>[] matrix;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		matrix = new ArrayList[N + 1];
		
		for(int i = 0; i <= N; i++) {
			matrix[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			matrix[p].add(new Node(q, r));
			matrix[q].add(new Node(p, r));
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(in.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int[] minArr = bfs(v);
			int result = check(minArr, v, k);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int check(int[] minArr, int start, int k) {
		
		int result = 0;
		
		for(int i = 0; i < minArr.length; i++) {
			if(start == i) continue;
			
			if(k <= minArr[i] && minArr[i] != Integer.MAX_VALUE) {
				result++;
			}
		}
		
		return result;
	}
	
	static int[] bfs(int start) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];
		int[] minArr = new int[N + 1]; 
		
		Arrays.fill(minArr, Integer.MAX_VALUE);
		visit[start] = true;
		queue.offer(new Node(start, Integer.MAX_VALUE));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(Node next : matrix[cur.target]) {
				if(!visit[next.target]) {
                    int nextWeight = Math.min(cur.weight, next.weight);
                    
                    if (nextWeight > minArr[next.target]) continue; // 이미 더 큰 가중치로 방문한 경우 스킵
                    
                    minArr[next.target] = nextWeight;
                    queue.offer(new Node(next.target, nextWeight));
                    visit[next.target] = true;
                }
			}
		}
		
		return minArr;
		
	}
}