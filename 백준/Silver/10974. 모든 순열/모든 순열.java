import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] input;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(in.readLine());
		
		input = new int[N];
		visited = new boolean[N + 1];
		
		permutation(0);
		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		if(cnt == N) {
			for(int i = 0 ; i < input.length; i++) {
				sb.append(input[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			input[cnt] = i;
			visited[i] = true;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
