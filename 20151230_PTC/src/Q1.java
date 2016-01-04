import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			
			int arr_count = scn.nextInt();
			int range = scn.nextInt();
			
			if(arr_count == 0 || range == 0) {
				
				run = false;
				
				break;
				
			}
			
			int difference = Integer.MIN_VALUE; 
			
			int[] arr = new int[arr_count];
			
			for(int i = 0 ; i < arr_count ; i++) {
				
				arr[i] = scn.nextInt();
				
			}
			
			if(range > arr_count) {
				
				difference = 0;
				
			} else {
				
				for(int i = 0 ; i < (arr_count - range) ; i++) {
					
					int[] mask_arr = new int[range + 1];
					
					int tmp = Integer.MIN_VALUE;
					
					
					for(int j = 0 ; j < mask_arr.length ; j++) {
						
						mask_arr[j] = arr[i+j];
					
						for(int k = 0 ; k < j ; k++) {
							
							int x = mask_arr[j] - mask_arr[k];
							
							if(x > tmp) {
								
								tmp = x;
								
							}
							
						}
						
					}
					
					if(tmp > difference) {
						
						difference = tmp;
						
					}
					
				}
				
				
			}
			
			System.out.println(difference);
			
		}

	}

}
