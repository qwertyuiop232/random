package rpg;

import java.util.Arrays;

public class Input {
	
	Processing processing = new Processing(); 

	private String in, out;
	private static final String[] commands = { "/assign/strength","/restart", "/assign/vitality","/fight", "/heal", "/advance", "/run", "/assign/luck", "/start", "/stats"};
	
	
	public Input() {
	in = null;	
	out = null;
	}
		
	public void setInput(String userInput) {
		in = userInput.toLowerCase();
		
				  
		  if (Arrays.asList(commands).contains(in)) {
				processing.setProcess(in);
				out = processing.getOutput();
		  }
		  	else 
			  if (in.equals("/help")) 
					out = "/stats, /advance, /fight , /heal, /quit, /run, /start, /restart, /assign/(strength luck or vitality) ";
				else
					if (in.equals("/quit"))
						out = "See you next time!";
					else
						out = "invalid command. Type /help for commands";
		 
	}
		 
	public String getOutput() {	
		return out;
	}

}
		

		
