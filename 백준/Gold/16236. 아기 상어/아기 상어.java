import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int distance;
	
	Pos(int x, int y, int distance){
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + ", distance=" + distance + "]";
	}
	
	public int compareTo(Pos o1) {
		if(this.distance == o1.distance) {
			if(this.y == o1.y) {
				return this.x - o1.x;
			}
			else {
				return this.y - o1.y;
			}
		}
		else {
			return this.distance - o1.distance;
		}
	}
	
	
}
public class Main {
	static int N, size, result, sX, sY;
	static int[][] map;
	static boolean[][] visited;
	static List<Pos> possibleList;
	static int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        
        size = 2;
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine());
        	for(int j = 0; j < N; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		if(num == 9) {
        			sX = j;
        			sY = i;
        		}
        		map[i][j] = num; 
        	}
        }
        
        int startX = sX;
        int startY = sY;
        int cnt = 0;
        possibleList = new ArrayList<Pos>();
        possibleList.add(new Pos(startX, startY, 0));
        
        while(!possibleList.isEmpty()) {
        	visited = new boolean[N][N];
        	int x = possibleList.get(0).x;
        	int y = possibleList.get(0).y;
        	result += possibleList.get(0).distance;
        	map[y][x] = -1;
        	
        	if(startX != x || startY != y) {
        		cnt++;
            	if(cnt == size) {
            		size++;
            		cnt = 0;
            	}
        	}
        	
        	possibleList = new ArrayList<Pos>();
        	bfs(x, y);
        	Collections.sort(possibleList);
        }
        
        
        System.out.println(result);
    }
	
	static void bfs(int startX, int startY) {
		Queue<Pos> queue = new LinkedList<Pos>();
		possibleList = new ArrayList<Pos>();
		queue.offer(new Pos(startX, startY, 0));
		visited[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = current.x + directions[i][0];
				int nextY = current.y + directions[i][1];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextY][nextX]) {
					if(map[nextY][nextX] < size && map[nextY][nextX] > 0) {
						visited[nextY][nextX] = true;
						possibleList.add(new Pos(nextX, nextY, current.distance + 1));
						queue.offer(new Pos(nextX, nextY, current.distance + 1));
					}
					else if(map[nextY][nextX] <= size){
						visited[nextY][nextX] = true;
						queue.offer(new Pos(nextX, nextY, current.distance + 1));
					}
				}
			}
		}
	}
}