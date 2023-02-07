import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] switches;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		switches = new int[size];
		
		for(int i = 0; i < size; i++) {
			switches[i] = Integer.parseInt(split[i]);
		}
		
		int studentSize = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < studentSize; i++) {
			String[] line = in.readLine().split(" ");
			boolean isMan = Integer.parseInt(line[0]) == 1 ? true : false;
			int index = Integer.parseInt(line[1]) - 1;
			
			if(isMan) {
				manClick(index);
			}
			else {
				womanClick(index);
			}
		}
		
		for(int i = 0; i < switches.length; i++) {
			sb.append(switches[i]).append(" ");
			if(i != 0 && (i + 1) % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	static void clickSwitches(int index) {
		if(switches[index] == 1) {
			switches[index] = 0;
		}
		else {
			switches[index] = 1;
		}
	}
	
	static void womanClick(int index) {
		int gap = index < switches.length - 1 - index ? index : switches.length - 1 - index;
		clickSwitches(index);
		for(int i = 1; i <= gap; i++) {
			if(switches[index + i] == switches[index - i]) {
				clickSwitches(index + i);
				clickSwitches(index - i);
			}
			else {
				break;
			}
		}
		
	}
	
	static void manClick(int index) {
		for(int i = 0; i < switches.length; i++) {
			if((i + 1) % (index + 1) == 0) {
				clickSwitches(i);
			}
		}
	}
}