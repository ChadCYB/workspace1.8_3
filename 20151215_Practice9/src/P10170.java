import java.util.Scanner;

public class P10170 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while (scn.hasNext()) {
			long people = scn.nextLong();
			long day = scn.nextLong();
			
			long D = 0;
			while(D<day){
				D += people++;
//				people++;
//				System.out.println(D+":"+people);
			}
			System.out.println(--people);
		}
	}
}
