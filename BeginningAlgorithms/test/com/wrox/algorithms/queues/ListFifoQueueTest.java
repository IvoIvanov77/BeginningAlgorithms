package com.wrox.algorithms.queues;

public class ListFifoQueueTest extends AbstractFifoQueueTestCase{

	@Override
	protected Queue<String> createFifoQueue() {
		// TODO Auto-generated method stub
		return new ListFifoQueue<String>() ;
	}

}
