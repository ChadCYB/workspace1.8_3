
public class LinkedList {
	private static Node head;
	
	public static void main(String[] args) {
		int[] arr = {9,5,8,6,2,4,8,3,1};
		head = new Node(0);
		for(int i:arr){
//			System.out.println(i);
			head.addNode(new Node(i));
		}
		showAll(head);
		reverse(head);
		showAll(head);
	}
	public static void showAll(Node first){
		Node flag = first;
		while(flag != null){
			System.out.print(flag.data+",");
			flag = flag.next;
		}
		System.out.println();
	}
	public static void reverse(Node first){	//¤ÏÂà
		Node pre, current, next;
		pre = null;
		current = first.next;
		while(current != null){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		first.next = pre;	
	}
}