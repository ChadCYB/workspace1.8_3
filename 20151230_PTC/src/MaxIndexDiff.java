public class MaxIndexDiff {


	public static int maxDiff(int[] a, int rangNum) {
		int maxDiff = -1;
		int[] leftMin = new int[a.length], rightMax = new int[a.length];

		leftMin[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			leftMin[i] = Math.min(a[i], leftMin[i - 1]);
		}

		rightMax[a.length - 1] = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(a[i], rightMax[i + 1]);
		}

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