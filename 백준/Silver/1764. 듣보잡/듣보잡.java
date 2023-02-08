import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String name = in.readLine();
			map.put(name, 0);
		}
		
		for(int i = N + 1; i < N + M; i++) {
			String name = in.readLine();
			if(map.containsKey(name)) {
				int count = map.get(name);
				map.put(name, count+1);
			}
		}
		List<String> list = new ArrayList<>();
		for(String name : map.keySet()) {
			if(map.get(name) > 0) {
				list.add(name);
			}
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(String name : list) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb);
	}
}