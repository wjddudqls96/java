import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Team {
	int num;
	int sum;
	List<Integer> points;
	
	public Team(int num, int point) {
		this.num = num;
		this.sum = point;
		this.points = new ArrayList<>();
		this.points.add(point);
	}
}

public class Main {
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	int T = Integer.parseInt(in.readLine());
    	
    	for(int t = 0; t < T; t++) {
    		int N = Integer.parseInt(in.readLine());
    		st = new StringTokenizer(in.readLine());
    		
    		List<Integer> list = new ArrayList<>();
    		Map<Integer, Integer> map = new HashMap<>();
    		
    		for(int i = 0; i < N; i++) {
    			int team = Integer.parseInt(st.nextToken());
    			map.put(team, map.getOrDefault(team, 0) + 1);
    			list.add(team);
    		}
    		
    		Map<Integer, Team> tMap = new HashMap<>();
    		int point = 1;
    		
    		for(int i = 0; i < N; i++) {
    			int teamNum = list.get(i);
    			
    			if(map.get(teamNum) == 6) {
    				if(tMap.containsKey(teamNum)) {
    					Team team = tMap.get(teamNum);
    					
    					if(tMap.get(teamNum).points.size() < 4) {
    						team.sum += point;
    					}
    					
    					team.points.add(point);
    				}
    				else {
    					tMap.put(teamNum, new Team(teamNum, point));
    				}
    				point++;
    			}
    		}
    		
    		Team result = null;
    		int min = Integer.MAX_VALUE;
    		
    		for(int key : tMap.keySet()) {
    			int sum = tMap.get(key).sum;
    			
    			if(min > sum) {
    				min = sum;
    				result = tMap.get(key);
    			}
    			else if(min == sum) {
    				if(result.points.get(4) > tMap.get(key).points.get(4)) {
    					result = tMap.get(key);
    				}
    			}
    		}
    		
    		System.out.println(result.num);
    	}
    }
}