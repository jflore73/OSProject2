import java.util.*;
public class Queue{
	private ArrayList<Integer> order=new ArrayList<Integer>();
	public Queue() {
		
	}
	public void queue(int i) {
		order.add(i);
		System.out.println(order);
	}
	public void requeue() {
		order.add(order.getFirst());
		order.removeFirst();
		System.out.println(order);
	}
	public void dequeue() {
		order.removeFirst();
		System.out.println(order);
	}
	public int nextProcess() {
		return order.getFirst();
	}
	
}