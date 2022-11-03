package cqjtu.java.experiment.schedule;

/**
 * @author 632007060122
 * @description 控制小球移动的进程类
 * @date 2022/10/29 17:17
 */
public class BallThread extends Thread{
    private Panel panel;
    private Ball ball;

    public BallThread(Panel panel,Ball ball){
        this.panel = panel;
        this.ball = ball;
    }

    @Override
    public void run(){
        while(true){
            panel.move(ball);
            panel.repaint();
            try {
                sleep(80);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
