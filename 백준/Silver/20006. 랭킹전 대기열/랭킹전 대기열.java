import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Room {
	int interval;
	List<Player> joiners;
	
	public Room(int interval, Player player) {
		this.interval = interval;
		joiners = new ArrayList<>();
		joiners.add(player);
	}
}

class Player implements Comparable<Player>{
	int level;
	String nickname;
	
	public Player(int level, String nickname) {
		this.level = level;
		this.nickname = nickname;
	}
	
	@Override
	public int compareTo(Player o1) {
		return nickname.compareTo(o1.nickname);
	}
}

public class Main {
	static Map<Character, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Room> rooms = new ArrayList<>();
		
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();
			
			Player player = new Player(l, nickname);
			boolean isJoin = false;
			
			for(int j = 0; j < rooms.size(); j++) {
				Room room = rooms.get(j);
				int min = room.interval - 10;
				int max = room.interval + 10;
				
				if(room.joiners.size() < m && player.level >= min && player.level <= max) {
					room.joiners.add(player);
					isJoin = true;
					break;
				}
			}
			
			if(!isJoin) {
				rooms.add(new Room(player.level, player));
			}
		}
		
		for(Room room : rooms) {
			if(room.joiners.size() < m) {
				sb.append("Waiting!").append("\n");
			}
			else if(room.joiners.size() == m){
				sb.append("Started!").append("\n");
			}
			
			List<Player> list = room.joiners;
			Collections.sort(list);
			
			for(int i = 0; i < list.size(); i++) {
				Player player = list.get(i);
				sb.append(player.level + " " +player.nickname).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}