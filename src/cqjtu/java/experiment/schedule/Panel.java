package cqjtu.java.experiment.schedule;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cqjtu.java.experiment.schedule.Main.balls;

/**
 * @author 632007060122
 * @description 功能实现的基础界面和部件
 * @date 2022/10/28 18:40
 */
public class Panel extends JPanel {

  public JButton startBtn = new JButton("开始");
  public JButton closeBtn = new JButton("退出");
  public JButton renewBtn = new JButton("重置");
  public JLabel cpuLabel = new JLabel("CPU空闲");


  public Ball ball1 = new Ball(2, 5, 30, 170);
  public Ball ball2 = new Ball(5, 10, 30, 270);
  public Ball ball3 = new Ball(10, 5, 30, 370);
  public Ball ball4 = new Ball(7, 5, 30, 470);

  public BallThread ballThread1;
  public BallThread ballThread2;
  public BallThread ballThread3;
  public BallThread ballThread4;

  public Panel() {
    setLayout(null);
    setSize(1000, 800);
    Font font=new Font("宋体", Font.BOLD, 20);
    startBtn.setBounds(250, 700, 100, 30);
    renewBtn.setBounds(500, 700, 100, 30);
    closeBtn.setBounds(750, 700, 100, 30);
    cpuLabel.setBounds(700, 600, 450, 50);
    cpuLabel.setFont(new Font("宋体", Font.BOLD, 25));
    add(startBtn);
    add(closeBtn);
    add(renewBtn);
    add(cpuLabel);

    closeBtn.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.exit(0);
          }
        });
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    // 就绪队列模块
    g.setColor(Color.green);
    g.fillRect(500, 50, 100, 500);
    g.setColor(Color.white);
    g.setFont(new Font("宋体", Font.BOLD, 30));
    g.drawString("就", 540, 80);
    g.drawString("绪", 540, 110);
    g.drawString("队", 540, 140);
    g.drawString("列", 540, 170);
    // CPU模块
    g.setColor(Color.BLUE);
    g.fillRect(600, 50, 300, 500);
    g.setColor(Color.black);
    g.setFont(new Font("宋体", Font.BOLD, 50));
    g.drawString("CPU", 700, 310);
    // 进程小球模块
    g.setColor(Color.RED);
    g.fillOval(ball1.getX(), ball1.getY(), 50, 50);
    g.setFont(new Font("宋体", Font.BOLD, 15));
    g.drawString("进程1", ball1.getX(), (ball1.getY() - 20));
    g.setColor(Color.ORANGE);
    g.fillOval(ball2.getX(), ball2.getY(), 50, 50);
    g.drawString("进程二", ball2.getX(), (ball2.getY() - 20));
    g.setColor(Color.black);
    g.fillOval(ball3.getX(), ball3.getY(), 50, 50);
    g.drawString("进程三", ball3.getX(), (ball3.getY() - 20));
    g.setColor(Color.MAGENTA);
    g.fillOval(ball4.getX(), ball4.getY(), 50, 50);
    g.drawString("进程四", ball4.getX(), (ball4.getY() - 20));
  }

  public void move(Ball ball) {

    if (ball.x < 500) {
      // 小球未到达就绪区
      ball.x += ball.speed;
    } else {
      if (balls.peek() == ball) {
        if (ball.x < 600) {
          ball.x += 30;
        } else if (ball.x < 900) {
          ball.x = ball.x + 50 / ball.getServiceTime();
          cpuLabel.setText("CPU使用中");
        } else {
          balls.remove();
          cpuLabel.setText("CPU空闲,即将调度下一个进程");
        }
      }
    }
    if (balls.size() == 0) {
      cpuLabel.setText("CPU空闲");
    }
  }

  public void initBall() {
    ball1 = new Ball(2, 5, 30, 170);
    ball2 = new Ball(5, 10, 30, 270);
    ball3 = new Ball(10, 5, 30, 370);
    ball4 = new Ball(7, 5, 30, 470);
  }

  public void initThread() {
    ballThread1 = new BallThread(this, ball1);
    ballThread2 = new BallThread(this, ball2);
    ballThread3 = new BallThread(this, ball3);
    ballThread4 = new BallThread(this, ball4);
  }

  public void initQueue() {
    balls.clear();
    balls.offer(ball1);
    balls.offer(ball2);
    balls.offer(ball4);
    balls.offer(ball3);
  }
}
