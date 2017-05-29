

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Vector;
/**
 * The test class ProjectTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProjectTest
{
    private Project project;
    @Before
    public void setUp(){
       project = new Project("Sample");
    }
    
    //US0
    @Test
    public void createAnEmptyProject(){
     //   Project project = new Project();
        
        assertTrue(project instanceof Project);
    }
    //US0
    @Test
    public void createAProjectWithName(){
       // Project project = new Project("My first Project");
        
        assertTrue(project instanceof Project);
        assertEquals("Sample", project.getName());
    } 
        //US1
    @Test
    public void calculateTimeToDeliverOfASingleTask(){
        //Project project = new Project("Sample");
        Task singleTask = new Task();
        singleTask.setTimeToComplete(5);
        
        project.addTask(singleTask);
        assertEquals(5, project.calculateTimeToDelivery());
    }
    //US1
    @Test
    public void calculateTimeToDeliverOf2NonDependentTask(){
        //Project project = new Project("Sample");
        Task firstTask = new Task("t1", 6);
        Task secondTask = new Task("t2", 3);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        
        
        assertEquals(6, project.calculateTimeToDelivery());
    }
    //US1
    @Test
    public void calculateTimeToDeliveryOf2DependentTask(){
       // Project project = new Project("Sample");
        
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 3);
        
        secondTask.dependsOn(firstTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        
        
        assertEquals(8, project.calculateTimeToDelivery());
    } 
        //US1
    @Test
    public void calculateTimeToDeliveryOf3DependentTask(){
       //Project project = new Project("Sample");
        
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 3);
        Task thirdTask = new Task("t3", 6);
        
        thirdTask.dependsOn(firstTask);
        thirdTask.dependsOn(secondTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        project.addTask(thirdTask);
        
        assertEquals(11, project.calculateTimeToDelivery());
    }    
   
    //US1
    @Test
    public void calculateTimeToCompleteForADiamondShapeDependency(){
       // Project project = new Project("Sample");
        
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 2);
        Task thirdTask = new Task("t3", 6);
        Task fourthTask = new Task("t4", 1);
        
        secondTask.dependsOn(firstTask);
        thirdTask.dependsOn(firstTask);
        
        fourthTask.dependsOn(secondTask);
        fourthTask.dependsOn(thirdTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        project.addTask(thirdTask);
        project.addTask(fourthTask);
        
        assertEquals(12, project.calculateTimeToDelivery());
    }   
    
    //US1 US5
    @Test
    public void calculateTimeToCompleteForADiamondShapeDependencyMax(){
       // Project project = new Project("Sample");
        
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 2);
        Task thirdTask = new Task("t3", 6);
        Task fourthTask = new Task("t4", 1);
        Task ZeroTask= new Task("t0", 10);
        Task fifthTask= new Task("t5", 35);
        
        firstTask.dependsOn(ZeroTask);
        
        secondTask.dependsOn(firstTask);
        thirdTask.dependsOn(firstTask);
        
        fourthTask.dependsOn(secondTask);
        fourthTask.dependsOn(thirdTask);
        
        project.addTask(ZeroTask);
        project.addTask(firstTask);
        project.addTask(secondTask);
        project.addTask(thirdTask);
        project.addTask(fourthTask);
        project.addTask(fifthTask);
        assertEquals(35, project.calculateTimeToDelivery());
    }  
    
    //US3
    @Test
    public void modifyTaskTimeToCompleteShouldChangeTheProjectDelivered(){
       // Project project = new Project("Sample");
        
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 2);
        Task thirdTask = new Task("t3", 6);
        Task fourthTask = new Task("t4", 1);
        
        secondTask.dependsOn(firstTask);
        thirdTask.dependsOn(firstTask);
        
        fourthTask.dependsOn(secondTask);
        fourthTask.dependsOn(thirdTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        project.addTask(thirdTask);
        project.addTask(fourthTask);

        assertEquals(12, project.calculateTimeToDelivery());
        
        secondTask.setTimeToComplete(10);
        assertEquals(16, project.calculateTimeToDelivery());
    }
    
        //US3
    @Test
    public void projectCannotHaveDuplicateTask(){
        //Project project = new Project("Sample");
        Task firstTask = new Task("t1", 5);
        
        project.addTask(firstTask);
        project.addTask(new Task("t1", 5));
 

        assertEquals(1, project.countTasks());
  
    } 
    
        @Test
    public void calculateTimeToCompleteAListOfTasks(){
       // Project project = new Project("Sample");
        
        Task firstTask = new Task("t1", 1);
        Task secondTask = new Task("t2", 5);
        Task thirdTask = new Task("t3", 3);
        Task fourthTask = new Task("t4", 2);
        Task fifthTask= new Task("t5", 3);
        Task sixthTask= new Task("t6", 4);
        Task seventhTask= new Task("t6", 3); 
        
        secondTask.dependsOn(firstTask);
        thirdTask.dependsOn(firstTask);
        
        fourthTask.dependsOn(secondTask);
        fifthTask.dependsOn(thirdTask);
        
        sixthTask.dependsOn(fourthTask);
        sixthTask.dependsOn(fifthTask);
        
        seventhTask.dependsOn(sixthTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        project.addTask(thirdTask);
        project.addTask(fourthTask);
        project.addTask(fifthTask);
        project.addTask(sixthTask);
        project.addTask(seventhTask);
        assertEquals(15, project.calculateTimeToDelivery());
        
       // List<Task> criticalPath = project.calculateCriticalPath();
       // assertEquals(5, criticalPath.size());
        
    }  
    
    @Test
    public void criticalPathOfSingleTaskIsAListWithOnlyOneElement(){
      //  Project project = new Project("Sample");
        project.addTask(new Task("t1", 6));
        Task task = new Task("t1", 1); 
        List<Task> expected = new Vector<Task>();
        expected.add(task);
        List<Task> criticalPath = project.calculateCriticalPath();
        assertEquals(expected, criticalPath);
       
        
    }  
}
