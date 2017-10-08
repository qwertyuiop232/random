package animation;
import javax.swing.*;

public class JFrame1 {
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setTitle("My first swing application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Welcome");
		frame.add(label);
		frame.setBounds(800, 400, 300, 300);
		frame.setVisible(true);
	}
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});
	}

}
