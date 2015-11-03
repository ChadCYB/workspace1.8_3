import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p10008 {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String str = "";
		while(n-->=0){
			str+=scn.nextLine();
		}
		str = filterDate(str.toUpperCase());
//		System.out.println(str);
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0 ; i<str.length() ; i++){
			String s = str.substring(i,i+1);
			map.put(s, (map.get(s)!=null)?map.get(s)+1:1);
		}
		//將Map集合轉換成List集合，而List使用ArrayList來實現
		List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
		//Collections.sort(List l, Comparator c)方法進行排序
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
				//降冪排序(o2.getValue() - o1.getValue())
				//升冪排序(o1.getValue() - o2.getValue())
				return (o2.getValue() - o1.getValue());
			}
		});
//		for (Object key : map.keySet()) {
//			System.out.println(key + " : " + map.get(key));
//		}
		for (Entry key : list) {
			System.out.println(key.getKey() + " " + key.getValue());
		}
	}
	public static String filterDate(String str) {
		String filter = "[^A-Z]"; 		// 指定要過濾的字元
		Pattern p = Pattern.compile(filter);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim(); // 將非上列所設定的字元全部replace 掉
	}
}
/*
--Input--
3
This is a test.
Count me 1 2 3 4 5.
Wow!!!! Is this question easy?
--Output--
S 7
T 6
I 5
E 4
O 3
A 2
H 2
N 2
U 2
W 2
C 1
M 1
Q 1
Y 1
*/