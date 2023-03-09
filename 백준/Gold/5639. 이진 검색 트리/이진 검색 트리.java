import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node{
	int num;
	Node rightNode;
	Node leftNode;
	
	Node(int num){
		this.num = num;
		this.rightNode = null;
		this.leftNode = null;
	}
	
	void concat(int num) {
		if(this.num > num) {
			if(this.leftNode == null) {
				this.leftNode = new Node(num);
			}
			else {
				this.leftNode.concat(num);
			}
		}
		else {
			if(this.rightNode == null) {
				this.rightNode = new Node(num);
			}
			else {
				this.rightNode.concat(num);
			}
		}
	}
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        String str = in.readLine();
        
        Node root = new Node(Integer.parseInt(str));
        while((str = in.readLine()) != null) {
        	root.concat(Integer.parseInt(str));
        }
        
        postOrder(root);
    }
    
    static void postOrder(Node node) {
		
    	if(node == null) {
    		return;
    	}
    	
    	
    	
    	postOrder(node.leftNode);
    	postOrder(node.rightNode);
    	System.out.println(node.num);
	}
    
}