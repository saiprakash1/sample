package sai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author SAI
 *
 */
public class Worker implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(Worker.class);

  private final Task task;

  public Worker(final Task task) {
    this.task = task;
  }

  @Override
  public void run() {
    System.out.println("processing,"+ Thread.currentThread().getName()+","+task.toString());
    try {
      Thread.sleep(task.getTimeMs());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
