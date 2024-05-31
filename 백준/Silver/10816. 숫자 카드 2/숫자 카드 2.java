import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("./input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;
        
        int N = Integer.parseInt(in.readLine());
        
        st = new StringTokenizer(in.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int M = Integer.parseInt(in.readLine());
        
        st = new StringTokenizer(in.readLine());
        sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	
        	if(map.get(num) != null) {
        		sb.append(map.get(num)).append(" ");
        	}
        	else {
        		sb.append(0).append(" ");
        	}
        }
        
        System.out.println(sb);
    }
}