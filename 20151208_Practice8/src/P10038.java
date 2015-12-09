import java.util.Scanner;

public class P10038 {
	public static void main(String[] arg){
		Scanner scn = new Scanner(System.in);
		while(scn.hasNextLine()){
			String str = scn.nextLine();
			if(!str.equals("")){
				String outPut ="";
				String[] arr = str.split(" ");
				if(arr.length == 1){
					outPut = "Jolly";
				}else{
					boolean flag = false;
					for(int i=2 ; i<arr.length ; i++){
						int cal = Math.abs(Integer.parseInt(arr[i-1])-Integer.parseInt(arr[i]));
						if(cal > arr.length-1) flag = true;
					}
					outPut = ((flag)?"Not jolly":"Jolly");
				}
				System.out.println(outPut);
			}
		}
	}
}
/*
4 1 4 2 3
5 1 4 2 -1 6

-------------
Jolly
Not jolly

*/