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
    @Parameterized.Parameter(value=3)
    public Character first;
    @Parameterized.Parameter(value=4)
    public Character second;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { new Frame('X','_',Type.NORMAL),true,10, 'X','_' },
                { new Frame('X','/',Type.NORMAL),false,10, 'X', '/'},
                { new Frame('5','_',Type.NORMAL), true,5,'5','_'},
                { new Frame('3','6', Type.STRIKE),true,18,'3','6'},
                { new Frame('4','6', Type.SPARE),false,14,'4','6'},
                { new Frame('3','6', Type.SPARE),true,12,'3','6'},
                { new Frame('3','X', Type.NORMAL),false,13,'3','X'},
                { new Frame('/','6', Type.NORMAL),false,6,'/','6'},
                { new Frame('z','e', Type.NORMAL),false,0,'z','e'},
                { new Frame('X','3',Type.NORMAL),false,13, 'X', '3'},
        };
    }

    @org.junit.Test
    public void testGetScore() throws Exception {
        int value;
        try {
            value = input.getScore();
            assertEquals(input.getScore(),score);
        } catch(Exception e) {
            assertEquals(valid, input.isValid());
        }

    }

    @org.junit.Test
    public void testIsValid() throws Exception {
        assertEquals(input.isValid(),valid);
    }

    @org.junit.Test
    public void testGetFirstLaunch() throws Exception {
        assertEquals(first,input.getFirstLaunch());
    }

    @org.junit.Test
    public void testSetSecond() throws Exception {
        Frame f = new Frame('3',null, Type.NORMAL);
        f.setSecond('4');
        assertEquals(f.getSecondLaunch(), new Character('4'));
    }

    @org.junit.Test
    public void testSetBefore() throws Exception {
        // Can't test this one, maybe remove this function, is it really useful ?
        Frame f = new Frame('X', '_', Type.STRIKE);
        Frame f2 = new Frame('3','4', Type.NORMAL);
        f2.setBefore(f);
        assertEquals(14, f2.getScore());

        f = new Frame('3', '/', Type.SPARE);
        f2 = new Frame('3','4', Type.NORMAL);
        f2.setBefore(f);
        assertEquals(10,f2.getScore());
    }

    @org.junit.Test
    public void testLastFrame() throws Exception {
        Frame f = new Frame('X', '_', Type.STRIKE);
        Frame f2 = new Frame('3','4', Type.NORMAL);
        f2.setBefore(f);
        f2.lastFrame();
        assertEquals(7,f2.getScore());
    }

    @org.junit.Test
    public void testGetSecondLaunch() throws Exception {
        assertEquals(second,input.getSecondLaunch());
    }
}