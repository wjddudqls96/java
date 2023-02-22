import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		Integer[] coins = new Integer[N];
		
		
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(in.readLine());
		}
		
		
		Arrays.sort(coins, (o1, o2) -> o2 - o1);
		
		int count = 0;
		for(int i = 0; i < coins.length; i++) {
			if(K / coins[i] != 0) {
				count += K / coins[i];
				K = K % coins[i];
			}
		}
		
		System.out.println(count);
	}
}