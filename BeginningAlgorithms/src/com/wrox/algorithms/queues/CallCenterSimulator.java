package com.wrox.algorithms.queues;

public final class CallCenterSimulator {

	
	private CallCenterSimulator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		CallCenter callCenter = new CallCenter(20);
		CallGenerator generator = new CallGenerator(callCenter, 200, 1000, 100);
		callCenter.open();
		try {
			generator.generateCalls();
		} finally {
			callCenter.close();
		}
	}
}
