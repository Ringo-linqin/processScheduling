package cqjtu.java.experiment.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cqjtu.java.experiment.schedule.Main.balls;

/**
 * @author 632007060122
 * @description 轮转调度算法
 * @date 2022/10/30 20:01
 */
public class RR extends Panel {

  /** 时间片大小 */
  public int timeSlice = 1;

  public RR() {
    new Frame(this, "RR");
    initBall();
    initQueue();
    initThread();
    ball1.setTimeSlice(timeSlice);
    ball2.setTimeSlice(timeSlice);
    ball3.setTimeSlice(timeSlice);
    ball4.setTimeSlice(timeSlice);
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
  public void move(Ball ball) {

    if (ball.x < 500) {
      // 小球未到达就绪区
      ball.x += ball.speed;
    } else {
      if (balls.peek() == ball) {
        if(timeSlice>0){
          if (ball.x < 600) {
            ball.x += 30;
          } else if (ball.x < 900) {
            ball.x = ball.x + 50 / ball.getServiceTime();
            ball.setUsedTime((ball.x-600)/(300/ball.getServiceTime()));
            cpuLabel.setText("CPU使用中");
          } else {
            balls.remove();
            cpuLabel.setText("CPU空闲,即将调度下一个进程");
          }
          if((ball.x-600)%(300/ball.getServiceTime())==0){
            ball.timeSlice-=1;
          }

        }else{
          timeSlice=1;
        }

      }
    }
    if (balls.size() == 0) {
      cpuLabel.setText("CPU空闲");
    }
  }

  public void changeQueue(){
    //在线程列表中找到状态为未到达的线程，加入队列尾
    for(int i=0;i<4;i++){

    }

  }
}
