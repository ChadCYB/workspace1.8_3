import java.util.Scanner;
public class P10929 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(true){
			String str = scn.nextLine();
			if(str.equals("0")) break;
			char[] arr = str.toCharArray();
			boolean tt = false;
			int a=0,b=0;
			for(char i:arr){
				if(tt){
					a += Integer.parseInt(i+"");
				}else{
					b += Integer.parseInt(i+"");
				}
				tt = !tt;
			}
			if((Math.abs(a-b)%11) == 0){
				System.out.println(str+" is a multiple of 11.");
			}else{
				System.out.println(str+" is not a multiple of 11.");
			}
		}
	}

}
