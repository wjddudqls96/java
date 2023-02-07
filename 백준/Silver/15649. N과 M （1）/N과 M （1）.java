import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static boolean[] isVisited;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		isVisited = new boolean[N + 1];
		numbers = new int[M];
		
		recursion(0);
		
		System.out.println(sb.toString());
	}
	
	static void recursion(int num) {
		if(num == M) {
			for(int n : numbers) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isVisited[i]) continue;
			
			numbers[num] = i;
			isVisited[i] = true;
			recursion(num + 1);
			isVisited[i] = false;
		}
	}
}