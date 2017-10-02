package rpg;

public class Input {
	
	private String in, out;
	PlayerStats stats;
	Enemy enemy;
	Battle battle = new Battle();
	
	public Input() {
	in = null;	
	out = null;
	}
	public void setInput(String userInput) {
		in = userInput;

		if (in.equals("/help")) 
			out = "/fight , /heal, /quit";
			else
			 if (in.equals("/fight")) {
				battle.setFight();
				out = battle.getFight();
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

        		
	}
	public void setString1(String string1) {
		if (in.equals("/fight")) {
			
		}
	}

}
*/