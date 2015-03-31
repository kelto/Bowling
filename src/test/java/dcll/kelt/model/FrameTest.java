package dcll.kelt.model;

import dcll.kelt.model.Frame.Frame;
import dcll.kelt.model.Frame.NormalFrame;
import dcll.kelt.model.Frame.SpareFrame;
import dcll.kelt.model.Frame.StrikeFrame;
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
    public Frame before;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { new StrikeFrame('X','_'),true,19, new NormalFrame('5','4') },
                { new StrikeFrame('X','/'),false,0, new NormalFrame('5','4')},
                { new NormalFrame('5','_'), true,5,new NormalFrame('5','4')},
                { new NormalFrame('3','6'),true,9,new NormalFrame('5','4')},
                { new StrikeFrame('X','_'),true,20,new SpareFrame('5','/')},
                { new StrikeFrame('X','_'),true,20,new StrikeFrame('X','_')},
                { new StrikeFrame('X','_'),true,0,new NormalFrame('z','e')},
                { new SpareFrame('3','/'),true,15,new NormalFrame('5','4')},
                { new NormalFrame('3','X'),false,0,new NormalFrame('5','4')},
                { new SpareFrame('/','6'),false,0,new NormalFrame('5','4')},
                { new NormalFrame('z','e'),false,0,new NormalFrame('5','4')},
                { new StrikeFrame('X','3'),false,0, new NormalFrame('5','4')},
                { new SpareFrame('4','/'), true, 15, new NormalFrame('5','4')},
                { new SpareFrame('4','/'), true, 20, new StrikeFrame('X','_')},
                { new SpareFrame('4','/'), true, 0, new NormalFrame('z','4')}
        };
    }

    @org.junit.Test
    public void testGetScore() throws Exception {
        assertEquals(input.getScore(before),score);
    }

    @org.junit.Test
    public void testIsValid() throws Exception {
        assertEquals(input.isValid(),valid);
    }

    @org.junit.Test
    public void testGetFirstLaunch() throws Exception {
        //assertEquals(first,input.getFirstLaunch());
    }

    @org.junit.Test
    public void testSetSecond() throws Exception {
        /*
        Frame f = new Frame('3',null, Type.NORMAL);
        f.setSecond('4');
        assertEquals(f.getSecondLaunch(), new Character('4'));
        */
    }

    @org.junit.Test
    public void testSetBefore() throws Exception {
        /*
        // Can't test this one, maybe remove this function, is it really useful ?
        Frame f = new Frame('X', '_', Type.STRIKE);
        Frame f2 = new Frame('3','4', Type.NORMAL);
        f2.setBefore(f);
        assertEquals(14, f2.getScore());

        f = new Frame('3', '/', Type.SPARE);
        f2 = new Frame('3','4', Type.NORMAL);
        f2.setBefore(f);
        assertEquals(10,f2.getScore());
        */
    }

    @org.junit.Test
    public void testLastFrame() throws Exception {
        /*
        Frame f = new Frame('X', '_', Type.STRIKE);
        Frame f2 = new Frame('3','4', Type.NORMAL);
        f2.setBefore(f);
        f2.lastFrame();
        assertEquals(7,f2.getScore());
        */
    }

    @org.junit.Test
    public void testGetSecondLaunch() throws Exception {
        /*
        assertEquals(second,input.getSecondLaunch());
        */
    }
}