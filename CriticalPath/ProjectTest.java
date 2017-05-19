

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
    
}
