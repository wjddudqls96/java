import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int x;
	int y;
	int count;
	
	Node(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Main {
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int count = 1;
	static int min = Integer.MAX_VALUE;
	static int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(in.readLine());
    	map = new int[N][N];
    	visited = new boolean[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		String[] split = in.readLine().split(" ");
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(split[j]);
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			landMaker(j, i);
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] > 0) {
    				visited = new boolean[N][N];
    				bfs(j, i);
    			}
    		}
    	}
    	
    	System.out.println(min);

    }   
    
    static void landMaker(int x, int y) {
    	Queue<Node> queue = new LinkedList<>();
    	
    	if(!visited[y][x] && map[y][x] != 0) {
    		queue.add(new Node(x, y, 0));
    		visited[y][x] = true;
    		map[y][x] = count;
    		
    		while(!queue.isEmpty()) {
    			Node current = queue.poll();
    			for(int i = 0; i < 4; i++) {
    				int nextX = current.x + direction[i][0];
    				int nextY = current.y + direction[i][1];
    				
    				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextY][nextX]) {
    					if(map[nextY][nextX] != 0) {
    						queue.add(new Node(nextX, nextY, 0));
    						visited[nextY][nextX] = true;
    						map[nextY][nextX] = count;
    					}
    				}
    			}
    		}
    		count++;
    	}
    }
    
    static void bfs(int x, int y) {
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(new Node(x, y, 0));
    	int landNum = map[y][x];
    	visited[y][x] = true;
    	
    	while(!queue.isEmpty()) {
    		Node current = queue.poll();
    		for(int i = 0; i < 4; i++) {
				int nextX = current.x + direction[i][0];
				int nextY = current.y + direction[i][1];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextY][nextX] && map[nextY][nextX] != landNum) {
					visited[nextY][nextX] = true;
					if(map[nextY][nextX] == 0) {
						queue.add(new Node(nextX, nextY, current.count + 1));
					}
					else {
						if(min > current.count) {
							min = current.count;
						}
					}
				}
			
			}
    	}
    }
}