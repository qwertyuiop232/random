package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerTest {

  public static void main(String[] args) {
    Timer timer = new Timer(2000, new MyTimerActionListener());

    timer.start();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
    }
    timer.stop();
  }

}

class MyTimerActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {

    System.out.println("asdf");

  }
}