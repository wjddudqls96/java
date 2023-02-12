import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(in.readLine());
			for(int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				}
				else if(command.equals("D")) {
					if(!map.isEmpty()) {
						int removeKey = (num == 1) ? map.lastKey() : map.firstKey();
						
						if(map.get(removeKey) - 1 == 0) {
							map.remove(removeKey);
						}
						else {
							map.put(removeKey, map.get(removeKey) - 1);
						}
					}
					else {
						continue;
					}
				}
			}
			
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			}
			else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
		
	}
	
}