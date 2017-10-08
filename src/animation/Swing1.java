package animation;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Swing1 {
	private static void ConstructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JFrame test");
		frame.setLayout(new GridLayout(3,2));
		
		frame.add(new JLabel("First Name: "));
		frame.add(new JTextField());
		frame.add(new JLabel("Last Name: "));
		frame.add(new JTextField());
		frame.add(new JButton("Register"));
		
		int frameWidth =200;
		int frameHeight = 100;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
		frame.setVisible(true);
	
	}
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ConstructGUI();
			}
		});
	}
}
