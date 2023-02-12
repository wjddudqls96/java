import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] times = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
        
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		int sum = times[0];
		
		for(int i = 1; i < N; i++) {
			times[i] += times[i-1];
			sum += times[i];
		}
		
		System.out.println(sum);
		
	}
	
}