import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Word implements Comparable<Word>{
	String name;
	int count;
	
	public Word(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	@Override
	public int compareTo(Word o1) {
		if(this.count != o1.count) {
			return o1.count - this.count;
		}
		else {
			if(this.name.length() != o1.name.length()) {
				return o1.name.length() - this.name.length();
			}
			else {
				return -o1.name.compareTo(this.name);
			}
		}
	}
}


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1. 해시맵으로 카운팅
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String word = in.readLine();
			
			if(word.length() >= M) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
	
		// 2. 해시맵을 List에 클래스로 넣는다
		List<Word> list = new ArrayList<>();
		
		for(String key : map.keySet()) {
			list.add(new Word(key, map.get(key)));
		}
		
		// 3, 정렬
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).name).append("\n");
		}
		
		System.out.println(sb);
	}
}