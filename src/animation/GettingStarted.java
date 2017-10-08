package animation;
import java.awt.*;



public class GettingStarted extends Frame{
	private static final long serialVersionUID = 1L;
	
	public static void main(String [] args) {
		GettingStarted frame = new GettingStarted();
		frame.setTitle("My AWT Frame");
		frame.setSize(600, 600);
		frame.setLayout(new FlowLayout());
		//add components		
		
		Label label = new Label("Name");
		frame.add(label);
		
		TextField textfield = new TextField();
		frame.add(textfield);
		
		Button button = new Button();
		frame.add(button);
		
		frame.setVisible(true);
		


	}

}
