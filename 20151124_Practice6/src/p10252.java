import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class p10252 {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext()){
			String str1 = scn.next();
			String str2 = scn.next();
			
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			ArrayList<String> sortArr = new ArrayList<String>();
			for(int i=0 ; i<str1.length() ; i++){
				String s = str1.substring(i,i+1);
				map.put(s, 1);
			}
			for(int i=0 ; i<str2.length() ; i++){
				String s = str2.substring(i,i+1);
				if(map.get(s)!=null){
					map.put(s,map.get(s)+1);
					if(map.get(s)==2) sortArr.add(s);	//¬ö¿ý¶¶§Ç
				}
//				map.put(s, (map.get(s)!=null)? ((map.get(s)==2)?2:map.get(s)+1) : 0);
//				if(map.get(s)==2){
//					sortArr.add(s);
//					map.put(s,map.get(s)+1);
//				}
			}
			Collections.sort(sortArr);
			for (String key : sortArr){
				System.out.print(key);
			}
			System.out.println();
		}
	}
}

/*
==Input==
pretty
women
walking
down
the
street

==Output==
e
nw
et
*/
