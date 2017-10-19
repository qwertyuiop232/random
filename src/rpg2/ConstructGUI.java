package rpg2;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConstructGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	String out, in;
	Input input = new Input();
	
	JButton enter, quit;
	JTextField uInput;
	JLabel output, showInput;
	
	
	public ConstructGUI(String title) {
		super (title);
		
		setSize(600, 400);
		
		setLocation(750,300);
		setLayout(null);
		
		enter = new JButton("Enter");
		quit = new JButton("Quit");
		uInput = new JTextField();
		output = new JLabel();
		showInput = new JLabel();
		
		output.setBounds(76, 3, 400, 400);
		output.setVerticalAlignment(JLabel.TOP);
		
		enter.setBounds(480, 298, 100, 50);
		enter.setFont(new Font ("Sherif", 0, 23));
		
		uInput.setBounds(76, 305, 400, 40);
		uInput.setFont(new Font ("Sherif", 0, 20));
		
		quit.setBounds(2, 300, 70, 50);
		quit.setFont(new Font ("Sherif", 0, 20));
		
		add(enter);
		add(uInput);
		add(output);
		add(showInput);
		add(quit);
				
		enter.addActionListener(new ComputeClickHandler());
		quit.addActionListener(new ComputeClickHandler());
		output.setOpaque(true);
	}
	public class ComputeClickHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			input.setInput(uInput.getText());
			uInput.setText(null);
			out = input.getOutput();
			output.setText(out);
		}
	}
}
