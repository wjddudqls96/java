import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String password = "";
		
		while(true) {
			password = in.readLine();
			
			if(password.equals("end")) {
				break;
			}
			
			sb.append("<").append(password).append("> ");
			if(isAEIOU(password) && isContinues(password) && isSame(password)) {
				sb.append("is acceptable.").append("\n");
			}
			else {
				sb.append("is not acceptable.").append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean isAEIOU(String password) {
		List<Character> list = new ArrayList<Character>(List.of('a', 'e', 'i', 'o', 'u'));
		int count = 0;
		for(int i = 0; i < password.length(); i++) {
			if(list.contains(password.charAt(i))) {
				count++;
			}
		}
		
		return count == 0 ? false : true;
	}
	
	public static boolean isContinues(String password) {
		List<Character> list = new ArrayList<Character>(List.of('a', 'e', 'i', 'o', 'u'));
		
		for(int i = 0; i < password.length() - 2; i++) {
			int aCount = 0;
			int bCount = 0;
			
			for(int j = 0; j < 3; j++) {
				if(list.contains(password.charAt(i + j))) {
					aCount++;
				}
				else {
					bCount++;
				}
			}
			
//			if(password.equals("ptoui")) {
//				System.out.println(aCount + " " + bCount);
//			}
//			
			if(aCount >= 3 || bCount >= 3) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isSame(String password) {
		for(int i = 0; i < password.length() - 1; i++) {
			String str = "";
			
			for(int j = 0; j < 2; j++) {
				str += password.charAt(i + j);
			}
			
			if(!str.equals("ee") && !str.equals("oo")) {
				if(str.charAt(0) == str.charAt(1)) {
					return false;
				}
			}
		}
		
		return true;
	}
}