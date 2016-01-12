
public class Node {
	public int data;
	public Node next;
	
	public Node(){ }
	public Node(int data){
		this.data = data;
	}
	public void addNode(Node addN){
		if(this.next == null){
			this.next = addN;
		}else{
			this.next.addNode(addN);
		}
	}
}
