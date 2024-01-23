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

class Node {
	int vertex;
	Node link;
	
	public Node(int vertex, Node link) {
		super();
		this.vertex = vertex;
		this.link = link;
	}
	
	@Override
	public String toString() {
		return this.vertex + " " + "link : " + this.link;
	}
}

public class Main {
	static int N, K, W;
	static Node[] adjList;
	static int[] inDegree, timeTable, maxTable;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int tCase = Integer.parseInt(in.readLine());
    	
    	for(int t = 0; t < tCase; t++) {
    		st = new StringTokenizer(in.readLine());
        	
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	
        	adjList = new Node[N + 1];
        	inDegree = new int[N + 1];
        	timeTable = new int[N + 1];
        	maxTable = new int[N + 1];
        	
        	st = new StringTokenizer(in.readLine());
        	
        	for(int i = 1; i <= N; i++) {
        		int num = Integer.parseInt(st.nextToken());
        		timeTable[i] = num;
        		maxTable[i] = num;
        	}
        	
        	int from, to;
        	
        	for(int i = 0; i < K; i++) {
        		st = new StringTokenizer(in.readLine());
        		

        		from = Integer.parseInt(st.nextToken());
        		to = Integer.parseInt(st.nextToken());
    			adjList[from] = new Node(to, adjList[from]);
        		inDegree[to]++;
        	}
        	
        	W = Integer.parseInt(in.readLine());
        	
        	System.out.println(topologySort());
    	}
   
    	
    	
	}
	
	static int topologySort() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(W == cur) {
				return maxTable[cur];
			}
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
				
				maxTable[temp.vertex] = Math.max(maxTable[temp.vertex], timeTable[temp.vertex] + maxTable[cur]);
				
				if(--inDegree[temp.vertex] == 0) {
					queue.offer(temp.vertex);
				}
			}
		}
		
		return 0;
	}
}