import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Operation{
	int num;
	boolean isMinus;
	
	Operation(int num, boolean isMinus){
		this.num = num;
		this.isMinus = isMinus;
	}
	
	public String toString() {
		return this.num + " " + this.isMinus;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		
		String[] test1 = str.split("[-+]");
		String[] test2 = str.split("[0-9]+");
		
		Operation[] operations = new Operation[test1.length -1];
		int start = Integer.parseInt(test1[0]);
		
		for(int i = 1; i < test1.length; i++) {
			boolean isMinus = false;
			if(test2[i].equals("-")) {
				isMinus = true;
			}
			operations[i - 1] = new Operation(Integer.parseInt(test1[i]), isMinus);
		}
		
		int num = 0;
		boolean flag = false;
		for(int i = 0; i < operations.length; i++) {
			if(operations[i].isMinus) {
				flag = true;
				num += operations[i].num;
			}
			else if(!flag && !operations[i].isMinus) {
				start += operations[i].num;
			}
			else if(flag && !operations[i].isMinus) {
				num += operations[i].num;
			}
		}
		System.out.println(start - num);
	}
}