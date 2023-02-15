import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int MAX;
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String str = in.readLine();
        int brokenCtn = Integer.parseInt(in.readLine());
        ArrayList<Integer> brokens = new ArrayList<>();
        
        if(brokenCtn != 0) {
        	st = new StringTokenizer(in.readLine());
        	for(int i = 0; i < brokenCtn; i++) {
        		brokens.add(Integer.parseInt(st.nextToken()));
        	}
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i <= 999999; i++) {
        	boolean isContinue = false;
        	String parseI = Integer.toString(i);
        	for(int j = 0; j < parseI.length(); j++) {
        		// 부서진 버튼이 존재한다면
        		if(brokens.contains(parseI.charAt(j) - '0')) {
        			isContinue = true;
        			break;
        		}
        	}
        	
        	if(isContinue) continue;
        	
        	int num = i;
        	int def = 100;
        	int result = Math.abs(num - Integer.parseInt(str)) + parseI.length();
     
        	if(min > result) {
        		min = result;
        	}
        }
        
        if(min > Math.abs(100 - Integer.parseInt(str))) {
        	min = Math.abs(100 - Integer.parseInt(str));
        }
        
        System.out.println(min);
    }
}