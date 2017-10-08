package animation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JLabelDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setTitle("JLabel Test");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("First Name");
        label1.setFont(new Font("Courier New", Font.ITALIC, 12));
        label1.setForeground(Color.GRAY);

        JLabel label2 = new JLabel();
        label2.setText(
                "<html>Last Name<br><font face='courier new'"
                + " color=red>(mandatory)</font></html>");
        JLabel label3 = new JLabel();
        label3.setText("<html>Last Name<br><font face=garamond "
                + "color=red>(mandatory)</font></html>");
        ImageIcon imageIcon = new ImageIcon("triangle.jpg");
        JLabel label4 = new JLabel(imageIcon);
        JLabel label5 = new JLabel("Mixed", imageIcon,
                SwingConstants.RIGHT);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.pack();
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