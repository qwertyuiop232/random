package animation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

class ActionListenerDemo1 implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		String buttonText = source.getText();
		JOptionPane.showMessageDialog(null, "you clicked " + buttonText);
	}
}

public class ActionEvents {
	public static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame ("test 1");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton ("register");
		button.addActionListener(new ActionListenerDemo1());
		frame.getContentPane().add(button);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
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
