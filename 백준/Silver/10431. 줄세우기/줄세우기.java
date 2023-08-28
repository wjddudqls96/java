import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int P = Integer.parseInt(in.readLine());
    	
    	for(int p = 0; p < P; p++) {
    		List<Integer> list = new ArrayList<>();
    		int answer = 0;
    		StringTokenizer st = new StringTokenizer(in.readLine());
    		int number = Integer.parseInt(st.nextToken());
    		
    		for(int i = 0; i < 20; i++) {
    			int children = Integer.parseInt(st.nextToken());
    			boolean isBack = false;
    		
    			// 1.돌면서나보다 큰애 있는지 찾는다.
    			for(int j = 0; j < list.size(); j++) {
    				if(list.get(j) > children) {
    					// 걸음수 계산
    					answer += list.size() - j;
    					list.add(j, children);
    					isBack = true;
    					break;
    				}
    			}
    			
    			if(!isBack) {
    				list.add(children);
    			}
    		}
    		
    		System.out.println(number + " " + answer);
    	}
    }
}