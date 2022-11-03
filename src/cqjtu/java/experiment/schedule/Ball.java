package cqjtu.java.experiment.schedule;

/**
 * @author 632007060122
 * @description 进程小球模拟类
 * @date 2022/10/28 17:24
 */
public class Ball implements Comparable<Ball> {

  /** 到达时间 */
  protected int arriveTime;
  /** 服务时间 */
  protected int serviceTime;
  /** 已运行时间 */
  public int usedTime;
  /** 位置信息x */
  public int x;
  /** 位置信息y */
  public int y;
  /** 移动速度 */
  public int speed;
  /** 时间片 */
  public int timeSlice;

  public Ball() {}

  public Ball(int arriveTime, int serviceTime, int x, int y) {
    this.arriveTime = arriveTime;
    this.serviceTime = serviceTime;
    this.x = x;
    this.y = y;
    this.speed = 50 / arriveTime;
    this.usedTime=0;
  }

  @Override
  public int compareTo(Ball o) {
    return this.getArriveTime() - o.getArriveTime();
  }

  public int getArriveTime() {
    return arriveTime;
  }

  public void setArriveTime(int arriveTime) {
    this.arriveTime = arriveTime;
  }

  public int getServiceTime() {
    return serviceTime;
  }

  public void setServiceTime(int serviceTime) {
    this.serviceTime = serviceTime;
  }

  public int getUsedTime() {
    return usedTime;
  }

  public void setUsedTime(int usedTime) {
    this.usedTime = usedTime;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setTimeSlice(int timeSlice) {
    this.timeSlice = timeSlice;
  }
}
