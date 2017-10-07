package rpg2;

import java.util.Scanner;

/**
 * A simple rpg for fighting, level up, heal, skill points
 * @author qwertyuiop1
 * 
 * create benchmarks to upscale the exp and dmg
 * 
 * 
 * 
 */

public class Main {
	
	public static void main(String[] args) {
		
		String out;
		
		//set scanner 
		Scanner scanner;
		scanner = new Scanner(System.in);
		
		//set inputs
		Input input;
		String userInput;
		input = new Input();
		
		//create game state
		Boolean isRunning = true;
		
		//start game
		System.out.println("Welcome! Type /start to get started");
		System.out.println("Type /help for commands");
		
		do {
		
			userInput = scanner.nextLine();			
			input.setInput(userInput);
			out = input.getOutput();


			if (userInput.equals("/quit")) {
				isRunning = false;
				scanner.close();
				out = "See you next time!";
			}			
			
			System.out.println(out);
			
			
		}
		while (isRunning);
		
	}
}
	