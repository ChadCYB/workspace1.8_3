
public class hw_02 {
	public static void main(String[] args) {
		deque Que = new deque(10);
	}
	
	private static class deque{
		int cap;
		int flag = 0;
		int[] arr;
		public deque(int len){
			arr = new int[len];
		}
		public void moveBack(int val){		//佇列後移
			for(int i=flag-1 ; i>=0 ; i--){
				arr[i] = arr[i+1];
			}
			arr[0] = val;					//排入第一位置
		}
		public void moveForward(){			//佇列前移
			arr[flag-1] = (Integer) null;
			for(int i=0 ; i>flag-1 ; i--){
				arr[i] = arr[i+1];
			}
		}
		public boolean addFont(int val){	//由前方新增
			if(flag == arr.length){			//佇列已滿
				return false;
			}else{							//佇列未滿
				moveBack(val);				//後移排入
				flag++;						//指標+1
				return true;
			}
		}
		public boolean addBack(int val){	//由後方新增
			if(flag == arr.length){			//佇列已滿
				return false;
			}else{							//佇列未滿
				arr[flag] = val;			//排入
				flag++;						//指標+1
				return true;
			}
			
		}
		public boolean delFont(){			//由前方刪除
			flag--;
			if(flag >= 0){					//尚有佇列
				moveForward();
				return true;
			}else{							//佇列空
				return false;
			}
		}
		public boolean delBack(){			//由後方刪除
			flag--;
			if(flag >= 0){					//尚有佇列
				arr[flag] = (Integer) null;
				return true;
			}else{							//佇列空
				return false;
			}
		}
	}
}
