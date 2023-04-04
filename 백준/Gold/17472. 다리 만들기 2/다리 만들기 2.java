import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	int directions;
	int num;
	int count;
	
	public Pos(int x, int y, int directions, int num, int count) {
		super();
		this.x = x;
		this.y = y;
		this.directions = directions;
		this.num = num;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + ", directions=" + directions + ", num=" + num + ", count=" + count + "]";
	}
	
	
}

class Bridge{
	String key;
	int dist;
	
	public Bridge(String key, int dist) {
		super();
		this.key = key;
		this.dist = dist;
	}

	@Override
	public String toString() {
		return "Bridge [key=" + key + ", dist=" + dist + "]";
	}
	
	
}

public class Main {
	static int N, M, min;
	static int count;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] isSelected;
	static Queue<Pos> bridgeQ;
	static HashMap<String, Integer> hashMap;
	static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bridgeQ = new ArrayDeque<>();
		hashMap = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					bfs(j, i, ++count);
				}
			}
		}

		makeBridge();
		
		ArrayList<Bridge> list = new ArrayList<>();
		for(String key : hashMap.keySet()) {
			int dist = hashMap.get(key);
			
			if(dist > 1) {
				list.add(new Bridge(key, dist));
			}
			
		}
		
		int[][] matrix = new int[count + 1][count + 1];
		
		for(int i = 0; i < list.size(); i++) {
			String key = list.get(i).key;
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int cnt = 0;
			for(int j = key.length() - 1; j >= 0; j--) {
				if(key.charAt(j) == '1') {
					arr.add(cnt);
				}
				cnt++;
			}
			
			if(arr.size() == 2) {
				matrix[arr.get(0) + 1][arr.get(1) + 1] = list.get(i).dist;
				matrix[arr.get(1) + 1][arr.get(0) + 1] = list.get(i).dist;
			}
			
			
			
		}

		
		int[] minEdge = new int[count + 1];     // 다른 정점에서 자신으로 연결하는 간선 비용 중 최소 비용

        for(int i = 1 ; i < count + 1 ; i++) {
            minEdge[i] = Integer.MAX_VALUE;  // 충분히 큰 값으로 초기화 (무한대);
        }

        int vertexCount = 0;  // 선택된 정점의 개수
        int result = 0;     // MST 비용 (구하고자 하는 값)
        minEdge[1] = 0;     // 임의의 시작점 비용 0 설정
        boolean[] visited = new boolean[count + 1];     // 신장트리에 선택된 여부

        // PQ
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.offer(new Vertex(1,0));    // 0번 정점부터 시작

        while(!queue.isEmpty()) {    // N개의 정점을 모두 연결

            // 신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점 선택
            Vertex minVertex = queue.poll();
            if(visited[minVertex.no]) continue;    // 이미 MST에 포함된 정점일 경우 넘어감

            // 선택된 정점을 신장트리에 포함시킴
            visited[minVertex.no] = true;

            // 비용 누적
            result += minVertex.weight;

            // 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선 비용을 따져보고 최소값 갱신
            for(int i = 1; i < count + 1 ; i++) {
                // 신장트리에 포함되지 않았고, 
                // 선택된 정점과 인접한 정점이며,
                // 선택된 정점과의 비용이 이전까지의 최소비용보다 작다면
                if(!visited[i] && matrix[minVertex.no][i] != 0 && minEdge[i] > matrix[minVertex.no][i]) {
                    minEdge[i] = matrix[minVertex.no][i];
                    queue.offer(new Vertex(i, matrix[minVertex.no][i]));
                }
            }
        }

        for(int i = 1 ; i < count + 1 ; i++) {
            if(!visited[i]) result = 0;
        }
        
        System.out.println(result == 0 ? -1 : result);
		
	}
	
    private static class Vertex implements Comparable<Vertex> {

        public int no;    // 정점 번호
        public int weight;    // MST에 포함된 정점들과 이 정점 사이의 간선 비용

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;    // 오름차순 정렬
        }
    }
	

	
	
	static void bfs(int startX, int startY, int num) {
		
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(startX, startY, -1, num, 0));
		visited[startY][startX] = true;
		map[startY][startX] = num;
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = cur.x + directions[i][0];
				int nextY = cur.y + directions[i][1];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
				
				if(visited[nextY][nextX]) continue;
				
				if(map[nextY][nextX] == 0) {
					bridgeQ.offer(new Pos(nextX, nextY, i, num, 0));
					continue;
				}
				
				queue.offer(new Pos(nextX, nextY, -1, num, 0));
				visited[nextY][nextX] = true;
				map[nextY][nextX] = num;
			}
		}
	}
	
	static void makeBridge() {
		while(!bridgeQ.isEmpty()) {
			Pos pos = bridgeQ.poll();
			
			int nextX = pos.x + directions[pos.directions][0];
			int nextY = pos.y + directions[pos.directions][1];
			
			if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
			
			if(map[nextY][nextX] != 0) {
				int destination = map[nextY][nextX];
				int start = pos.num;
				
				String b = Integer.toBinaryString((1 << start - 1) | (1 << destination - 1));
				
				if(hashMap.containsKey(b)) {
					int dist = hashMap.get(b);
					if(dist > 1) {
						hashMap.put(b, Math.min(dist, pos.count + 1));
					}
					else {
						hashMap.put(b, pos.count + 1);
					}
				}
				else {
					hashMap.put(b, pos.count + 1);
				}
				
				continue;
			}
			
			bridgeQ.offer(new Pos(nextX, nextY, pos.directions, pos.num, pos.count + 1));
		}
	}
}