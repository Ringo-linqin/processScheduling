package cqjtu.java.experiment.schedule;

/**
 * @author 632007060122
 * @description 优先进程小球
 * @date 2022/10/28 18:25
 */
public class PriorityBall extends Ball {
  /** 进程优先级 */
  public int priority;

  public PriorityBall(int arriveTime, int serviceTime, int x,int y,int priority){
    this.arriveTime = arriveTime;
    this.serviceTime = serviceTime;
    this.x = x;
    this.y = y;
    this.priority = priority;
    this.speed = 50/arriveTime;
  }
  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public int compareTo(PriorityBall o) {
    return this.getPriority() - o.getPriority();
  }
}
