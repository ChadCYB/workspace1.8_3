import java.util.Scanner;

public class itsa_42 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int count = scn.nextInt();
		while (count-- > 0) {
			String str = scn.next();
			String ans = "";
			for (int i = str.length() - 1; i >= 0; i--) {
				char a = (char) str.charAt(i);
				char b = Character.toUpperCase(a);
				char c = Character.toLowerCase(a);
				if (b == a) {
					ans += c;
//					str = str.replace(a, c);
				} else if (c == a) {
					ans += b;
//					str = str.replace(a, b);
				}else{
					ans += a;
				}
			}
//			System.out.println(new StringBuilder(str).reverse().toString());
			System.out.println(ans);
		}

	}
}
