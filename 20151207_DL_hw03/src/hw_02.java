
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
		public void moveBack(int val){		//��C�Ჾ
			for(int i=flag-1 ; i>=0 ; i--){
				arr[i] = arr[i+1];
			}
			arr[0] = val;					//�ƤJ�Ĥ@��m
		}
		public void moveForward(){			//��C�e��
			arr[flag-1] = (Integer) null;
			for(int i=0 ; i>flag-1 ; i--){
				arr[i] = arr[i+1];
			}
		}
		public boolean addFont(int val){	//�ѫe��s�W
			if(flag == arr.length){			//��C�w��
				return false;
			}else{							//��C����
				moveBack(val);				//�Ჾ�ƤJ
				flag++;						//����+1
				return true;
			}
		}
		public boolean addBack(int val){	//�ѫ��s�W
			if(flag == arr.length){			//��C�w��
				return false;
			}else{							//��C����
				arr[flag] = val;			//�ƤJ
				flag++;						//����+1
				return true;
			}
			
		}
		public boolean delFont(){			//�ѫe��R��
			flag--;
			if(flag >= 0){					//�|����C
				moveForward();
				return true;
			}else{							//��C��
				return false;
			}
		}
		public boolean delBack(){			//�ѫ��R��
			flag--;
			if(flag >= 0){					//�|����C
				arr[flag] = (Integer) null;
				return true;
			}else{							//��C��
				return false;
			}
		}
	}
}
