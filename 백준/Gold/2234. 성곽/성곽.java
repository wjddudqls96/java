import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int x;
	int y;
	boolean isCrash;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] map;
	static boolean[][][] wall;
	static boolean[][] visited;
	static int max, maxLarge = Integer.MIN_VALUE;
	static int N,M;
	static int room[] = new int[2550];
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] split = in.readLine().split(" ");
    	N = Integer.parseInt(split[1]);
    	M = Integer.parseInt(split[0]);
    	
    	map = new int[N][M];
    	visited = new boolean[N][M];
    	wall = new boolean[N][M][4];
    	
    	for(int i = 0; i < N; i++) {
    		String[] line = in.readLine().split(" ");
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(line[j]);
    			
    			for (int k = 3; k >= 0; k--) {
					if ((map[i][j] & 1 << k) >= 1)
						wall[i][j][k] = true;
				}
    		}
    	}
    	
    	int count = 1;
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(!visited[i][j]) {
    				check(j, i, count);
    				count++;
    			}
    		}
    	}
    	
    	visited = new boolean[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(!visited[i][j]) {
    				bfs(j, i);
    			}
    		}
    	}
    	
    	System.out.println(count - 1);
    	System.out.println(max);
    	System.out.println(maxLarge);
    }
    
    static void bfs(int x, int y) {
    	int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(new Node(x, y));
    	visited[y][x] = true;
    	
    	while(!queue.isEmpty()) {
    		Node current = queue.poll();
    		for(int i = 0; i < 4; i++) {
    			int nextX = current.x + directions[i][0];
    			int nextY = current.y + directions[i][1];
    			
    			if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !visited[nextY][nextX] && map[current.y][current.x] != map[nextY][nextX]) {
    				if(maxLarge < room[map[nextY][nextX]] + room[map[current.y][current.x]]) {
    					maxLarge = room[map[nextY][nextX]] + room[map[current.y][current.x]];
    				}
    			}
    		}
    	}
    }
    
    static void check(int x, int y, int count) {	
    	int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(new Node(x, y));
    	visited[y][x] = true;
    	map[y][x] = count;
    	int cnt = 0;
    	while(!queue.isEmpty()) {
    		Node current = queue.poll();
    		cnt++;
    		for(int i = 0; i < 4; i++) {
    			int nextX = current.x + directions[i][0];
    			int nextY = current.y + directions[i][1];
    			
    			if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !visited[nextY][nextX]) {
    				if(!wall[current.y][current.x][i]) {
    					queue.add(new Node(nextX, nextY));
    					visited[nextY][nextX] = true;
    					map[nextY][nextX] = count;
    				}
    			}
    		}
    	}
    	
    	if(max < cnt) {
    		max = cnt;
    	}
    	room[count] = cnt;
    }
}
