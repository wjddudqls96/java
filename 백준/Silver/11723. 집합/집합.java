import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int num = 0;
		for(int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			switch (split[0]) {
			case "add":
				num = num | (1 << Integer.parseInt(split[1]));
				break;
			case "remove":
				if((num & (1 << Integer.parseInt(split[1]))) == (int) Math.pow(2, Integer.parseInt(split[1]))) {
					num = num ^ (1 << Integer.parseInt(split[1]));
				}
				break;
			case "check":
				if((num & (1 << Integer.parseInt(split[1]))) == (int) Math.pow(2, Integer.parseInt(split[1]))) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				if((num & (1 << Integer.parseInt(split[1]))) == (int) Math.pow(2, Integer.parseInt(split[1]))) {
					num = num ^ (1 << Integer.parseInt(split[1]));
				}
				else {
					num = num | (1 << Integer.parseInt(split[1]));
				}
				break;
			case "all":
				num = 0;
				for(int k = 1; k <=20; k++) {
					num = num | (1 << k);
				}
				break;
			case "empty":
				num = 0;
				break;
			}
		}
		System.out.println(sb);
	}
	
}