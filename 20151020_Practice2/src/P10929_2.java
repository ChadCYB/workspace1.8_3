import java.math.BigInteger;
import java.util.Scanner;

public class P10929_2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (true) {
			String a = scn.nextLine();
			if(a.equals("0"))break;
			BigInteger bigInstance = new BigInteger(a);
			BigInteger ans = bigInstance.divideAndRemainder(new BigInteger("11"))[1];
			if(ans.equals(new BigInteger("0"))){
				System.out.println(bigInstance + " is a multiple of 11.");
			} else {
				System.out.println(bigInstance + " is not a multiple of 11.");
			}
		}
	}
}
