import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int index;
	ArrayList<Node> list;
	
	public Node(int index) {
		this.index = index;
		list = new ArrayList<>();
	}
	
	void add(Node node) {
		this.list.add(node);
	}
}

public class Main {
	static int[] hackedCount;
	static boolean[] visited;
	static ArrayList<Node> mapList;
	static int N, M;
	static int max;
	static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = in.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        
        hackedCount = new int[N+1];
        
        mapList = new ArrayList<Node>();
        
        for(int i = 0; i <= N; i++) {
        	mapList.add(new Node(i));
        }
        
        max = Integer.MIN_VALUE;
        // 인접리스트 만들기
        for(int i = 0; i < M; i++) {
        	String[] line = in.readLine().split(" ");
        	int y = Integer.parseInt(line[1]);
        	int x = Integer.parseInt(line[0]);
        	mapList.get(y).list.add(new Node(x));
        }
        //bfs 시작
        bfs();
        
        for(int i = 1; i <= N; i++) {
        	if(max == hackedCount[i]) {
        		sb.append(i +" ");
        	}
        }
        
        System.out.println(sb);
    }
    
    static void bfs() {
    	for(int i = 1; i <= N; i++) {
    		Queue<Node> queue = new LinkedList<>();
    		visited = new boolean[N + 1];
    		count = 0;
    		queue.add(mapList.get(i));
    		visited[i] = true;
    		
    		while(!queue.isEmpty()) {
    			Node node = queue.poll();
    			for(Node nextNode : mapList.get(node.index).list) {
    				if(!visited[nextNode.index]) {
    					queue.add(nextNode);
    					visited[nextNode.index] = true;
    					count++;
    				}
    			}
    		}
    		
    		hackedCount[i] = count;
    		if(max < count) {
    			max = count;
    		}
    	}
    }

}
