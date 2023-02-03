import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int num = Integer.parseInt(in.readLine());
    	int cnt = 0;
    	int differ = -1;
    	int index = -1;
    	
    	for(int i = 1; ;i++) {
    		cnt += i;
    		if(num <= cnt) {
    			index = i;
    			break;
    		}
    	}
    	
    	differ = cnt - index;

    	int x = 1;
    	int y = 1;
    	
    	if(index % 2 == 0) {
    		y = index;
    		for(int i = 1; i < num - differ; i++) {
    			y--;
    			x++;
    		}
    	}
    	else {
    		x = index;
    		for(int i = 1; i < num - differ; i++) {
    			x--;
    			y++;
    		}
    	}
    	
    	System.out.println(x + "/" + y);
    }
}