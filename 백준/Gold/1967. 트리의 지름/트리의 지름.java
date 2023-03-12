import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int num;
	int weight;
	
	Node(int num, int weight){
		this.num = num;
		this.weight = weight;
	}
}
public class Main {
	static int N, max, maxIndex;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> adjList;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(in.readLine());
        adjList = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
        	adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N -1; i++) {
        	st = new StringTokenizer(in.readLine());
        	
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	adjList.get(from).add(new Node(to, weight));
        	adjList.get(to).add(new Node(from, weight));
        }
        
        max = Integer.MIN_VALUE;
        maxIndex = -1;
        visited = new boolean[N+1];
        
        bfs(1);
        
        max = Integer.MIN_VALUE;
        visited = new boolean[N+1];
        
        bfs(maxIndex);
        
        System.out.println(max);
    }
    
    static void bfs(int start) {
    	Queue<Node> queue = new ArrayDeque<>();
    	visited[start] = true;
    	queue.add(new Node(start, 0));
    	
    	while(!queue.isEmpty()) {
    		Node cur = queue.poll();
    		
    		if(max < cur.weight) {
    			max = cur.weight;
    			maxIndex = cur.num;
    		}
    		
    		ArrayList<Node> list = adjList.get(cur.num);
    		
    		if(list.isEmpty()) continue;
    		
    		for(Node node : list) {
    			int nextNum = node.num;
    			int nextWeight = cur.weight + node.weight;
    			
    			if(visited[nextNum]) continue;
    			
    			queue.add(new Node(nextNum, nextWeight));
    			visited[nextNum] = true;
    		}
    	}
    }
}