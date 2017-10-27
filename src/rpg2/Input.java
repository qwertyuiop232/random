package rpg2;

import java.util.Arrays;

class Input {
	
	Processing processing = new Processing(); 

	private String in, out;
	private static final String[] commands = { "/assign/strength", "/load", "/restart","/save", "/assign/vitality","/fight", "/heal", "/advance", "/flee", "/assign/luck", "/start", "/stats"};
	private boolean isStarted;
	
	Input() {
	in = null;	
	out = null;
	isStarted = false;
	}
		
	void setInput(String userInput) {
		in = userInput.toLowerCase();
		if (in.equals("/start")) 
			isStarted = true;

		if (isStarted) {
				  
		  if (Arrays.asList(commands).contains(in)) {
				processing.setProcess(in);
				out = processing.getOutput();
				if (processing.getUserHP() == 0) {
					isStarted = false;
					out += " /start to play again or /quit to exit";
				}
		  }
		  	else 
			  if (in.equals("/help")) 
					out = "/stats, /advance, /fight , /heal, /quit, /flee," 
			  + '\n' +"/start, /restart, /assign/(strength luck or vitality) "
			  + '\n' + "** note healing costs 5 gold";
				else
					if (in.equals("/quit"))
						out = "See you next time!";
					else
						out = "invalid command. Type /help for commands";
		}
		else 
			out = "/start to start the game ";

		 
	}
		 
	String getOutput() {
		return out;
	}

}
		