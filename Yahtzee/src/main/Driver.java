package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		
		System.out.println("How many dice?");
		int temp= readIn("dice");
		if (temp == 0) {
			return;
		}
		int amount = temp;
		System.out.println("How many sides?");
		temp = readIn("sides");
		if (temp == 0) {
			return;
		}
		int sides = temp;
		long tStart = System.currentTimeMillis();
		Cup cup = new Cup(amount, sides);
		cup.rollAll();
		int[] report = cup.getReport();
		while (!cup.yahtzee(0)) {
			cup.rollAll();
		}
		System.out.println("Yahtzee!");
		for (int i = 0; i < amount; i++) {
			System.out.println(report[i]);
		}
		System.out.println("Rolls: " + cup.getRollCount());
		System.out.println("Sum: " + cup.sum());
		System.out.println(cup.yahtzee(0));
		long tEnd = System.currentTimeMillis();
		long tElap = tEnd - tStart;
		double elapsed = tElap / 1000.0;
		System.out.println("Elapsed Time: " + elapsed);
		return;
	}

	public static int readIn(String var) throws IOException, InterruptedException {
		int amount = 0;
		boolean isnum = false;
		int idiot = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (isnum == false) {
			try {
				amount = Integer.parseInt(br.readLine());
				isnum = true;
			} catch(NumberFormatException nfe) {
				if (idiot < 5) {
					idiot++;
					System.err.println("That is not a number.");
					Thread.sleep(500);
					System.out.println("Try again.");
					Thread.sleep(500);
					System.out.println("How many " + var + "?");
				} else {
					System.out.println("...");
					Thread.sleep(2000);
					System.out.println("Nope.");
					Thread.sleep(2000);
					System.out.println("I'm done.");
					Thread.sleep(2000);
					System.out.println("You are an idiot.");
					Thread.sleep(2000);
					System.out.println("Bye");
					System.err.println("The program is exiting");
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
					Thread.sleep(7000);
					System.out.println("Fuck you.");
					Thread.sleep(3000);
					System.err.println("Program Terminated");
					return 0;
				}
			}
		}
		return amount;
	}
}
