import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Map<Character, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		for(int i = 0; i < M; i++) {
			String line = in.readLine();
			
			String[] arr = line.split(",");
			
			for(int j = 0; j < arr.length; j++) {
				String str = arr[j];
				
				if(map.containsKey(str)) {
					if(map.get(str) > 1) {
						map.put(str, map.get(str) - 1);
					}
					else {
						map.remove(str);
					}
				}
			}
			
			sb.append(map.size()).append("\n");
		}
		
		System.out.println(sb);
	}
}