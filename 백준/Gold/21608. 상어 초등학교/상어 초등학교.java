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

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int count;
	
	public Pos(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
	@Override
	public int compareTo(Pos o1) {
		return o1.count - this.count;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + ", count=" + count + "]";
	}
	
	
}

public class Main {
	private static int N, studentCnt;
	private static int[][] map;
	private static int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		studentCnt = N*N;
		map = new int[N][N];
		List<Integer>[] inputs = new ArrayList[studentCnt + 1];
		
		
		for(int i = 1; i <= studentCnt; i++) {
			st = new StringTokenizer(in.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			List<Integer> favorList = new ArrayList<>();
			
			for(int j = 0; j < 4; j++) {
				int favorIdx = Integer.parseInt(st.nextToken());
				
				favorList.add(favorIdx);
			}
			
			inputs[idx] = favorList;
			
			// Logic start
			List<Pos> posList = findFirstStep(favorList);
			//System.out.println(posList);
			secondStep(idx, posList);
			
			
		}
		
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				int total = 0;
				
				for(int d = 0; d < 4; d++) {
					int nextX = j + dir[d][0];
					int nextY = i + dir[d][1];
					
					if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
					
					if(inputs[map[i][j]].contains(map[nextY][nextX])) {
						total++;
					}
				}
				
				if(total == 1) {
					result += 1;
				}
				else if(total == 2) {
					result += 10;
				}
				else if(total == 3) {
					result += 100;
				}
				else if(total == 4) {
					result += 1000;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static List<Pos> findFirstStep(List<Integer> favorList) {
		List<Pos> posList = new ArrayList<>();
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int findCnt = 0;
				int emptyCnt = 0;
				
				if(map[i][j] != 0) continue;
				
				for(int d = 0; d < 4; d++) {
					int nextX = j + dir[d][0];
					int nextY = i + dir[d][1];
					
					if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
					
					if(map[nextY][nextX] == 0) {
						emptyCnt++;
					}
					
					if(favorList.contains(map[nextY][nextX])) {
						findCnt++;
					}
				}
				
				if(max < findCnt) {
					max = findCnt;
					posList = new ArrayList<>();
					posList.add(new Pos(j, i, emptyCnt));
				}
				else if(max == findCnt) {
					posList.add(new Pos(j, i, emptyCnt));
				}
			}
		}
		
		return posList;
	}
	
	static void secondStep(int idx, List<Pos> posList) {
		List<Pos> maxEmptyList = new ArrayList<>();
		Collections.sort(posList);
		
		int max = posList.get(0).count;
		
		for(Pos pos : posList) {
			if(max == pos.count) {
				maxEmptyList.add(pos);
			}
		}
		
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		
		for(Pos pos : maxEmptyList) {
			
			if(minY > pos.y) {
				minY = pos.y;
				minX = pos.x;
			}
			else if(minY == pos.y) {
				
				if(minX > pos.x) {
					minY = pos.y;
					minX = pos.x;
				}
			}
		}
		
		map[minY][minX] = idx;
	}

}