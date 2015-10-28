import java.util.Scanner;
public class P10101 {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		int count = 0;
		while(true){
			String strKuti = "";
			Long input = scn.nextLong();
			if(input == 0){
				strKuti = "0";
			}else{
				Long[] num = Bangla(input);
				if(num[4] > 99){
					strKuti = toString(Bangla(num[4]))+"kuti ";
				}else{
					strKuti = (num[4]==0)? "" : num[4]+" kuti ";
				}
				strKuti = strKuti+toString(num);
				int len = strKuti.length();
				if(strKuti.substring(len-1,len).equals(" ")){
					strKuti = strKuti.substring(0,len-1);
				}
				for(long l:num){
					System.out.println(l);
				}
				for(long l:Bangla(num[4])){
					System.out.println(l);
				}
			}
			System.out.println(++count+". "+strKuti);
		}
	}

	public static String toString(Long[] num){
//kuti' (10000000), 'lakh' (100000), 'hajar' (1000), 'shata' (100)
		String str = "";
//		str += (num[4]!=0)? num[4]+" kuti " :"";
		str += (num[3]!=0)? num[3]+" lakh " :"";
		str += (num[2]!=0)? num[2]+" hajar " :"";
		str += (num[1]!=0)? num[1]+" shata " :"";
		str += (num[0]!=0)? num[0]+" " :"";
		return str;
	}
	public static Long[] Bangla(Long input){
		Long[] num = new Long[5];
		num[0] = input%100;
		num[1] = input%1000/100;
		num[2] = input%100000/1000;
		num[3] = input%10000000/100000;
		num[4] = input/10000000;
		return num;
	}
}
/*
99999999,99,99,9,99
999999999999999

23764
45897458973958
 */