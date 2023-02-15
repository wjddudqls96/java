import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Pos{
	int x;
	int y;
	int h;
	
	Pos(int x, int y, int h){
		this.x = x;
		this.y = y;
		this.h = h;
	}
}
public class Main {
	static int M,N,H;
	static int[][][] map;
	static boolean[][][] visit;
	static List<Pos> list;
	static int[][][] count;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H][N][M];
        count = new int[H][N][M];
        list = new ArrayList<Pos>();
        visit = new boolean[H][N][M];
        for(int h = 0; h < H; h++) {
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(in.readLine());
        		for(int j = 0; j < M; j++) {
        			int num = Integer.parseInt(st.nextToken());
        			if(num == 1) {
        				list.add(new Pos(j, i, h));
        			}
        			if(num == -1) {
        				count[h][i][j] = -1;
        			}
        			map[h][i][j] = num;
        		}
        	}
        }

        bfs();
        
        for(Pos pos : list) {
        	count[pos.h][pos.y][pos.x] = -1;
        }
        
        boolean flag = false;
        
        for(int[][] m1 : count) {
        	for(int[] m2 : m1) {
        		for(int m3 : m2) {
        			if(m3 == 0) {
        				flag = true;
        				break;
        			}
        			if(max < m3) {
        				max = m3;
        			}
        		}
        	}
        }
        if(flag) {
        	System.out.println(-1);
        }
        else {
        	if(max == -1) {
        		System.out.println(0);
        	}
        	else {
        		System.out.println(max);
        	}
        }
    }
	
	static void bfs() {
		int[][] direction = {{1, 0, 0},{-1, 0, 0},{0, 1, 0},{0, -1, 0},{0, 0, 1},{0, 0, -1}};
		Queue<Pos> queue = new LinkedList<Pos>();
		for(Pos pos : list) {
			visit[pos.h][pos.y][pos.x] = true;
			queue.add(pos);
		}
		
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			
			for(int i = 0; i < 6; i++) {
				int nextX = current.x + direction[i][0];
				int nextY = current.y + direction[i][1];
				int nextH = current.h + direction[i][2];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || nextH < 0 || nextH >= H) continue;
				
				if(!visit[nextH][nextY][nextX]) {
					if(map[nextH][nextY][nextX] != -1) {
						queue.add(new Pos(nextX, nextY, nextH));
						visit[nextH][nextY][nextX] = true;
						count[nextH][nextY][nextX] = count[current.h][current.y][current.x] + 1;
					}
					else {
						count[nextH][nextY][nextX] = -1;
					}
				}
			}
		}
	}
}