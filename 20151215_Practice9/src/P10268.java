import java.util.Scanner;

public class P10268 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while (scn.hasNext()) {
			int x = scn.nextInt();
			scn.nextLine(); // eat '\n'
			String[] a = scn.nextLine().split("\\s+");
			int n = a.length;

			int ans = 0;
			int xPow = 1;
			for (int i = a.length-2; i>=0; --i, xPow *= x) {
				ans += Integer.valueOf(a[i]) * (n - i - 1) * xPow;
//				System.out.println(ans);
			}
			System.out.println(ans);
		}
	}
}
/*
-----Input------
7
1 -1
2
1 1 1

-----Output-----
1
5

 */