package cqjtu.java.experiment.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import static cqjtu.java.experiment.schedule.Main.balls;

/**
 * @author 632007060122
 * @description 先到先服务
 * @date 2022/10/28 23:05
 */
public class FCFS extends Panel {

  public FCFS() {
    new Frame(this, "FCFS");
    initQueue();
    initThread();
    startBtn.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            ballThread1.start();
            ballThread2.start();
            ballThread3.start();
            ballThread4.start();
          }
        });
    renewBtn.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            initBall();
            initQueue();
            initThread();
            ballThread1.start();
            ballThread2.start();
            ballThread3.start();
            ballThread4.start();
          }
        });
  }

}
