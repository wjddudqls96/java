import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		
		int[] arr2 = Arrays.copyOf(arr, N);
		Arrays.sort(arr2);
	
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(!map.containsKey(arr2[i])) {
				map.put(arr2[i], count++);
			}
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(map.get(arr[i]) + " ");
		}
		sb.append("\n");
		System.out.println(sb);
	}
	
}