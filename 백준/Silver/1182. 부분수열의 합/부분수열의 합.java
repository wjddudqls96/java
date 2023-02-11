import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isVisted;
	static int[] numbers;
	static int N, result, count;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		result = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		isVisted = new boolean[N];
		
		String[] line = in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(line[i]);
		}
		count = 0;
		test(0);
		
		System.out.println(count);
	}
	
	static void test(int cnt) {
		
		if(cnt == N) {
			int sum = 0;
			int isEmptyCount = 0;
			for(int i = 0; i < isVisted.length; i++) {
				if(isVisted[i]) {
					sum += numbers[i];
				}
				else {
					isEmptyCount++;
				}
			}
			if(isEmptyCount != isVisted.length && sum == result) {
				count++;
			}
			return;
		}
		
		isVisted[cnt] = true;
		test(cnt + 1);
		isVisted[cnt] = false;
		test(cnt + 1);
	}
}