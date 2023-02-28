import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, All, MIN = Integer.MAX_VALUE;
	static int[] regions;
	static boolean[] visited;
	static boolean f;
	static ArrayList<ArrayList<Integer>> matrix;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		regions = new int[N];
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			regions[i] = num;
			All += num;
		}
		
		matrix = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			ArrayList<Integer> newList = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < k; j++) {
				newList.add(Integer.parseInt(st.nextToken()) - 1);
			}
			matrix.add(newList);
		}
		
		visited = new boolean[N];
		subSet(0);
		if(!f) {
			System.out.println(-1);
		}else {
			System.out.println(MIN);
		}
	}
	
	static void subSet(int cnt) {
		if(cnt == N) {
			if(isPossible()) {
				int sum = 0;
				f = true;
				for(int i = 0; i < N; i++) {
					if(visited[i]) {
						sum += regions[i];
					}
				}
				
				int dif = Math.abs(All - (2 * sum));
				if(MIN > dif) {
					MIN = dif;
				}
			}
			return;
		}
		
		visited[cnt] = true;
		subSet(cnt + 1);
		visited[cnt] = false;
		subSet(cnt + 1);
	}
	
	static boolean isPossible() {
		boolean[] isSelected = new boolean[N];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			if(visited[i] && !isSelected[i]) {
				bfs(i, isSelected, true);
				count++;
			}
			else if(!visited[i] && !isSelected[i]){
				bfs(i, isSelected, false);
				count++;
			}
		}
		
		return count == 2 ? true : false;
	}
	
	static void bfs(int startIndex, boolean[] isSelected, boolean flag) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(startIndex);
		isSelected[startIndex] = true;
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			
			for(int i = 0; i < matrix.get(index).size(); i++) {
				int num = matrix.get(index).get(i);
				if(!isSelected[num] && visited[num] && flag) {
					queue.add(num);
					isSelected[num] = true;
				}
				else if(!isSelected[num] && !visited[num] && !flag) {
					queue.add(num);
					isSelected[num] = true;
				}
			}
		}
	}
}