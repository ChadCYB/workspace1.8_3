import java.util.Scanner;

public class P272 {
	private static boolean count = false;
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		while(scn.hasNextLine()){
			String temp,output = "";
			String str = scn.nextLine();
			
			int len = str.length();
			for(int i=0 ; i<len ; i++){
				temp = str.substring(i, i+1);

				if(temp.equals("\"")){
					count = !count;
					temp = count?"``":"''";		//後面'' : 前面``
				}
				output += temp;
			}
			
			System.out.println(output);
		}
	}
}
/*
"To be or not to be," quoth the Bard, "that
is the question".
The programming contestant replied: "I must disagree.
To `C' or not to `C', that is The Question!"

---------------------
``To be or not to be,'' quoth the Bard, ``that
is the question''.
The programming contestant replied: ``I must disagree.
To `C' or not to `C', that is The Question!''

*/