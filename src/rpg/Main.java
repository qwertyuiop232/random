package rpg;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
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
			
			if (userInput.equals("/quit")) 
				running = false;
			
			input.setInput(userInput);
			System.out.println(input.getOutput());
			

			
		}
		while (running == true);
	}
	

}
