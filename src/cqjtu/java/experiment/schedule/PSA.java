package cqjtu.java.experiment.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cqjtu.java.experiment.schedule.Main.balls;

/**
 * @author 632007060122
 * @description 优先级调度
 * @date 2022/10/30 15:13
 */
public class PSA extends Panel {
  public PSA() {
    new Frame(this, "PSA");
    initBall();
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

  @Override
  public void initQueue() {
    balls.clear();
    balls.offer(ball2);
    balls.offer(ball4);
    balls.offer(ball1);
    balls.offer(ball3);
  }

  @Override
  public void initBall(){
    ball1 = new PriorityBall(2, 5, 30, 170,3);
    ball2 = new PriorityBall(5, 10, 30, 270,1);
    ball3 = new PriorityBall(10, 5, 30, 370,4);
    ball4 = new PriorityBall(7, 5, 30, 470,2);
  }
}
