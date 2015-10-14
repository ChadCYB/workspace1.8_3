import java.util.Scanner;

public class P10041 {
	public static void main(String[] arg){
		Scanner scn = new Scanner(System.in);
		int caseN = scn.nextInt();
		while(caseN-->0){
			int relaNum = scn.nextInt();		//¾F©~¼Æ¶q
			int[] relatives = new int[relaNum];	//¾F©~°}¦C
			for(int i=0 ; i<relaNum ; i++){
				relatives[i] = scn.nextInt();
			}
			sort(relatives);
			int distance = 0;					//¶ZÂ÷
			for(int i:relatives){
				distance += Math.abs(i-relatives[relaNum/2]);
			}
			System.out.println(distance+"");
		}
		
	}
	public static void sort(int[] arr){
		for (int i = arr.length - 1; i > 0; --i){
            for (int j = 0; j < i; ++j){
                if (arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
