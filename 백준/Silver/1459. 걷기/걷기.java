import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long x=Long.parseLong(st.nextToken());
		long y=Long.parseLong(st.nextToken());
		long w=Long.parseLong(st.nextToken());
		long s=Long.parseLong(st.nextToken());
		
		long cost1, cost2, cost3;
		
	
		cost1=(x+y)*w;
        
		if((x+y)%2==0){
            cost2=Math.max(x, y)*s;
        }
		else{
            cost2=(Math.max(x, y)-1)*s+w;
        }
		
		cost3=(Math.min(x, y))*s+(Math.abs(x-y))*w;
		
		System.out.println(Math.min(cost1, Math.min(cost2, cost3)));
		
		
	}
}

