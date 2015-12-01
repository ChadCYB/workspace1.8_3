import java.util.Scanner;

public class ITSA_D {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextInt()) {
			int num = scn.nextInt();
			double cal = Math.pow(num/100 , 3)+Math.pow(num%100/10 , 3)+Math.pow(num%10 , 3);
//			System.out.println(cal);
			System.out.println((num == cal) ? "Yes" : "No");
		}
	}
}

/*
153
456

----------
Yes
No

*/