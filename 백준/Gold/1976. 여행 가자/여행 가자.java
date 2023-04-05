import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[] parents;
	static ArrayList<ArrayList<Integer>> adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		
		parents = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					union(i, j);
				}
			}	
		}
		
		st = new StringTokenizer(in.readLine());
		int temp = Integer.parseInt(st.nextToken());
		boolean flag = true;
		
		for(int i = 0; i < M - 1; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(findSet(temp) != findSet(num)) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
}