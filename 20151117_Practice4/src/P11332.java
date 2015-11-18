import java.util.Scanner;

public class P11332 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext()){
			fuc(scn.nextLine());
		}
	}

	public static void fuc(String str) {
		String keyTable = "`1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./";
		String word = str.toLowerCase();
		int t;
		for (int i = 0; i < word.length(); i++) {
			t = keyTable.indexOf(word.charAt(i));
			if (t != -1) {
				System.out.print(keyTable.charAt(t - 2));
			} else {
				System.out.print(word.charAt(i));
			}
		}
		System.out.println();
	}
}
/*
k[r dyt I[o
'['
in great trouble
talking with a microphone
see a teacher

how are you
lol
yv dwq[e ewutcjq
e[jhyvd yef [ byzwuifuvq
]qq [ eq[zfqw
*/