import java.util.Scanner;

public class ptc_01 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int caseNum = 1, rangeNum = 1;
		while(caseNum!=0 && rangeNum!=0){
			caseNum = scn.nextInt();
			rangeNum = scn.nextInt();
			if(caseNum==0 && rangeNum==0) break;
			int[] data = new int[caseNum];
			for(int i=0 ; i<caseNum ; i++){
				data[i] = scn.nextInt();
			}
			System.out.println(Algorithm(rangeNum,data));
			System.out.println(maxDiff(data,rangeNum));
		}
	}

	private static int Algorithm(int rangeNum, int[] data) {
		int realMax = Integer.MIN_VALUE;
		for(int i=data.length-1 ; i>0 ; i--){
			realMax = Math.max(realMax, findMax(i,rangeNum,data));
		}		
		return realMax;
	}
	private static int findMax(int target, int range,int[] data){
		int max = Integer.MIN_VALUE;
		int mainNum = data[target];
		for(int i=target-1 ; i>=target-range && i>=0 ; i--){
			max = Math.max(max, mainNum-data[i]);
		}
		return max;
	}
	private static int maxDiff(int[] a, int rangNum) {
		int maxDiff = -1;
		int[] leftMin = new int[a.length], rightMax = new int[a.length];

		leftMin[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			leftMin[i] = Math.min(a[i], leftMin[i - 1]);
		}
		System.out.println("L");
		rightMax[a.length - 1] = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(a[i], rightMax[i + 1]);
		}
		System.out.println("R");
		// traverse both arrays from left to right to find maximum j - i
		for (int i = 0, j = 0; i < a.length && j < a.length;) {
			if(Math.abs(i-j)>= rangNum){
				if (rightMax[j] > leftMin[i]) {
					maxDiff = Math.max(maxDiff, j - i);
					j++;
				} else {
					i++;
				}
			}
		}
		return maxDiff;
	}
}
