import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
 
public class p10420 {
	public static void main(String arg[]){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String str = "";
		while(n-->=0){
			String[] arr = scn.nextLine().split(" ");
			str += arr[0]+" ";
		}
		String[] contry = str.split(" ");
//		System.out.println(str);
		ArrayList<String> arr = new ArrayList<String>();
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String s:contry){
			if(!s.equals("")){
				if(arr.indexOf(s)==-1) arr.add(s);				//���������ư�a��J����
				map.put(s, (map.get(s)!=null)?map.get(s)+1:1);	//��Jmap�i��έp
			}
		}
		Collections.sort(arr);				//�̰�a�r���Ƨ�
		for (String key : arr){				//�HArryList
			System.out.println(key + " " + map.get(key));
		}
	}
}
/*
--Input--
3
Spain Donna Elvira
England Jane Doe
Apain Donna Anna
--Output--
England 1
Spain 2
*/