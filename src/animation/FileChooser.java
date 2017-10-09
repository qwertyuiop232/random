package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FileChooser extends JFrame {

	private static final long serialVersionUID = 1L;
 String fileSelected;
    public FileChooser(String title) {
        super(title);
    }

    public void init() {
        JButton button = new JButton("Select File");
        button.addActionListener(new MyActionListener());
        this.getContentPane().add(button);
    }

    private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        FileChooser frame = new FileChooser(
                "ActionListener Demo 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.init();
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               fileSelected =
                    fileChooser.getSelectedFile().getName();
                System.out.print(fileSelected);
            }
        }
    }
}