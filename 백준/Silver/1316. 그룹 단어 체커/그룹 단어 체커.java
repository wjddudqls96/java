import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(in.readLine());
    	int count = 0;
    	
    	for(int i = 0; i < n; i++) {
    		String line = in.readLine();
    		Set<Character> set = new HashSet<>();
    		char prev = '\0';
    		boolean flag = false;
    		
    		for(int j = 0; j < line.length(); j++) {
    			if(prev != line.charAt(j) && set.contains(line.charAt(j))) {
    				flag = true;
    				break;
    			}
    			prev = line.charAt(j);
    			set.add(line.charAt(j));
    		}
    		
    		if(!flag) count++;
    	}
    	
    	System.out.println(count);
    }
}