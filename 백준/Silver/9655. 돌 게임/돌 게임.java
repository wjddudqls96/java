import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(in.readLine());
    	
    	if(n % 2 == 0) {
    		System.out.println("CY");
    	}
    	else {
    		System.out.println("SK");
    	}
    }
}