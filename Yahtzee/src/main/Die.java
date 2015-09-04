package main;

import java.util.Random;



public class Die {

	private int val;
	private int sides;
	
	public Die(int side) {
		sides = side;
			
	}
	
	void roll() {
		
		Random rand = new Random();
		val = rand.nextInt((sides - 1) + 1) + 1;
		
	}
	
	int getVal() {
		return val;
	}
	
}
