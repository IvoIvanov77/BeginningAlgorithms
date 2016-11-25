package com.wrox.algorithms.queues;

public class CustomerServiceAgent implements Runnable {

	public static final Call GO_HOME = new Call(-1, 0);

	private final int id;
	private final Queue<Call> calls;

	public CustomerServiceAgent(Queue<Call> calls, int id) {
		// TODO Auto-generated constructor stub
		assert calls != null : "calls can't be null";
		this.calls = calls;
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this + " clocked on");
		while (true) {
			System.out.println(this + " waiting");
			Call call = this.calls.dequeue();
			System.out.println(this + " answering " + call);
			if (call == GO_HOME) {
				break;
			}
			call.answer();
		}
		System.out.println(this + " going home");

	}

	@Override
	public String toString() {
		return "Agent " + id;
	}

}
