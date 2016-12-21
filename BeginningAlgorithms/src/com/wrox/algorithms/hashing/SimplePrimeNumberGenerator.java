package com.wrox.algorithms.hashing;

public class SimplePrimeNumberGenerator implements PrimeNumberGenerator {
	
	public static final SimplePrimeNumberGenerator INSTANCE = new SimplePrimeNumberGenerator();

	private  SimplePrimeNumberGenerator() {
		// TODO Auto-generated constructor stub
	}		
	@Override
	public int generate(int candidate) {
		int prime = candidate;
		while(!isPrime(prime)){
			prime ++;
		}		
		return prime;
	}
	private boolean isPrime(int number) {
		// TODO Auto-generated method stub
		for(int i = number / 2; i >= 2; i --){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}

}
