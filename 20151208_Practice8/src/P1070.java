import java.util.ArrayList;
import java.util.Scanner;

public class P1070 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<Obj> arr = new ArrayList<Obj>();
		while(scn.hasNext()){
//		for(int a=0; a<7;a++){
			String id = scn.next();
			int a1 = scn.nextInt();
			int a2 = scn.nextInt();
			int a3 = scn.nextInt();
			arr.add(new Obj(id,a1,a2,a3));
		}
		int len = arr.size();
		for (int i = 0; i<len; i++) {
			int tt = 0;
			for (int j = 0; j<len; j++) {
				if(i!=j){						//自己不須判斷
					Obj o1 = arr.get(i);
					Obj o2 = arr.get(j);
					if(Dominate(o2,o1)) tt++;	//可被其他人支配
//					System.out.println(o2.id+":"+o1.id+"\t"+Dominate(o2,o1));
				}						
			}
			if(tt==0)arr.get(i).show();			//如果沒有被任何人支配 
		}
	}
	public static boolean Dominate(Obj ele1, Obj ele2){
//		System.out.println(ele1.v1+":"+ele1.v2+":"+ele1.v3);
//		System.out.println(ele2.v1+":"+ele2.v2+":"+ele2.v3+"\n");
		if(ele1.v1==ele2.v1 && ele1.v2==ele2.v2 && ele1.v3==ele2.v3){
			//一樣大->可被支配 
			return false;
		}else if(ele1.v1>=ele2.v1 && ele1.v2>=ele2.v2 && ele1.v3>=ele2.v3){
			//一樣大+至少一樣更大->不可被支配
			return true;
		}else{
			//比較小->不可被支配
			return false;
		}
	}
}
class Obj{
	public String id;
	public int v1,v2,v3;
	public Obj(String S, int a, int b, int c){
		id = S;
		v1 = a;
		v2 = b;
		v3 = c;
	}
	public void show(){
		System.out.println(id+" "+v1+" "+v2+" "+v3);
	}
}

/*
// test case 1 (a=7)
A 7 8 9
B 5 8 5
C 1 2 8
D 6 8 9
E 9 5 4
F 4 9 5
G 3 6 6 

//test case 2 (a=8)
A 6 7 8
B 5 8 4
C 1 7 5
D 6 8 9
E 9 5 9
F 4 9 4
G 3 6 7
H 4 8 9

// test case 3 (a=10)
A 7 8 9
B 5 8 5 
C 1 2 8
D 6 8 9
E 9 5 4
F 4 9 5
G 3 6 6
H 8 8 8
I 7 8 9
J 4 5 6 

----------------
// test case 1
A 7 8 9
E 9 5 4
F 4 9 5 

// test case 2
D 6 8 9
E 9 5 9
F 4 9 4

// test case 3
A 7 8 9
E 9 5 4 
F 4 9 5
H 8 8 8
I 7 8 9

// test case 4
A 7 8 9
B 5 7 2
C 1 2 4
D 6 1 5
E 9 5 4
F 1 9 6
G 3 6 8 

A 6 7 9
B 5 8 4
C 4 7 5
D 6 8 9
E 9 4 9
F 4 9 4
G 3 6 4
H 4 3 9
*/