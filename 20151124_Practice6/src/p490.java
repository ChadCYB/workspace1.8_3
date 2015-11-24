import java.util.ArrayList;
import java.util.Scanner;
public class p490 {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		while(scn.hasNextLine()){
			arr.add(scn.nextLine());
		}
		int max = 0;
		for(String s:arr){
			max = Math.max(s.length(), max);
		}
		for (int i=0 ; i<max ; i++) {
			for(int j = arr.size()-1 ; j>=0 ; j--){
				String str = arr.get(j);
				System.out.print((i < str.length()) ? str.substring(i, i+1):" ");
			}
			System.out.println();
		}
	}
}
