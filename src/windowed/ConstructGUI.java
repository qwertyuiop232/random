package windowed;
import javax.swing.*;

public class ConstructGUI extends JFrame{
	JButton enter;
	JTextField input;
	JLabel output, showInput;
	
	
	public ConstructGUI(String title) {
		super (title);
		
		setSize(600, 600);
		
		setLocationRelativeTo(null);
		setLayout(null);
		
		enter = new JButton("Enter");
		input = new JTextField();
		output = new JLabel();
		showInput = new JLabel();
		
		output.setBounds(300, 550, 500, 400);
		
		
	}
}
