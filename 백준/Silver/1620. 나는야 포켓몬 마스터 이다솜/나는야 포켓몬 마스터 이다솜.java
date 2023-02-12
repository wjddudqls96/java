import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			String name = in.readLine();
			map.put(name, i);
			list.add(name);
		}
		
		for(int i = 0; i < M; i++) {
			String command = in.readLine();
			Pattern pattern = Pattern.compile("[A-Za-z]");
			Matcher matcher = pattern.matcher(command);
			
			if(matcher.find()) {
				System.out.println(map.get(command));
			}
			else {
				System.out.println(list.get(Integer.parseInt(command) - 1));
			}
		}
	}
	
}