import java.util.Scanner;
public class hw01_1 {
	public static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("n = ");
		int n = scn.nextInt();
		System.out.println("n\tc\tt");
		System.out.println(n+"\t"+fuc2(n,0)+"\t"+2);
		System.out.println(n+"\t"+fuc3(n)+"\t"+1);
	}
	public static int fuc1(int n){
		return (n<1) ? 1: (n * fuc1(n-1));
	}
	public static int fuc2(int n, int count){
		++count;
		if(n<=1){
			return ++count;
		}else{
			return fuc2(n-1,++count);
		}
	}
	public static int fuc3(int n){
		int sum = 1;
		int count = 1;
		for(int i=1 ; i<=n ; i++, count++){
			count++;
			sum *= i;
		}
		return count;
	}
}
