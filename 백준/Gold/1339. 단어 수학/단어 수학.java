import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
class node implements Comparable<node>{
	char c;
	int num;
	
	public node(char c, int num) {
		super();
		this.c = c;
		this.num = num;
	}

	@Override
	public int compareTo(node o) {
		return o.num - this.num;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		HashMap<Character, Integer> map = new HashMap<>();
		List<String> lines = new ArrayList<String>();
		List<node> results = new ArrayList<node>();
		
		for(int i = 0; i < T; i++) {
			String line = in.readLine();
			lines.add(line);
			for(int j = 0; j < line.length(); j++) {
				int count = (int) Math.pow(10, line.length() - 1 - j);
				
				if(map.containsKey(line.charAt(j))) {
					map.put(line.charAt(j), map.get(line.charAt(j)) + count);
				}
				else {
					map.put(line.charAt(j), count);
				}
			}
		}
		
		for(char key : map.keySet()) {
            results.add(new node(key, map.get(key)));
        }
		
		Collections.sort(results);
		
		int count = 9;
		
		for(node node : results) {
			map.put(node.c, count--);
		}
		
		
		int sum = 0;
		for(String line : lines) {
			for(int i = 0; i < line.length(); i++) {
				int c = (int) Math.pow(10, line.length() - 1 - i);
				sum += c*map.get(line.charAt(i));
			}
		}
		
		System.out.println(sum);
	}
	
}