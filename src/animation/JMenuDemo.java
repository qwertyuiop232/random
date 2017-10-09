package animation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

class MyMenuActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
}

public class JMenuDemo {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("My menu program");
		MyMenuActionListener actionListener = new MyMenuActionListener();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
        JMenuItem fileNewMI = new JMenuItem("New");
        JMenuItem fileOpenMI = new JMenuItem("Open");
        JMenuItem fileSaveMI = new JMenuItem("Save");
        JMenuItem fileExitMI = new JMenuItem("Exit");

        fileMenu.add(fileNewMI);
        fileNewMI.addActionListener(actionListener);
        fileMenu.add(fileOpenMI);
        fileOpenMI.addActionListener(actionListener);
        fileMenu.add(fileSaveMI);
        fileSaveMI.addActionListener(actionListener);
        fileMenu.addSeparator();
        fileMenu.add(fileExitMI);
        fileExitMI.addActionListener(actionListener);
        
        JMenuItem editCopyMI = new JMenuItem("Copy");
        JMenuItem editPasteMI = new JMenuItem("Paste");
        editMenu.add(editCopyMI);
        editMenu.add(editPasteMI);

        JMenuItem helpAboutMI = new JMenuItem("About");
        helpMenu.add(helpAboutMI);

        frame.setJMenuBar(menuBar);
        frame.setSize(200, 100);
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
