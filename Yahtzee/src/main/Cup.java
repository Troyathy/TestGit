package main;

public class Cup {
	
	private Die[] dice;
	private int[] report;
	private int rollcount;
	private int amt;
	
	public Cup(int amtf, int sides) {
		
		rollcount = 0;
		amt = amtf;
		report = new int[amt];
		dice = new Die[amt];
		for (int i = 0; i < amt; i++) {
			dice[i] = new Die(sides);
		}		
	}
	
	void rollAll() {
		int i = 0;
		for (Die die : dice) {
			die.roll();
			report[i++] = die.getVal();
		}
		rollcount++;
	}
	
	int[] getReport() {
		return report;
	}
	
	int getRollCount() {
		return rollcount;
	}
	
	int sum() {
		int sum = 0;
		for (int i = 0; i < amt; i++) {
			sum += report[i];
		}
		return sum;
	}
	
	boolean yahtzee(int i) {
		boolean yah;
		if (i == amt - 1) {
			yah = report[i] == report[i - 1];
			return yah;
			}
		else {
			yah = yahtzee(++i);
			if (yah) {
				yah = report[i] == report[i - 1];
				return yah;
			}
		}
		return yah;
	}
}
