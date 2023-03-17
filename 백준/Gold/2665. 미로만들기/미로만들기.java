import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int x;
	int y;
	int count;
	
	Node(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
	public int compareTo(Node o1) {
		return this.count - o1.count;
	}
}
public class Main {
	static int N;
	static int[][] matrix;
	static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(in.readLine());
        
        matrix = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	String line = in.readLine();
        	for(int j = 0; j < N; j++) {
        		matrix[i][j] = line.charAt(j) - '0';
        	}
        }
        
        visited = new boolean[N][N];
        bfs();
       
    }
    
    static void bfs() {
    	int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    	PriorityQueue<Node> queue = new PriorityQueue<>();
    	visited[0][0] = true;
    	queue.offer(new Node(0, 0, 0));
    	
    	while(!queue.isEmpty()) {
    		Node current = queue.poll();
    		
    		if(current.x == N - 1 && current.y == N - 1) {
    			System.out.println(current.count);
    		}
    		
    		for(int i = 0; i < 4; i++) {
    			int nextX = current.x + directions[i][0];
    			int nextY = current.y + directions[i][1];
    			
    			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
    			
    			if(visited[nextY][nextX]) continue;
    			
    			visited[nextY][nextX] = true;
    			
    			if(matrix[nextY][nextX] == 0) {
    				queue.offer(new Node(nextX, nextY, current.count + 1));
    			}
    			else if(matrix[nextY][nextX] == 1) {
    				queue.offer(new Node(nextX, nextY, current.count));
    			}
    		}
    	}
    }
}