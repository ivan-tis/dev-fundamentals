

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaskTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TaskTest
{
  @Test
  public void createInstanceOfTask(){
      Task emptyTask = new Task();
      assertTrue(emptyTask instanceof Task);
      assertTrue(emptyTask instanceof Object);
  }
  
  @Test
  public void readDescriptionProperty(){
      Task emptyTask = new Task();
      assertEquals("", emptyTask.getDescription());
  }
  
    @Test
  public void writeDescriptionProperty(){
      Task emptyTask = new Task();
      emptyTask.setDescription("this is a task");
      assertEquals("this is a task", emptyTask.getDescription());
  }
//https://github.com/ivan-tis/dev-fundamentals.git
}
