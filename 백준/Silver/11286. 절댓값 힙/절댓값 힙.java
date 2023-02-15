import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int absNum;
	int num;
	
	Node(int absNum, int num){
		this.absNum = absNum;
		this.num = num;
	}
}

public class Main {
	static int N, M, R;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.absNum - o2.absNum < 0) {
					return -1;
				}
				else if(o1.absNum - o2.absNum > 0) {
					return 1;
				}
				else {
					if(o1.num - o2.num > 0) {
						return 1;
					}
					else {
						return -1;
					}
				}
			}
		});
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num != 0) {
				queue.add(new Node(Math.abs(num), num));
			}
			else {
				if(queue.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(queue.poll().num).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}