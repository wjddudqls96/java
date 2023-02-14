import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int num;
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int peopleCnt = Integer.parseInt(st.nextToken());
        int partyCnt = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(in.readLine());
        
        int knowCnt= Integer.parseInt(st.nextToken());
        
        List<Integer> knowList = new ArrayList<>();
        HashMap<Integer, Boolean> map2 = new HashMap<>();
        
        for(int i = 0; i < knowCnt; i++) {
        	knowList.add(Integer.parseInt(st.nextToken()));
        }
        
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        boolean[] visited = new boolean[peopleCnt+1];
        for(int i = 1; i <= peopleCnt; i++) {
        	map.put(i, new ArrayList<>());
        	map2.put(i, false);
        }
        
        List<ArrayList<Integer>> parties = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < partyCnt; i++) {
        	st = new StringTokenizer(in.readLine());
        	int memberCnt = Integer.parseInt(st.nextToken());
        	ArrayList<Integer> list = new ArrayList<>();
        	
        	for(int j = 0; j < memberCnt; j++) {
        		int member = Integer.parseInt(st.nextToken());
        		list.add(member);
        	}
        	parties.add(list);
        	
        	for(int j = 0; j < memberCnt; j++) {
        		for(int k = 0; k < memberCnt; k++) {
        			ArrayList<Integer> maplist = map.get(list.get(j));;
        			maplist.add(list.get(k));
        			map.put(list.get(j), maplist);
        		}
        	}
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < knowList.size(); i++) {
        	map2.put(knowList.get(i), true);
        	queue.offer(knowList.get(i));
        	visited[knowList.get(i)] = true;
        }
        
        while(!queue.isEmpty()) {
        	int member = queue.poll();
        	List<Integer> list = map.get(member);
        	
        	for(int i = 0; i < list.size(); i++) {
        		if(!visited[list.get(i)]) {
        			visited[list.get(i)] = true;
        			map2.put(list.get(i), true);
        			queue.offer(list.get(i));
        		}
        	}
        }
        
        int count = 0;
        
        for(ArrayList<Integer> list : parties) {
        	boolean flag = false;
        	for(int member : list) {
        		if(map2.get(member)) {
        			flag = true;
        		}
        	}
        	if(!flag) {
        		count++;
        	}
        }
        System.out.println(count);
    }
}