
public class hw04_1 {
	private static Object p;
	public hw04_1(){
		
	}
	public static int length(){
		int len = 0;
		p = head.next;
		while(p != null){
			len++;
			p = p.next;
		}
		return len;
	}
	
	public static node search(int num){
		p = head.next;
		target = null;
		while(p != null){
			if(p.data == num){
				return p;
				break;
			}else{
				p = p.next;
			}
		}
		return null;
	}
	
	public static void invert(){
		forward = head.next;
		current = null;
		while(forward != null){
			prev = current;
			forward = forward.next;
			current.next = prev;
		}
		head.next = current;
	}
	public static void delete(int num){
		previous = null;
		currrent = head.next;
		while(currrent.next != null){
			previous = current;
			currrent = p;
			forward = p.next;
			if(current.data == num){
				previous = current;
				current = current.next;
				break;
			}
		}
	}
	public static void delete(int num){
		p = head.next;
		while(p.next != null){
			if(p.next == num){
				p.next = p.next.next;
				break;
			}
			p = p.next;
		}
	}
}
