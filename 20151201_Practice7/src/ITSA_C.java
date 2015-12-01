import java.util.Scanner;

public class ITSA_C {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextInt()) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			double len = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));	//¶ê¤ß¶ZÂ÷
//			System.out.println(len);
			System.out.println((len <= 100) ? "inside" : "outside");
		}
	}
}

/*
50 50
200 200

----------
inside
outside

*/