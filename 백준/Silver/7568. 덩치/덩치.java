import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(in.readLine());
    	int[][] users = new int[T][2];
    	
    	for(int i = 0; i < T; i++) {
    		String[] split = in.readLine().split(" ");
    		int kg = Integer.parseInt(split[0]);
    		int cm = Integer.parseInt(split[1]);
    		
    		users[i][0] = kg;
    		users[i][1] = cm;
    	}
    	
    	for(int i = 0; i < T; i++) {
    		int[] my = users[i];
    		int count = 0;
    		for(int j = 0; j < T; j++) {
    			if(i != j) {
    				int[] you = users[j];
    				
    				if(you[0] > my[0] && you[1] > my[1]) {
    					count++;
    				}
    			}
    		}
    		System.out.print(count + 1 + " ");
    	}
    }
}