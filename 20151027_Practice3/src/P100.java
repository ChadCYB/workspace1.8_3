import java.util.Scanner;
public class P100 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(scn.hasNextLong()){
			long startN = scn.nextLong();
			long endN = scn.nextLong();
			if(startN>endN){
				long temp = startN;
				startN = endN;
				endN = temp;
			}
			long max = 0;
			for(long i=startN ; i<=endN ; i++){
//				System.out.println(i+":\t"+algorithm(i,0));
				max = Math.max(max, algorithm(i,0));
			}
			System.out.println(startN+" "+endN+" "+max);
		}
	}
	public static long algorithm(long n, long count){
		count++;
		if(n == 1){
			return count;
		}else if(n%2 == 1){
			return algorithm(3*n+1 , count);
		}else{
			return algorithm(n/2 , count);
		}
	}
}
