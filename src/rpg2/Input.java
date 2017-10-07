package rpg2;

import java.util.Arrays;

public class Input {
	
	Processing processing = new Processing(); 

	private String in, out;
	private static final String[] commands = { "/assign/strength","/restart", "/assign/vitality","/fight", "/heal", "/advance", "/flee", "/assign/luck", "/start", "/stats"};
	private boolean start;
	
	public Input() {
	in = null;	
	out = null;
	start = false;
	}
		
	public void setInput(String userInput) {
		in = userInput.toLowerCase();
		if (in.equals("/start")) 
			start = true;

		if (start == true) {
				  
		  if (Arrays.asList(commands).contains(in)) {
				processing.setProcess(in);
				out = processing.getOutput();
				if (processing.getUserHP() == 0) {
					start = false;
					out += " /start to play again or /quit to exit";
				}
		  }
		  	else 
			  if (in.equals("/help")) 
					out = "/stats, /advance, /fight , /heal, /quit, /flee," 
			  + System.lineSeparator() +"/start, /restart, /assign/(strength luck or vitality) "
			  + System.lineSeparator() + "** note healing costs 5 gold";
				else
					if (in.equals("/quit"))
						out = "See you next time!";
					else
						out = "invalid command. Type /help for commands";
		}
		else 
			out = "/start to start the game ";

		 
	}
		 
	public String getOutput() {	
		return out;
	}

}
		