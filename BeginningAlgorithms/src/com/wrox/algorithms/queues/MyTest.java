package com.wrox.algorithms.queues;

public class MyTest {

	public static void main(String[] args) {
		RandomQueue<Integer> q = new RandomQueue<>();
		for (int i = 1; i <= 10; i++) {
			q.enqueue(i);
		}
		
		for (int i = 1; i < 10; i++) {
			System.out.println(q.dequeue());
		}
	}

}
