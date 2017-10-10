package myGraphics;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Surface extends JPanel {

	private static final long serialVersionUID = 1L;

	private void doDrawing(Graphics g) {
	
	Graphics2D g2d = (Graphics2D) g;
	g2d.drawString("Java 2D", 50,50);
	}
	
	public void paintComponent(Graphics g) {
		 
		super.paintComponent(g);
		doDrawing(g);
	}
}

public class Graphic1 extends JFrame{

	private static final long serialVersionUID = 1L;
	public Graphic1() {
		initUI();
	}

	private void initUI() {
		setDefaultLookAndFeelDecorated(true);
		add(new Surface());
		
		setTitle("2D example");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				Graphic1 ex = new Graphic1();
				ex.setVisible(true);
				
			}
		});
	}
}