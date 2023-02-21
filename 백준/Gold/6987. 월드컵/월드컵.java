import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Team{
	int win;
	int mid;
	int lose;
	
	Team(int win, int mid, int lose){
		this.win = win;
		this.mid = mid;
		this.lose = lose;
	}
	
	@Override
	public String toString() {
		return "Team [win=" + win + ", mid=" + mid + ", lose=" + lose + "]";
	}
}

class Main {
	static Team[] teams;
	static int[] game;
	static List<List<Integer>> games;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int k = 0; k < 4; k++) {
			teams = new Team[6];
			flag = false;
			StringTokenizer st = new StringTokenizer(in.readLine());

			for(int t = 0; t < 6; t++) {
				int win = Integer.parseInt(st.nextToken());
				int mid = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				teams[t] = new Team(win, mid, lose);
			}
			
			game = new int[2];
			games = new ArrayList<List<Integer>>();
			combi(0, 0);
			permutation(0, 0);
			
			if(flag) {
				System.out.print(1 + " ");
			}
			else {
				System.out.print(0 + " ");
			}
		}
	}
	
	static void combi(int cnt, int start) {
		if(cnt == 2) {
			games.add(Arrays.stream(game).boxed().collect(Collectors.toList()));
			return;
		}
		
		for(int i = start; i < 6; i++) {
			game[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
	
	static boolean permutation(int cnt, int type) {
		
		
		if(cnt == games.size()) {
			for(int i = 0; i < teams.length; i++) {
				Team team = teams[i];
				
				if(team.win != 0 || team.mid != 0 || team.lose != 0) {
					return false;
				}
			}
			flag = true;
			return true;
		}
		
		List<Integer> game = games.get(cnt);
		Team team1 = teams[game.get(0)];
		Team team2 = teams[game.get(1)];
		
		if(!isPossible(team1, team2)) {
			return false;
		}
		
		for (int i = 1; i <= 3; i++) {
			play(team1, team2, i);
			if(permutation(cnt + 1, i)) {
				break;
			}
			reverseScore(team1, team2, i);
		}
		
		return false;
	}
	
	static void play(Team team1, Team team2, int type) {
		switch (type) {
		case 1:
			team1.win--;
			team2.lose--;
			break;
		case 2:
			team1.mid--;
			team2.mid--;
			break;
		case 3:
			team1.lose--;
			team2.win--;
			break;
		}
	}
	
	static void reverseScore(Team team1, Team team2, int type) {
		switch (type) {
		case 1:
			team1.win++;
			team2.lose++;
			break;
		case 2:
			team1.mid++;
			team2.mid++;
			break;
		case 3:
			team1.lose++;
			team2.win++;
			break;
		}
	}
	
	static boolean isPossible(Team team1, Team team2) {
		if(team1.lose < 0 || team1.win < 0 || team1.mid < 0) {
			return false;
		}
		
		if(team2.lose < 0 || team2.win < 0 || team2.mid < 0) {
			return false;
		}
		
		return true;
	}
}