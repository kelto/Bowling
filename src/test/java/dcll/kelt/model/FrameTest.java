package dcll.kelt.model;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by kelto on 29/03/15.
 */
@RunWith(Parameterized.class)
public class FrameTest {

    @Parameterized.Parameter
    public Frame input;
    @Parameterized.Parameter(value=1)
    public Boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { new Frame('X','_',Type.NORMAL),true },
                { new Frame('X','/',Type.NORMAL),false},
                { new Frame('5','_',Type.NORMAL), true}
        };
    }

    @org.junit.Test
    public void testGetScore() throws Exception {

    }

    @org.junit.Test
    public void testIsValid() throws Exception {
        assertEquals(input.isValid(),expected);
    }

    @org.junit.Test
    public void testGetFirstLaunch() throws Exception {

    }

    @org.junit.Test
    public void testSetSecond() throws Exception {

    }

    @org.junit.Test
    public void testSetBefore() throws Exception {

    }

    @org.junit.Test
    public void testLastFrame() throws Exception {

    }

    @org.junit.Test
    public void testGetSecondLaunch() throws Exception {

    }
}