import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(in.readLine());
        
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(in.readLine());
        	HashMap<String, ArrayList<String>> map = new HashMap<>();
        	
        	
        	for(int i = 0; i < n; i++) {
        		StringTokenizer st = new StringTokenizer(in.readLine());
        		String name = st.nextToken();
        		String type = st.nextToken();
        		
        		if(!map.containsKey(type)) {
        			ArrayList<String> list = new ArrayList<String>();
        			list.add(name);
        			map.put(type, list);
        		}
        		else {
        			ArrayList<String> list = map.get(type);
        			list.add(name);
        			map.put(type, list);
        		}
        	}
        	
        	int result = 1;
        	for(String key : map.keySet()) {
        		int size = map.get(key).size() + 1;
        		result *= size;
        	}
        	
        	result--;
        	System.out.println(result);
        }
    }
}