package com.wrox.algorithms.queues;


import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

public class CallCenter {
	
	private final Queue<Call> calls = new BlockingQueue<>(new ListFifoQueue<>());
	private final List<Thread> threads;
	private final int numberOfAgents;
	
	public CallCenter(int numberOfAgents) {
		// TODO Auto-generated constructor stub
		this.threads = new ArrayList<>(numberOfAgents);
		this.numberOfAgents = numberOfAgents;
	}
	
	public void open() {
		assert this.threads.isEmpty() : "Already open";
		System.out.println("Call center opening");
		
		for (int i = 0; i < this.numberOfAgents; i++) {
			Thread thread = new Thread(new CustomerServiceAgent(calls, i));
			thread.start();
			this.threads.add(thread);
		}
		System.out.println("Call center open");
	}
	
	public void accept(Call call) {		
		assert !this.threads.isEmpty() : "Not open";
		
		calls.enqueue(call);
		System.out.println(call + " qeued" );
	}
	
	public void close() {
		System.out.println("Call center closing");
		for (int i = 0; i < this.numberOfAgents; i++) {
			accept(CustomerServiceAgent.GO_HOME);
		}
		Iterator<Thread> i = this.threads.iterator();
		for (i.first(); !i.isDone(); i.next()) {
			waitForTermination(i.current());
		}
		this.threads.clear();
		System.out.println("Call center closed");
	}
	
	private void waitForTermination(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
