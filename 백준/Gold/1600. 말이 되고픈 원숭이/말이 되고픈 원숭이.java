import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int x;
	int y;
	int count;
	int k;
	
	Node(int x, int y, int count, int k){
		this.x = x;
		this.y = y;
		this.count = count;
		this.k = k;
	}
}

public class Main {
	static int W;
	static int H;
	static int K;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	
	
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	K = Integer.parseInt(in.readLine());
    	String[] split = in.readLine().split(" ");
    	
    	W = Integer.parseInt(split[0]);
    	H = Integer.parseInt(split[1]);
    	
    	map = new int[H][W];
    	visited = new boolean[H][W][K + 1];
    	
    	for(int i = 0; i < H; i++) {
    		String[] line = in.readLine().split(" ");
    		for(int j = 0; j < W; j++) {
    			map[i][j] = Integer.parseInt(line[j]);
    		}
    	}
    	
    	bfs();
    	
    	if(min == Integer.MAX_VALUE) {
    		System.out.println(-1);
    	}else {
    		System.out.println(min);
    	}
 
    }   
    
    static void bfs() {
    	int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    	int[][] horseDirect = {{-2, -1},{-2, 1},{2, -1},{2, 1},{-1, 2},{1, 2},{1, -2},{-1, -2}};
    	Queue<Node> queue = new LinkedList<>();
    	
    	queue.add(new Node(0, 0, 0, K));
    	visited[0][0][K] = true;
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		if(node.x == W - 1 && node.y == H - 1) {
    			if(min > node.count) {
    				min = node.count;
    			}
    		}
    		
    		// 원숭이
    		for(int i = 0; i < 4; i++) {
    			int nextX = node.x + direction[i][0];
    			int nextY = node.y + direction[i][1];
    			
    			if(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H && !visited[nextY][nextX][node.k] && map[nextY][nextX] == 0) {
    				queue.add(new Node(nextX, nextY, node.count + 1, node.k));
    				visited[nextY][nextX][node.k] = true;
    			}
    		}
    		
    		// 말
    		if(node.k > 0) {
                // i < 4 로해서 틀림 바보짓! 
    			for(int i = 0; i < 8; i++) {
        			int nextX = node.x + horseDirect[i][0];
        			int nextY = node.y + horseDirect[i][1];
        			
        			if(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H && !visited[nextY][nextX][node.k - 1] && map[nextY][nextX] == 0) {
        				queue.add(new Node(nextX, nextY, node.count + 1, node.k - 1));
        				visited[nextY][nextX][node.k - 1] = true;
        			}
        			
        		}
    		}
    		
    	}
    }
}