package com.wrox.algorithms.queues;

public class CallGenerator {

	private final CallCenter callCenter;
	private final int numberOfCalls;
	private final int maxCallDuration;
	private final int maxCallInterval;

	public CallGenerator(CallCenter callCenter, int numberOfCalls, 
			int maxCallDuration, int maxCallInterval) {
		assert callCenter != null : "callCenter can’t be null";
		assert numberOfCalls > 0 : "numberOfCalls can’t be < 1";
		assert maxCallDuration > 0 : "maxCallDuration can’t be < 1";
		assert maxCallInterval > 0 : "maxCallInterval can’t be < 1";

		this.callCenter = callCenter;
		this.numberOfCalls = numberOfCalls;
		this.maxCallDuration = maxCallDuration;
		this.maxCallInterval = maxCallInterval;
	}

	public void generateCalls() {
		for (int i = 0; i < numberOfCalls; ++i) {
			sleep();
			callCenter.accept(new Call(i, (int) (Math.random() * maxCallDuration)));
		}
	}

	private void sleep() {
		try {
			Thread.sleep((int) (Math.random() * maxCallInterval));
		} catch (InterruptedException e) {
			
		}
	}

}
