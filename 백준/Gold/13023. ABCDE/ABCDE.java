import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 인접 리스트 만들기
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			ArrayList<Integer> l = list.get(num1);
			l.add(num2);
			ArrayList<Integer> l2 = list.get(num2);
			l2.add(num1);
			
		}
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			if(dfs(i, 0)) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
	static boolean dfs(int start, int level){
		if(level == 4) {
			return true;
		}
		
		
		ArrayList<Integer> l = list.get(start);
		
		for(int i = 0; i < l.size(); i++) {
			
			if(!visited[l.get(i)]) {
				visited[start] = true;
				if(dfs(l.get(i), level + 1)) {
					return true;
				}
				visited[start] = false;
			}
		}
		return false;
	}
}