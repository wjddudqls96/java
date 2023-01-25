import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int x;
	int y;
	int count;
	boolean isCrash;
	
	Node(int x, int y, int count, boolean isCrash){
		this.x = x;
		this.y = y;
		this.count = count;
		this.isCrash = isCrash;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] split = in.readLine().split(" ");
    	
    	N = Integer.parseInt(split[0]);
    	M = Integer.parseInt(split[1]);
    	
    	map = new int[N][M];
    	visited = new boolean[N][M][2];
    	
    	for(int i = 0; i < N; i++) {
    		String line = in.readLine();
    		for(int j = 0; j < M; j++) {
    			map[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	bfs();
    	
    	if(N == 1 && M == 1) {
    		System.out.println(1);
    	}
    	else if(min == Integer.MAX_VALUE) {
    		System.out.println(-1);
    	}else {
    		System.out.println(min);
    	}
    }
    
    static void bfs() {
    	int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(new Node(0, 0, 1, false));
    	visited[0][0][0] = true;
    	
    	while(!queue.isEmpty()) {
    		Node current = queue.poll();
    		for(int i = 0; i < 4; i++) {
    			int nextX = current.x + directions[i][0];
    			int nextY = current.y + directions[i][1];
    			
    			// 방문하지 않고 맵에 벗어나지않는 다면.
    			if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
    				if(nextX == M -1 && nextY == N - 1) {
    					
    					if(!visited[nextY][nextX][1] || !visited[nextY][nextX][0]) {
    						int count = current.count + 1;
    						if(min > count) {
    							min = count;
    						}
    					}
    				}
    				
    				// 현재의 노드가 뿌순적이 있고 방문한적 없다면.
    				if(current.isCrash && !visited[nextY][nextX][1]) {
    					if(map[nextY][nextX] == 0) {
    						queue.add(new Node(nextX, nextY, current.count + 1, true));
    						visited[nextY][nextX][1] = true;
    					}
    				}
    				// 뿌순적 없고 방문하지 않았다면.
    				else if(!current.isCrash && !visited[nextY][nextX][0]){
    					// 다음이 1이라면
    					if(map[nextY][nextX] == 1) {
    						queue.add(new Node(nextX, nextY, current.count + 1, true));
    						visited[nextY][nextX][1] = true;
    					}else {
    						queue.add(new Node(nextX, nextY, current.count + 1, false));
    						visited[nextY][nextX][0] = true;
    					}
    				}
    			}
    		}
    	}
    }
}