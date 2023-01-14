package solution_D5_common_ancestor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class Node{
	int num;
	int level;
	LinkedList<Node> child;
	boolean visit;
	
	Node(int num){
		this.level = 0;
		this.num = num;
		this.child = new LinkedList<Node>();
		this.visit = false;
	}
	
	void connectNode(Node childNode) {
		if(!this.child.contains(childNode)) {
			this.child.add(childNode);
		}
	}
}


public class Solution {
	static int nodeNum1;
	static int nodeNum2;
	static int[] result;
	static Node[] nodes;
	static boolean find;
	static int treeCount; 
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/solution_D5_공통조상/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String[] split = in.readLine().split(" ");
			int V = Integer.parseInt(split[0]);
			int E = Integer.parseInt(split[1]);
			nodeNum1 = Integer.parseInt(split[2]);
			nodeNum2 = Integer.parseInt(split[3]);
			nodes = new Node[V + 1];
			
			sb.append("#" + testCase + " ");
			
			//1. 노드 만든 후 배열 저장
			for(int i = 1; i <= V; i++) {
				nodes[i] = new Node(i);
			}
			
			Node root = nodes[1];
			
			//2. 노드로 트리만들기
			
			String[] splitE = in.readLine().split(" ");
			
			for(int i = 0; i < 2*E; i++) {
				int parentNum = Integer.parseInt(splitE[i]);
				int childNum = Integer.parseInt(splitE[++i]);
				Node parent = nodes[parentNum];
				Node child = nodes[childNum];
			
				parent.connectNode(child);
			}
			
			setLevel(root, 0);
			
			Node[] test = nodes;
			//3. BFS를 사용하여 두정점의 부모 리스트를 구하기
			result = new int[V + 1];
			find = false;
			bfs(result, root, nodeNum1);
			find = false;
			bfs(result, root, nodeNum2);
			
			Node nearNode = nearParent(result);
			treeCount = 0;
			
			getTreeSize(nearNode);
			
			sb.append(nearNode.num + " " +treeCount).append("\n");
		}
		
		System.out.println(sb);
	}
	static void setLevel(Node node, int level) {
		node.level = level;
		if(node.child.isEmpty()) {
			return;
		}
		for(int i = 0; i < node.child.size(); i++) {
			setLevel(node.child.get(i), level + 1);
		}
	}
	static Node nearParent(int[] result) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i < result.length; i++) {
			if(result[i] == 2) {
				list.add(i);
			}
		}
		
		int max = Integer.MIN_VALUE;
		Node nearNode = new Node(-1);
		
		for(int i = 0; i < list.size(); i++) {
			if(nodes[list.get(i)].level >= max) {
				max = nodes[list.get(i)].level;
				nearNode = nodes[list.get(i)];
			}
		}
		
		return nearNode;
	}
	
	static void getTreeSize(Node root) {
		treeCount++;
		
		if(root.child.isEmpty()) {
			return;
		}
		for(int i = 0; i < root.child.size(); i++) {
			getTreeSize(root.child.get(i));
		}
	}
	
	static void bfs(int[] result, Node parent, int findNum) {
		//
		if(parent.num == findNum) {
			find = true;
			result[parent.num]++;
			return;
		}
		//마지막 노드라면 종료
		if(parent.child.isEmpty()) {
			return;
		}
		for(int i = 0; i < parent.child.size(); i++) {
			if(!find) {
				Node child = parent.child.get(i);
				bfs(result, child, findNum);
			}
			if(find) {
				result[parent.num]++;
				return;
			}
		}
	}
}
