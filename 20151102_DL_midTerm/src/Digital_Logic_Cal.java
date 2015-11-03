
public class Digital_Logic_Cal {
	public static void main(String arg[]){
		int[] input = new int[4];
		System.out.println("abcd s p o o2\n-------------");
		for(int i=0 ; i < Math.pow(2, input.length) ; i++){
			int n = Integer.parseInt(Integer.toString(i,2));
			int n1,n2,n3,n4;
			n1 = n/1000;
			n2 = n/100%10;
			n3 = n/10%10;
			n4 = n%10;
			boolean a,b,c,d;
			a = (n1==1);
			b = (n2==1);
			c = (n3==1);
			d = (n4==1);
			System.out.println(n1+""+n2+""+n3+""+n4+" "+SOP(a,b,c,d)+" "+POS(a,b,c,d)+" "+cal2(a,b,c,d)+" "+cal3(a,b,c,d));
		}
	}
	public static int SOP(boolean a,boolean b,boolean c,boolean d){		//SOP
		return (a|b)&(a|c)&(a|d)&(b|c|d)?1:0;
	}
	public static int POS(boolean a,boolean b,boolean c,boolean d){		//POS
		return (a&b)|(a&c)|(a&d)|(b&c&d)?1:0;
	}
	public static int cal2(boolean a,boolean b,boolean c,boolean d){	//增加階數
		return (a|(b&c&d))&(b|c|d)?1:0;
	}
	public static int cal3(boolean a,boolean b,boolean c,boolean d){	//同一邏輯閘
		return n((n(!a,n(n(b,c),d))),n((!n(!b,!c)),!d))?1:0;
	}
	public static boolean n(boolean a , boolean b){						//nand gate
	    return (a ? !b : true);
	}
}
