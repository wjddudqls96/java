import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
		int max = Integer.MIN_VALUE;
		String maxS = "";
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			
			for(int j = 0; j < line.length(); j++) {
				String sub = line.substring(0, j + 1);
				if(!map.containsKey(sub)) {
					ArrayList<String> list = new ArrayList<>();
					list.add(line);
					
					map.put(sub,list);
				}
				else {
					ArrayList<String> list = map.get(sub);
					list.add(line);
					map.put(sub, list);
				}
			}
		}
		
		for(String key : map.keySet()) {
			ArrayList<String> list = map.get(key);
			
			if(list.size() >= 2 && key.length() > max) {
				max = key.length();
				maxS = key;
			}
		}
		
		ArrayList<String> list = map.get(maxS);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
}