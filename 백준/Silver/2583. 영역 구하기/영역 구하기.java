import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class Main {
	static int M, N, K;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		M = Integer.parseInt(split[0]);
		N = Integer.parseInt(split[1]);
		K = Integer.parseInt(split[2]);
		
		visited = new boolean[M][N];
		
		for(int k = 0; k < K; k++) {
			String[] line = in.readLine().split(" ");
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);
			
			for(int i = y1; i < y2; i++) {
				for(int j = x1; j < x2; j++) {
					visited[i][j] = true;
				}
			}
		}
		
		int count = 0;
		ArrayList<Integer> sizeList = new ArrayList<>();
		// bfs start
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					sizeList.add(bfs(i, j));
					count++;
				}
			}
		}
		Collections.sort(sizeList);
		System.out.println(count);
		
		for(int size : sizeList) {
			System.out.print(size + " ");
		}
	}
	
	static int bfs(int y, int x) {
		int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<Pos> queue = new LinkedList<>();
		int count = 0;
		
		queue.add(new Pos(x, y));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			int xIndex = pos.x;
			int yIndex = pos.y;
			count++;
			
			for(int i = 0; i <4; i++) {
				int nextX = xIndex + direction[i][0];
				int nextY = yIndex + direction[i][1];
				
				if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextY][nextX]) {
					queue.add(new Pos(nextX, nextY));
					visited[nextY][nextX] = true;
				}
			}
		}
		
		return count;
		
	}
}
