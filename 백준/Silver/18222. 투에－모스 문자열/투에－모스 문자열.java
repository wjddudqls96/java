import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Long N;
	static int result;
	static Long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(in.readLine().trim());
		arr = new Long[64];
		
		arr[0] = (long) 1;
		
		for(int i = 1; i < 64; i++) {
			arr[i] = arr[i - 1] * 2;
		}
		System.out.println(recursion(N));
	}
	
	static int recursion(Long num) {
		if(num == 1) {
			return 0;
		}
		for (int i = 0; i < 64; i++){
            if (arr[i] >= num) 
            	return 1 - recursion(num - arr[i-1]);
        }
        return 0;
	}
}