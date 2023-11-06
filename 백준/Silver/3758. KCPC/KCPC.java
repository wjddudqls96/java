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

class Problem {
	int score;
	int time;
	
	public Problem(int score, int time) {
		this.score = score;
		this.time = time;
	}
}

class Team implements Comparable<Team>{
	int teamId;
	int sum;
	int lastTime;
	int submitCount;
	
	public Team(int teamId, int sum, int lastTime, int submitCount) {
		this.teamId = teamId;
		this.sum = sum;
		this.lastTime = lastTime;
		this.submitCount = submitCount;
	}
	
	@Override
	public int compareTo(Team o1) {
		if(this.sum == o1.sum) {
			if(this.submitCount == o1.submitCount) {
				return this.lastTime - o1.lastTime;
			}
			
			return this.submitCount - o1.submitCount;
		}
		
		return o1.sum - this.sum;
	}
}

public class Main {
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(in.readLine());
    	
    	for(int testCase = 0; testCase < T; testCase++) {
    		st = new StringTokenizer(in.readLine());
    		
    		int n = Integer.parseInt(st.nextToken());
    		int k = Integer.parseInt(st.nextToken());
    		int t = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		
    		Map<Integer, Map<Integer, Problem>> map = new HashMap<>();
    		
    		// 팀별 map init
    		for(int i = 1; i <= n; i++) {
    			Map<Integer, Problem> newMap = new HashMap<>();
    			map.put(i, newMap);
    		}
    		
    		int[] teamCount = new int[n + 1];
    		
    		// 팀이 획득한 문제들 
    		for(int i = 0; i < m; i++) {
    			st = new StringTokenizer(in.readLine());
    			
    			int teamId = Integer.parseInt(st.nextToken());
    			int problemId = Integer.parseInt(st.nextToken());
    			int score = Integer.parseInt(st.nextToken());
    			Map<Integer, Problem> teamMap = map.get(teamId);
    			int newScore = score;
    			
    			// 팀이 푼문제가 있다면! 
    			if(teamMap.containsKey(problemId)) {
    				newScore = Math.max(teamMap.get(problemId).score, score);
    			}
    			
    			teamMap.put(problemId, new Problem(newScore, i));
    			teamCount[teamId]++;
    		}
    		
    		// 팀별 산정 
    		List<Team> teams = new ArrayList<>();
    		
    		for(int key : map.keySet()) {
    			Map<Integer, Problem> teamMap = map.get(key);
    			int sum = 0;
    			int lastTime = 0;
    			
    			for(int problemId : teamMap.keySet()) {
    				Problem p = teamMap.get(problemId);
    				sum += p.score;
    				lastTime = Math.max(lastTime, p.time);
    			}
    			
    			teams.add(new Team(key, sum, lastTime, teamCount[key]));
    		}
    		
    		Collections.sort(teams);
    		
    		for(int i = 0; i < teams.size(); i++) {
    			int teamId = teams.get(i).teamId;
    			
    			if(teamId == t) {
    				System.out.println(i + 1);
    				break;
    			}
    		}
    	}
    }
}