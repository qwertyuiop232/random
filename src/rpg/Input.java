package rpg;

public class Input {
	
	private String in, out;
	Processing processing = new Processing(); 
	
	public Input() {
	in = null;	
	out = null;
	}
	public void setInput(String userInput) {
		in = userInput;
		String segments[] = in.split("/");

		if (in.equals("/help")) 
			out = "/fight , /heal, /quit";
			else
				if (in.equals("/quit"))
					out = "See you next time!";
				else
					if(in.equals("/fight") || in.equals("/heal") ) {
					
						processing.setProcess();
						processing.setOutput();
						out = processing.getOutput();
					}
						
		
		else 
			out = "invalid command";
	}
	public String getOutput() {	
		return out;
	}

}
		
		
		
		
/*        String segments[] = in.split("/");
        
        if (segments.length == 1) {
			setString1(in);
        }
        else 
        	if (segments.length == 2) {
        		
        	}
        	else 
        		if (segments.length == 3) {
        			
        		}
			 if (in.equals("/fight")) {
				battle.setFight();
				out = battle.getFight();
        		
	}
	public void setString1(String string1) {
		if (in.equals("/fight")) {
			
		}
	}

}
*/