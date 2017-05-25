

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
  /**
   * US1
   */
  @Test
  public void createInstanceOfTask(){
      Task emptyTask = new Task();
      assertTrue(emptyTask instanceof Task);
      assertTrue(emptyTask instanceof Object);
  }
    /**
   * US1
   */
  @Test
  public void readDescriptionProperty(){
      Task emptyTask = new Task();
      assertEquals("", emptyTask.getDescription());
  }
    /**
   * US1
   */
    @Test
  public void writeDescriptionProperty(){
      Task emptyTask = new Task();
      emptyTask.setDescription("this is a task");
      assertEquals("this is a task", emptyTask.getDescription());
  }
  
    /**
   * US1
   */
  @Test
  public void readNameProperty(){
      Task emptyTask = new Task();
      assertEquals("", emptyTask.getName());
  }
  
    /**
   * US1
   */
    @Test
  public void writeNameProperty(){
      Task emptyTask = new Task();
      emptyTask.setName("this is a Name");
      assertEquals("this is a Name", emptyTask.getName());
  }
  
   /**
   * US1
   */
  @Test
  public void readOwnerProperty(){
      Task emptyTask = new Task();
      assertEquals("", emptyTask.getOwner());
  }
  
    /**
   * US1
   */
    @Test
  public void writeOwnerProperty(){
      Task emptyTask = new Task();
      emptyTask.setOwner("Raul");
      assertEquals("Raul", emptyTask.getOwner());
  }
  
     /**
   * US1
   */
  @Test
  public void readTimeToCompleteProperty(){
      Task emptyTask = new Task();
      assertEquals(0, emptyTask.getTimeToComplete());
  }
  
    /**
   * US1
   */
    @Test
  public void writeTimeToCompleteProperty(){
      Task emptyTask = new Task();
      emptyTask.setTimeToComplete(10);
      assertEquals(10, emptyTask.getTimeToComplete());
  }
  
    /**
   * US1
   */
    @Test
  public void createTaskWithNameAndTimeToComplete(){
      Task emptyTask = new Task("t1", 4);
  
      assertEquals("t1", emptyTask.getName());
      assertEquals(4, emptyTask.getTimeToComplete());
  }
  
  @Test
  public void tasksAreEqualsIfTheyHaveTheSameNameAndtimeToComplte(){
      Task task = new Task("t1", 5);
      Task expected = new Task("t1", 5);

      assertTrue(task.equals(expected));
  }
  
  @Test
  public void taskAreDifferentIfTheyHaveADifferentName(){
      Task task = new Task("t1", 5);
      Task other = new Task("t2", 5);

      assertFalse(task.equals(other));
  }
  
    @Test
  public void taskAreDifferentIfTheyHaveADifferentTime(){
      Task task = new Task("t1", 10);
      Task other = new Task("t1", 5);

      assertFalse(task.equals(other));
  }
}
