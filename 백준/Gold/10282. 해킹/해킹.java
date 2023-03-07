import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int num;
	int time;
	
	public Node(int num, int time) {
		super();
		this.num = num;
		this.time = time;
	}
	
	public int compareTo(Node o1) {
		return this.time - o1.time;
	}
}

public class Main {
	static int N, D, C, INF = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] distance;
	static ArrayList<ArrayList<Node>> adjList;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine().trim());
        
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(in.readLine());
        	N = Integer.parseInt(st.nextToken());
        	D = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	
        	adjList = new ArrayList<>();
        	
        	for(int i = 0; i <= N; i++) {
        		adjList.add(new ArrayList<>());
        	}
        	
        	for(int i = 0; i < D; i++) {
        		st = new StringTokenizer(in.readLine());
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		int time = Integer.parseInt(st.nextToken());
        		
        		adjList.get(to).add(new Node(from, time));
        	}
        	
        	dijkstra(C);
        	
        	int cnt = 0;
        	int maxTime = Integer.MIN_VALUE;
        	
        	for(int i = 1; i < distance.length; i++) {
        		if(distance[i] != INF) {
        			cnt++;
        			if(maxTime < distance[i]) {
        				maxTime = distance[i];
        			}
        		}
        	}
        	
        	sb.append(cnt + " " + maxTime).append("\n");
        }
        System.out.println(sb);
    }
    
    static void dijkstra(int start) {
    	PriorityQueue<Node> queue = new PriorityQueue<>();
    	visited = new boolean[N + 1];
    	distance = new int[N + 1];
    	Arrays.fill(distance, INF);
    	
    	distance[start] = 0;
    	queue.add(new Node(start, 0));
    	
    	
    	while(!queue.isEmpty()) {
    		Node cur = queue.poll();
    	
    		if(visited[cur.num]) continue;
    		
    		visited[cur.num] = true;
    		for(Node node : adjList.get(cur.num)) {
    			if(!visited[node.num] && distance[node.num] > distance[cur.num] + node.time) {
    				distance[node.num] = distance[cur.num] + node.time;
    				queue.offer(new Node(node.num, distance[node.num]));
    			}
    		}
    	}
    }
}