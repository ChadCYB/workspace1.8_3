import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ptc_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int caseNum = 1, rangeNum = 1, pre, now;
		boolean isFirst = true, allSame = true;
		while (caseNum != 0 && rangeNum != 0) {
			caseNum = scn.nextInt();
			rangeNum = scn.nextInt();
			
			if (caseNum == 0 && rangeNum == 0)	break;
			rangeNum = (rangeNum > caseNum)?caseNum:rangeNum;
			// int[] data = new int[caseNum-1];
			ArrayList<Integer> arr = new ArrayList<Integer>();
			pre = scn.nextInt();
			for (int i = 1; i < caseNum; i++) {
				now = scn.nextInt();
				arr.add(now - pre);
				// data[i-1] = now-pre;
				pre = now;
				if(allSame){
//					System.out.println("same:"+i);
					allSame = arr.get(0).equals(arr.get(i-1));
				}	
			}
			if (rangeNum == 2){
				System.out.println(Collections.max(arr));
			} else if(allSame){
				System.out.println(arr.get(0));
			} else {
				int max = Integer.MIN_VALUE;
				System.out.println("arr:\t"+arr);
				for (int i = rangeNum; i < arr.size()+1; i++) {
					ArrayList<Integer> subArr = new ArrayList<Integer>(arr.subList(i - rangeNum, i));
					
					max = Math.max(max, GetMax(subArr));
//					System.out.println("sub:\t"+subArr+"\tcal:"+GetMax(subArr));

				}
				System.out.println(max);
				allSame = true;
			}
		}
	}
	//Kadane'sºtºâªk
	public static int GetMax(ArrayList<Integer> array) {
		int sum = Detect(array);
		if (sum < 0)
			return sum;
		int max = array.get(0);
		for (int i = 0; i < array.size(); ++i) {
			sum += array.get(i);
			sum = Math.max(0, sum);
			max = Math.max(sum, max);
		}
		return max;
	}
	private static int Detect(ArrayList<Integer> array) {
		int max = array.get(0);
		for (int i = 0; i < array.size(); ++i) {
			if (array.get(i) >= 0)	return 0;
			max = Math.max(array.get(i), max);
		}
		return max;
	}

}
