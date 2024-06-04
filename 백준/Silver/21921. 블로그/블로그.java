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
        
        st = new StringTokenizer(in.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(in.readLine());
        
        int[] arr = new int[N + 1];
        int total = 0;
        
        for(int i = 1; i <= N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	arr[i] = num;
        	
        	if(i <= X) {
        		total += num;
        	}
        }
        
        int MAX = total;
        int count = 0;
        
        if(MAX != 0) {
        	count++;
        }
        
        for(int i = 2; i <= N - X + 1; i++) {
        	
        	total -= arr[i - 1];
        	total += arr[i + X - 1];
        	
        	if(MAX < total) {
        		count = 1;
        		MAX = total;
        	}
        	else if(MAX == total){
        		count++;
        	}
        }
        
        
        
        if(MAX == 0) {
        	System.out.println("SAD");
        }
        else {
        	System.out.println(MAX);
            System.out.println(count);
        }
        
        
    }
}