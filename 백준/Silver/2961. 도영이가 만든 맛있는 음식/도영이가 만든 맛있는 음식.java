import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static boolean[] visited;
	static int[][] maps;
	static int MIN = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		visited = new boolean[N];
		maps = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			maps[i][0] = Integer.parseInt(split[0]);
			maps[i][1] = Integer.parseInt(split[1]);
		}
		
		subSet(0);
		System.out.println(MIN);
	}
	
	static void subSet(int cnt) {
		if(cnt == N) {
			int flavor1 = 1;
			int flavor2 = 0;
			int fCount = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					flavor1 *= maps[i][0];
					flavor2 += maps[i][1];
					fCount++;
				}
			}
			
			if(fCount != 0) {
				int gap = Math.abs(flavor1 - flavor2);
				if(MIN > gap) {
					MIN = gap;
				}
			}
			return;
		}
		
		visited[cnt] = true;
		subSet(cnt + 1);
		// 현재 원소를 부분집합의 구성에 비포함
		visited[cnt] = false;
		subSet(cnt + 1);
	}
}