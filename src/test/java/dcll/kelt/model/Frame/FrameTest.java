package dcll.kelt.model.Frame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Test for the Frame.
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
        NormalFrame normal = new NormalFrame(
                new Launch('5'),new Launch(('4'))
            );

        Launch strike = new Launch('X');
        Launch empty = new Launch('_');
        Launch zero = new Launch('_');
        Launch cinq = new Launch('5');
        strike.setNext(zero);
        zero.setNext(cinq);
        StrikeFrame strikeFrame = new StrikeFrame(strike,empty);

        Launch trois = new Launch('3');
        Launch spare = new Launch('/');
        Launch quatre = new Launch('4');
        trois.setNext(trois);
        spare.setNext(quatre);
        SpareFrame spareFrame = new SpareFrame(trois,spare);


        zero.setNext(spare);


        Launch fail = new Launch('a');
        Launch deux = new Launch('2');
        fail.setNext(deux);
        NormalFrame failedFrame = new NormalFrame(fail,deux);

        Launch strike2 = new Launch('X');
        Launch fail2 = new Launch('e');
        Launch un = new Launch('1');
        Launch spare2 = new Launch('/');
        strike2.setNext(un);
        un.setNext(spare2);
        StrikeFrame failedStrike = new StrikeFrame(strike2,fail2);

        SpareFrame failedSpare = new SpareFrame(new Launch('/'),new Launch('/'));

        NormalFrame tooBig = new NormalFrame(new Launch('8'), new Launch('7'));

        return new Object[][] {
                {normal,true,9 },
                {spareFrame,true,14},

                {strikeFrame,true, 20},
                {failedFrame,false,0},
                {failedStrike,false,0},
                {failedSpare,false,0},
                {tooBig, false, 0},


        };
    }


    @Test
    public void testGetScore() throws Exception {
        assertEquals(score,input.getScore());
    }
}