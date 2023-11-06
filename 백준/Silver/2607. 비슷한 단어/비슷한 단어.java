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
		
		int N = Integer.parseInt(in.readLine());
		String target = in.readLine();
		int result = 0;
		
		for(int i = 0; i < N - 1; i++) {
			String str = in.readLine();
			int count = 0;
			
			initMap(target);
			
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				if(map.containsKey(c)) {
					if(map.get(c) > 0) {
						map.put(c, map.get(c) - 1);
					}
					else {
						count++;
					}
				}
				else {
					count++;
				}
			}
			
			int dif = 0;
			for(char key : map.keySet()) {
				if(map.get(key) > 0) {
					dif += map.get(key);
				}
			}
			
			if((count < 2 && count >= 0) && (dif < 2 && dif >= 0)) {
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	static void initMap(String target) {
		map = new HashMap<>();
		
		for(int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	}
}