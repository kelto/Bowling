package dcll.kelt.model;

import dcll.kelt.model.Frame.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

}