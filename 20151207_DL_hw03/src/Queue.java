public abstract class Queue<T> {
	protected int count;

	abstract public void offer(T value);

	abstract public T poll();

	abstract public T peek();

	public int size() {
		return count;
	}
}