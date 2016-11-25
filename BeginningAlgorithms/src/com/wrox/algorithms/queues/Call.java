package com.wrox.algorithms.queues;

public class Call {
	
	private final int id;
	private final int duration;
	private final long startTime;
	
	public Call(int id, int duration) {
		// TODO Auto-generated constructor stub
		assert duration >= 0 : "duration can't be < 0";
		this.id = id;
		this.duration = duration;
		this.startTime = System.currentTimeMillis();
	}
	
	public void answer(){
		System.out.println(this + " answered; waited "
		+ (System.currentTimeMillis() - this.startTime)
		+ " milliseconds");
		
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Call " + id ;
	}

}
