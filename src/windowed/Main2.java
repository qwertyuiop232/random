package windowed;
import java.awt.EventQueue;
import javax.swing.JFrame;


public class Main2 {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable( {
			public void run() {
				ConstructGUI game = new ConstructGUI("An adventure");
				game.setVisible(true);
				game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}
