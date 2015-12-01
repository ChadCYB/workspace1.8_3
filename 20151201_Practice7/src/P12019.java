import java.util.Calendar;
import java.util.Scanner;

public class P12019 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		while(num-->0){
			int m = scn.nextInt();
			int d = scn.nextInt();
			Calendar c = Calendar.getInstance();
			c.set(2011, m-1, d);
			System.out.println(getDayOfWeek(c));
		}
	}

	public static String getDayOfWeek(Calendar cal) {
		String strWeek = null;
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			strWeek = "Sunday";
			break;
		case Calendar.MONDAY:
			strWeek = "Monday";
			break;
		case Calendar.TUESDAY:
			strWeek = "Tuesday";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "Wedesday";
			break;
		case Calendar.THURSDAY:
			strWeek = "Thursday";
			break;
		case Calendar.FRIDAY:
			strWeek = "Friday";
			break;
		case Calendar.SATURDAY:
			strWeek = "Saturday";
			break;
		}
		return strWeek;
	}
}
/*
8
1 6
2 28
4 5
5 26
8 1
11 1
12 25
12 31

----------
Thursday
Monday
Tuesday
Thursday
Monday
Tuesday
Sunday
Saturday
*/