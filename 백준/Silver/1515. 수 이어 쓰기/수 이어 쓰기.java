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
        
        // 234092
        
        String str = in.readLine();
        int num = 0;
        int index = 0;
        boolean flag = true;
        
        while(flag) {
        	num++;
        	
        	String numStr = Integer.toString(num);
        	
        	for(int i = 0; i < numStr.length(); i++) {
        		char c = numStr.charAt(i);
        		
        		if(c == str.charAt(index)) {
        			index++;
        		}
        		
        		if(index == str.length()) {
        			flag = false;
        			break;
        		}
        	}
        }
        
        System.out.println(num);
        
    }
}