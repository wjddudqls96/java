public class Main {
	public static void main(String[] args) throws Exception {
		int[] count = new int[10001];
		
		for(int i = 1; i <= 10000; i++) {
			String strNum = Integer.toString(i);
			int result = i;
			for(int j = 0; j < strNum.length(); j++) {
				result += strNum.charAt(j) - '0';
			}
			
			if(result <= 10000) {
				count[result]++;
			}
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(count[i] == 0) {
				System.out.println(i);
			}
		}
		
		
	}
}
