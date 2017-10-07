package rpg2;

import java.util.Scanner;

/**
 * A simple rpg for fighting, level up, heal, skill points
 * @author qwertyuiop1
 * create counters for heal
 * balance damage values
 * balance experience points
 * 
 * create benchmarks to upscale the exp and dmg
 * 
 * lower crit chance
 * 
 * 
 */

public class Main {
	
	public static void main(String[] args) {
		
		//set scanner 
		Scanner scanner;
		scanner = new Scanner(System.in);
		
		//set inputs
		Input input;
		String userInput;
		input = new Input();
		
		//create game state
		boolean running = true;
		
		//start game
		System.out.println("Welcome! Type /start to get started");
		System.out.println("Type /help for commands");
		
		do {
		
			userInput = scanner.nextLine();
			
			if (userInput.equals("/quit")) {
				running = false;
				scanner.close();
			}			
			
			input.setInput(userInput);
			System.out.println(input.getOutput());
			
			
		}
		while (running == true);
		
	}
}
	