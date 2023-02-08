import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		numbers = new int[M];
		
		recursion(0, 1);
		
		System.out.println(sb);
	}
	
	static void recursion(int cnt, int start) {
		if(cnt == M) {
			for(int n : numbers) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			recursion(cnt + 1, i + 1);
		}
	}
}