import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(in.readLine());
        int count = 0;
        
        while(N >= 5) {
        	count += N / 5;
        	N /= 5;
        }
        
        System.out.println(count);
    }
}