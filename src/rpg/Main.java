package rpg;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//set up character
		PlayerStats stats;
		stats = new PlayerStats();
		
		//set up enemy
		Enemy enemy;
		
		//set scanner 
		Scanner scanner;
		scanner = new Scanner(System.in);
		
		//set inputs
		Input input;
		String userInput;
		input = new Input();
		
		//create game states
		boolean running = true;
		
		//start game
		System.out.println("Welcome");
		System.out.println("Type /help for commands");
		
		do {
		
			userInput = scanner.nextLine();

			
			input.setInput(userInput);
			System.out.println(input.getOutput());
			
			if (userInput.equals("/quit")) 
				running = false;
			
		}
		while (running == true);
	}
	

}
