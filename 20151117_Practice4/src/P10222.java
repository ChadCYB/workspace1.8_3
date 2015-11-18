import java.util.Scanner;
public class P10222 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext()){
			String str = scn.next();
			if(str.equals("0")) break;
			System.out.println(fuc(str));
		}
	}
	public static String fuc(String str){
		int sum = 0;
		for(int i=0 ; i<str.length(); i++){
			sum += Integer.parseInt(str.substring(i,i+1));
		}
		String res = sum+"";
//		System.out.println(res);
		if(res.length() > 1){
			return fuc(res);
		}else{
			return res;
		}
	}
}
/*
2
11
47
1234567892
0

2
2
2
2
*/