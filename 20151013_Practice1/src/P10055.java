import java.util.Scanner;

public class P10055 {
	public static void main(String[] arg){
		Scanner scn = new Scanner(System.in);
		
		while(true){
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			int v3 = Math.abs(v2-v1);
			System.out.println(v3+"");
		}
	}
}
