

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProjectTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProjectTest
{
    //US0
    @Test
    public void createAnEmptyProject(){
        Project project = new Project();
        
        assertTrue(project instanceof Project);
    }
    //US0
    @Test
    public void createAProjectWithName(){
        Project project = new Project("My first Project");
        
        assertTrue(project instanceof Project);
        assertEquals("My first Project", project.getName());
    } 
        //US1
    @Test
    public void calculateTimeToDeliverOfASingleTask(){
        Project project = new Project("Sample");
        Task singleTask = new Task();
        singleTask.setTimeToComplete(5);
        
        project.addTask(singleTask);
        assertEquals(5, project.calculateTimeToDelivery());
    }
    //US1
    @Test
    public void calculateTimeToDeliverOf2NonDependentTask(){
        Project project = new Project("Sample");
        Task firstTask = new Task("t1", 6);
        Task secondTask = new Task("t2", 3);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        
        
        assertEquals(6, project.calculateTimeToDelivery());
    }
    //US1
    @Test
    public void calculateTimeToDeliveryOf2DependentTask(){
        Project project = new Project("Sample");
        
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 3);
        
        secondTask.dependsOn(firstTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        
        
        assertEquals(8, project.calculateTimeToDelivery());
    }
}
