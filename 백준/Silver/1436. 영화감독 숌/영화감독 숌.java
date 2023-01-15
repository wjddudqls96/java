
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		 
		int num = 666;
		int count = 1;
		 
		while(count != N) {
			num++;
		    
			if(String.valueOf(num).contains("666")) { 
				count++;
			}
		}
		
		System.out.println(num);
	}
}
