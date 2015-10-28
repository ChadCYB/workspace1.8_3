
public class hw02_1 {
	public static void main(String arg[]){
		double[] poly = readPoly(2,1000,1,4,10,3,3,2,1,0);
		printPoly(poly);
		System.out.println(peval(poly,2));
	}
	public static void printPoly(double[] poly){
		String str = "";
		for(int i=0 ; i<poly.length ; i++){
			if(i%2 == 0){
				if(poly[i] > 0){
					str+= ((i==0)?"":"+") + poly[i];
				}else if(poly[i] < 0){
					str+= ((i==0)?"":"-") + poly[i];
				}
			}else{
				if(poly[i] != 0){
					str += ("X^"+(int)(poly[i]));
				}
			}
		}
		System.out.println(str);
	}
	public static double[] readPoly(double... data){
		return data;
	}
	public static double peval(double[] poly, int x){
		double result = 0;
		for(int i=0 ; i<poly.length ; i+=2){
			result += poly[i]*Math.pow(x, poly[i+1]);
		}
		return result;
	}

}
