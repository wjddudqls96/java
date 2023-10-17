import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Country implements Comparable<Country>{
	int num;
	int gold;
	int silver;
	int dong;
	
	public Country(int num, int gold, int silver, int dong) {
		this.num = num;
		this.gold = gold;
		this.silver = silver;
		this.dong = dong;
	}
	
	@Override
	public int compareTo(Country country) {
		
		if(this.gold > country.gold) {
			return -1;
		}
		else if(this.gold == country.gold) {
			if(this.silver > country.silver) {
				return -1;
			}
			else if(this.silver == country.silver) {
				if(this.dong > country.dong) {
					return -1;
				}
				else {
					return 1;
				}
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		return this.num + " " + this.gold + " " + this.silver + " " + this.dong;
	}
}

public class Main {
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	PriorityQueue<Country> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		
    		int num = Integer.parseInt(st.nextToken());
    		int gold = Integer.parseInt(st.nextToken());
    		int silver = Integer.parseInt(st.nextToken());
    		int dong = Integer.parseInt(st.nextToken());
    		
    		pq.add(new Country(num, gold, silver, dong));
    	}
    	
    	
    	int result = 1;
    
    	
    	Country temp = pq.poll();
    	
    	if(temp.num != K) {
    		while(!pq.isEmpty()) {
        		result++;
        		
        		Country country = pq.poll();
        		
        		if(K == country.num) {
        			if(temp.dong == country.dong && temp.silver == country.silver && temp.gold == country.gold) {
        				result--;
        			}
        			break;
        		}
        		
        		temp = country;
        	}
    	}
    	
    	System.out.println(result);
    }
}