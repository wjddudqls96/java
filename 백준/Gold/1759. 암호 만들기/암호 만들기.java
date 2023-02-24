import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static boolean[] visited;
	static ArrayList<String> moList, jaList;
	static ArrayList<String> moSubSet, jaSubSet;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		moList = new ArrayList<>();
		jaList = new ArrayList<>();
		
		for(int i = 0; i < C; i++) {
			char c = st.nextToken().charAt(0);
			
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				moList.add(Character.toString(c));
			}
			else {
				jaList.add(Character.toString(c));
			}
		}
		
		moSubSet = new ArrayList<>();
		jaSubSet = new ArrayList<>();
		
		visited = new boolean[moList.size()];
		subSet(0);
		visited = new boolean[jaList.size()];
		subSet2(0);
		
		ArrayList<String> conCatList = new ArrayList<>();
		
		for(int i = 0; i < moSubSet.size(); i++) {
			String mo = new String(moSubSet.get(i));
			
			for(int j = 0; j < jaSubSet.size(); j++) {
				String ja = new String(jaSubSet.get(j));
				ja += mo;
				if(ja.length() == L) {
					conCatList.add(ja);
				}
			}
		}
				
		ArrayList<String> results = new ArrayList<>();
		for(int i = 0; i < conCatList.size(); i++) {
			char[] cArr = conCatList.get(i).toCharArray();
			
			Arrays.sort(cArr);
			String str = new String(cArr);
			
			results.add(str);
		}
		
		Collections.sort(results);
		
		for(String str : results) {
			System.out.println(str);
		}
	}
	
	static void subSet(int cnt) {
		if(cnt == visited.length) {
			int count = 0;
			String str = "";
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					str += moList.get(i);
					count++;
				}
			}
			if(count != 0) {
				moSubSet.add(str);
			}
			return;
		}
		
		visited[cnt] = true;
		subSet(cnt + 1);
		visited[cnt] = false;
		subSet(cnt + 1);
	}
	
	static void subSet2(int cnt) {
		if(cnt == visited.length) {
			int count = 0;
			String str = "";
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					str += jaList.get(i);
					count++;
				}
			}
			if(count >= 2) {
				jaSubSet.add(str);
			}
			return;
		}
		
		visited[cnt] = true;
		subSet2(cnt + 1);
		visited[cnt] = false;
		subSet2(cnt + 1);
	}
}