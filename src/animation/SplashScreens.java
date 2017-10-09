package animation;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SplashScreens {
    private static void constructGUI() {
        SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash != null) {
            Graphics2D g = (Graphics2D) splash.createGraphics();
            // Simulate lengthy loading
            for (int i = 0; i < 10; i++) {
                String message = "Process " + i + " of 10...";
                g.setComposite(AlphaComposite.Clear);
                g.fillRect(130, 350, 280, 40);
                g.setPaintMode();
                g.setColor(Color.RED);
                g.drawString(message, 130, 360);
                g.fillRect(130, 370, i * 30, 20);

                splash.update();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        JFrame frame = new JFrame("Splash Screen Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
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