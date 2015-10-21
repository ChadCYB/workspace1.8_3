import java.util.Scanner;

public class P10035 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (true) {
			String v1 = scn.next();
			String v2 = scn.next();
			if (v1.equals("0") && v2.equals("0")) break;
			int carry = 0;
			int len = Math.min(v1.length(), v2.length());
			for (int i = len; i > 0; i--) {
				int a1 = Integer.parseInt(v1.substring(i - 1, i));
				int a2 = Integer.parseInt(v2.substring(i - 1, i));
				if (a1 + a2 >= 10) carry++;
			}
			System.out.println(((carry == 0) ? "No" : carry) + " carry " 
							+ ((carry > 1) ? "operations." : "operation."));
		}
	}
}
