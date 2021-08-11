package daos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

public class DebakTest {

    @Test
    public void testingStuff(){
        int array[] = {2, 2, 2, 3, 3, 5, 2, 6, 7,4,3,4};
        int[] expected=  {2,3,4,5};
        Debak wow = new Debak();
        int[] actual=wow.takeDuplicates(array);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testContains(){
        int num= 3;
        int array[] = { 3, 3, 5, 2, 6, 7,4,3,4};
        Debak wow = new Debak();
        Assert.assertTrue(wow.contains(num, array));
    }
    @Test
    public void testContains2(){
        int num= 9;
        int array[] = { 3, 3, 5, 2, 6, 7,4,3,4};
        Debak wow = new Debak();
        Assert.assertFalse(wow.contains(num, array));
    }

    @Test
    public void testAddingToArray(){
        int num= 3;
        int array[] = { 3, 3, 5, 2, 6, 7,4,3,4};
        Debak wow = new Debak();
        int[] expected = {3, 3, 5, 2, 6, 7,4,3,4};
        int[] actual =wow.addingToArray(num,array);

        Assert.assertEquals(expected[2],actual[2]);

    }
}
