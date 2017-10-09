package animation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Layout extends JFrame {

	private static final long serialVersionUID = 1L;
	private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("NoLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLabel label = new JLabel("First Name:");
        label.setBounds(20, 20, 100, 20);
        JTextField textField = new JTextField();
        textField.setBounds(124, 25, 100, 20);
        frame.add(label);
        frame.add(textField);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }
}