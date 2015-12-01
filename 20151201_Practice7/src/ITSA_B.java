import java.util.Scanner;

public class ITSA_B {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextInt()) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			System.out.println((x <= 100 && x >= 0 && y <= 100 && y >= 0) ? "indside" : "outside");
		}
	}
}

/*
10 20
150 150

----------
indside
outside
*/