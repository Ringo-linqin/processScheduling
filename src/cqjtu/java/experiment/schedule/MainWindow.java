package cqjtu.java.experiment.schedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 632007060122
 * @description 主界面
 * @date 2022/10/30 12:01
 */
public class MainWindow extends JFrame {
  private Container con;

  public MainWindow() {
    this.con = getContentPane();
    setBounds(100, 100, 500, 500);
    GridLayout gl = new GridLayout(3, 1);
    Font font = new Font("Courier New",Font.BOLD,22);

    con.setLayout(gl);
    this.setTitle("进程调度算法的模拟");
    Button b = new Button("FCFS");
    b.setFont(font);
    b.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            new FCFS();
          }
        });
    con.add(b);
    b = new Button("PSA");
      b.setFont(font);
    b.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            new PSA();
          }
        });
    con.add(b);
    b = new Button("RR");
    b.setFont(font);
    b.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
//            new RR();
          }
        });
    con.add(b);

    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
