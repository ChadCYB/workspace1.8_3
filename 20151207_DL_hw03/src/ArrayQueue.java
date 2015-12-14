public class ArrayQueue<T> extends Queue<T> {

	private int capacity;
	private int first;
	private T[] array;

	public ArrayQueue() {
		this(10240);
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void offer(T value) {	//將資料放入佇列尾端
		if (count == array.length) {
			T[] newArray = (T[]) new Object[array.length + capacity];
			System.arraycopy(array, first, newArray, 0, array.length - first);
			System.arraycopy(array, 0, newArray, array.length - first, first);
			array = newArray;
			first = 0;
		}
		array[(first + count) % array.length] = value;
		++count;
	}

	@Override
	public T poll() 	{			//取出佇列前端之資料
		T value = array[first];
		array[first] = null;
		first = (first + 1) % array.length;
		--count;
		return value;
	}

	@Override
	public T peek() {				//看佇列前端的資料而不取出
		return array[first];
	}

}