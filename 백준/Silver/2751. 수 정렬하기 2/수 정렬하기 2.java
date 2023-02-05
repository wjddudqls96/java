import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(in.readLine()));
		}
		
		Collections.sort(list);
		
		for(int num : list) {
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
		
	}
}