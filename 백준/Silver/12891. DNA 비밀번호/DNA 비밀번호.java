import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
	static int S, P;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		S = Integer.parseInt(split[0]);
		P = Integer.parseInt(split[1]);
		
		String line = in.readLine();
		String[] command = in.readLine().split(" ");
		
		int Ac = Integer.parseInt(command[0]);
		int Cc = Integer.parseInt(command[1]);
		int Gc = Integer.parseInt(command[2]);
		int Tc = Integer.parseInt(command[3]);
		
		int left = 0;
		int right = -1;
		int cnt = 0;
		while(left <= S - 1) {
			if(right - left < P - 1 && right < S - 1) {
				right++;
				if(line.charAt(right) == 'A') {
					Ac--;
				}
				else if(line.charAt(right) == 'C') {
					Cc--;
				}
				else if(line.charAt(right) == 'G') {
					Gc--;
				}
				else if(line.charAt(right) == 'T') {
					Tc--;
				}
			}
			
			else if(right - left == P - 1){
				if(Ac <= 0 && Cc <= 0 && Gc <= 0 && Tc <= 0) {
					cnt++;
				}
				
				if(line.charAt(left) == 'A') {
					Ac++;
				}
				else if(line.charAt(left) == 'C') {
					Cc++;
				}
				else if(line.charAt(left) == 'G') {
					Gc++;
				}
				else if(line.charAt(left) == 'T') {
					Tc++;
				}
				left++;
			}
			else {
				left++;
			}
		}
		
		System.out.println(cnt);
	}
}