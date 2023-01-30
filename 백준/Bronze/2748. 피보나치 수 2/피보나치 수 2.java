import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Long[] arr = new Long[91];
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(in.readLine());
    	System.out.println(fibo(n));
    	
    }
    
    static Long fibo(int n) {
    	if(n == 1) return (long) 1;
    	if(n == 2) return (long) 1;
    	if(arr[n] != null) return arr[n];
    	
    	return arr[n] = fibo(n-2) + fibo(n-1);
    }
}