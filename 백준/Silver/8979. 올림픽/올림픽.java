import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Country implements Comparable<Country>{
	int num;
	int gold;
	int silver;
	int dong;
	int rate;
	
	public Country(int num, int gold, int silver, int dong) {
		this.num = num;
		this.gold = gold;
		this.silver = silver;
		this.dong = dong;
	}
	
	@Override
	public int compareTo(Country o) {
		
		if(this.gold == o.gold) {
            if(this.silver == o.silver) {
                return o.dong- this.dong;
            }
            else {
                return o.silver - this.silver;
            }
        }
        else {
            return o.gold - this.gold;
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
    	List<Country> list = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		
    		int num = Integer.parseInt(st.nextToken());
    		int gold = Integer.parseInt(st.nextToken());
    		int silver = Integer.parseInt(st.nextToken());
    		int dong = Integer.parseInt(st.nextToken());
    		
    		list.add(new Country(num, gold, silver, dong));
    	}
    	
    	Collections.sort(list);
    	int index = 0;
    	
    	list.get(0).rate = 1;
    	
    	for(int i = 1; i < list.size(); i++) {
    		int tempGold= list.get(i-1).gold;
            int tempSilver = list.get(i-1).silver;
            int tempDong = list.get(i-1).dong;
            
            Country now = list.get(i);
            
            if(now.num == K) {
            	index = i;
            }
            
            if(now.gold == tempGold && now.silver==tempSilver && now.dong==tempDong) {
                list.get(i).rate = list.get(i-1).rate;
            }
            else {
            	list.get(i).rate = i + 1;
            }
    	}
    	
    	
    	System.out.println(list.get(index).rate);
    }
}