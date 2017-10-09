package animation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

class MouseClickListener extends MouseAdapter {
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			System.out.print("The left mouse button was clicked ");
		} else if (SwingUtilities.isRightMouseButton(e)) {
			System.out.print("The right mouse button was clicked ");
		} else if (SwingUtilities.isMiddleMouseButton(e)) {
			System.out.print("The middle mouse button was clicked ");
		}
		System.out.print(e.getClickCount() + " times");
		int x = e.getX();
		int y = e.getY();
		System.out.println(" at (" + x + "," + y + ")");
	}
}

public class MouseClickDemo {
	public static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Mouse Listener test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(new MouseClickListener());
		frame.setSize(200, 200);
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
