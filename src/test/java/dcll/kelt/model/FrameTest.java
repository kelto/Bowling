package dcll.kelt.model;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by kelto on 29/03/15.
 */

public class FrameTest {
/*
    @Parameterized.Parameter
    public Frame input;
    @Parameterized.Parameter(value=1)
    public Boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { new Frame('X',null,Type.NORMAL),new Boolean(true) },
                { new Frame('X','/',Type.NORMAL), new Boolean(false)},
                { new Frame('5','_',Type.NORMAL), new Boolean(true)}
        };
    }
*/
    @org.junit.Test
    public void testGetScore() throws Exception {

    }

    @org.junit.Test
    public void testIsValid() throws Exception {

        Frame f = new Frame('X',null,Type.NORMAL);
        Frame f2 =new Frame('X','/',Type.NORMAL);
        Frame f3 =new Frame('5','_',Type.NORMAL);
        assertEquals(f.isValid(), true);
        assertEquals(f2.isValid(), false);
        assertEquals(f3.isValid(), true);
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