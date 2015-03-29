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
    public Boolean valid;
    @Parameterized.Parameter(value=2)
    public int score;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { new Frame('X','_',Type.NORMAL),true,10 },
                { new Frame('X','/',Type.NORMAL),false,10},
                { new Frame('5','_',Type.NORMAL), true,5},
                { new Frame('3','6', Type.STRIKE),true,18},
                { new Frame('4','6', Type.SPARE),false,14},
                { new Frame('3','6', Type.SPARE),true,12}
        };
    }

    @org.junit.Test
    public void testGetScore() throws Exception {
        assertEquals(input.getScore(),score);
    }

    @org.junit.Test
    public void testIsValid() throws Exception {
        assertEquals(input.isValid(),valid);
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