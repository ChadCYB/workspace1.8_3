import java.util.Scanner;
public class ITSA_E {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		int c = scn.nextInt();
		while(c-->0){
			
			int len = scn.nextInt();
			int count = 1;
			int[][] arr = new int[len][len];
			for(int i = 0; i<len ; i++){
				for(int j= 0; j<len ; j++){
					arr[i][j] = count++;
				}	
			}
			
			String str = scn.next();
			for(int i=0 ; i<str.length() ; i++){
				switch(str.substring(i,i+1)){
					case "R":
						arr = trunRight(arr,len);
						break;
					case "L":
						arr = trunLeft(arr,len);
						break;
					case "N":
						arr = upSideDown(arr,len);
						break;
				}
			}
			for(int i=0 ; i<len ; i++){
				for(int j=0 ; j<len ; j++){
					System.out.print(arr[i][j]+ ((j==len-1)?"":" "));
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static int[][] trunRight(int[][] arr,int len){
		int[][] newArr = new int[len][len];
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				newArr[j][len-i-1] = arr[i][j];
			}
		}
		return newArr;
	}
	public static int[][] trunLeft(int[][] arr,int len){
		int[][] newArr = new int[len][len];
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				newArr[len-j-1][i] = arr[i][j];
			}
		}
		return newArr;
	}
	public static int[][] upSideDown(int[][] arr,int len){
		int[][] newArr = new int[len][len];
		for(int i=0 ; i<len ; i++){
			for(int j=0 ; j<len ; j++){
				newArr[len-i-1][j] = arr[i][j];
			}
		}
		return newArr;
	}
}

/*
2
3
RRNRLLRLNRLLL
2
RLLRNN

7 4 1
8 5 2
9 6 3

1 2
3 4

*/