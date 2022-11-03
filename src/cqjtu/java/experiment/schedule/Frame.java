package cqjtu.java.experiment.schedule;

import javax.swing.*;
import java.awt.*;

/**
 * @author 632007060122
 * @description TODO
 * @date 2022/10/29 17:48
 */
public class Frame extends JFrame {
    public Panel panel;
    public Container container;

    public Frame() {
        panel = new Panel();
        setTitle("模拟fcfs进程调度算法");
        setSize(1150, 800);
        setLocationRelativeTo(null);
        container = getContentPane();
        container.add(panel);
        setVisible(true);
    }

    public Frame(Panel panel,String title){
        setTitle("模拟"+title+"进程调度算法");
        setSize(1150, 800);
        setLocationRelativeTo(null);
        container = getContentPane();
        container.add(panel);
        setVisible(true);
    }
    public static void main(String[] arg){
        new FCFS();
    }

}
