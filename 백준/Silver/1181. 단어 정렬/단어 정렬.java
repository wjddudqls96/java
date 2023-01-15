import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		String[] dic = new String[N];
		
		for(int i = 0; i < N; i++) {
			dic[i] = in.readLine();
		}
		
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(dic));
		String[] duplicatDic = hashSet.toArray(new String[0]);
		
        
		for(int i = 0 ; i < duplicatDic.length - 1 ; i ++) {
		    int minIndex = i;
		    for(int j = i + 1 ; j < duplicatDic.length ; j ++) {
		        if(duplicatDic[minIndex].length() > duplicatDic[j].length()) {
		        	minIndex = j;
		        }
		        else if(duplicatDic[minIndex].length() == duplicatDic[j].length()) {
		        	int compare = duplicatDic[minIndex].compareTo(duplicatDic[j]);
		        	if(compare > 0) {
		        		minIndex = j;
		        	}
		        }
		    }
		    String temp = duplicatDic[minIndex];
		    duplicatDic[minIndex] = duplicatDic[i];
		    duplicatDic[i] = temp;
		}
		
		for(int i = 0; i < duplicatDic.length; i++) {
			sb.append(duplicatDic[i]).append("\n");
		}
		System.out.println(sb);
	}
}
