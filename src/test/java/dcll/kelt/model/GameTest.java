package dcll.kelt.model;

import dcll.kelt.model.Frame.Frame;
import dcll.kelt.model.Frame.FrameBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by kelto on 30/03/15.
 */
@RunWith(Parameterized.class)
public class GameTest {

    @Parameterized.Parameter
    public LinkedList<Character> list;
    @Parameterized.Parameter(value = 1)
    public boolean valid;
    @Parameterized.Parameter(value = 2)
    public int score;
    @Parameterized.Parameter(value = 3)
    public boolean buildValid;

    @Parameterized.Parameters
    public static Object[][] data() {
        Character q0[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '5', '_', '-'};
        // Should fail because no Strike or Spare on the 10th Frame
        // so no 11th frame allowed
        Character q1[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '3', '-', '7', '/', '-',
                '5', '_', '-', '_', '3', '-'};
        Character q2[] = {'3', '6', 'a', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '3', '-', '7', '/', '-',
                '5', '_', '6', '_', '-'};
        Character q3[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '5', '/', '-', '5', '_', '-'};
        Character q4[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                'X', '_', '-', '5', '4', '-'};
        // Should fail because on the last frame, there should be only
        // one launch, so instead of 4, should be _
        Character q5[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '5', '/', '-', '5', '4', '-'};
        Character q6[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '5', '/', '-', '5', '_', '-', '4', '_', '-'};
        Character q7[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '5', '/', '-', '5', '_', '-', '4', '_', 'a'};
        Character q8[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '5', '/', '-', '5', '_', '-', '4', '_'};
        //q9 and q10 should failed, Spare/Strike at the end but only 10 frames.
        Character q9[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '5', '/', '-'};
        Character q10[] = {'3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                '3', '6', '-', 'X', '_', '-', '7', '/', '-',
                'X', '_', '-'};
        return new Object[][]{

                {new LinkedList<Character>(Arrays.<Character>asList(q0)), true, 133, true},
                {new LinkedList<Character>(Arrays.<Character>asList(q1)), false, 0, true},
                {new LinkedList<Character>(Arrays.<Character>asList(q2)), false, 0, false},
                {new LinkedList<Character>(Arrays.<Character>asList(q3)), true, 143, true},
                {new LinkedList<Character>(Arrays.<Character>asList(q4)), true, 152, true},
                {new LinkedList<Character>(Arrays.<Character>asList(q5)), false, 0, true},
                {new LinkedList<Character>(Arrays.<Character>asList(q6)), false, 0, true},
                {new LinkedList<Character>(Arrays.<Character>asList(q7)), false, 0, false},
                {new LinkedList<Character>(Arrays.<Character>asList(q8)), false, 0, false},
                {new LinkedList<Character>(Arrays.<Character>asList(q9)), false, 0, true},
                {new LinkedList<Character>(Arrays.<Character>asList(q10)), false, 0, true},
        };
    }

    /*
    @Test
    public void testDoAllFrames() throws Exception {
        Game game = new Game();
        boolean initValid;
        try {
            //Have to clone it, if not, the list will be empty for other test
            game.doAllFrames((Queue)list.clone());
            initValid = true;
        } catch (Exception e) {
            initValid = false;

        }
        assertEquals(valid,initValid);
    }
*/
    @org.junit.Test
    public void testCreateFrames() throws Exception {
        FrameBuilder builder = new FrameBuilder((Queue) list.clone());
        boolean build;
        try {
            Deque<Frame> deque = builder.getFrames();
            build = true;
        } catch (Exception e) {
            build = false;
        }
        assertEquals(buildValid, build);


    }

    @Test
    public void testGetScore() throws Exception {
        FrameBuilder builder = new FrameBuilder((Queue) list.clone());
        boolean build, gameValid;
        Deque<Frame> deque = null;
        try {
            deque = builder.getFrames();
            build = true;

        } catch (Exception e) {
            build = false;
        }
        if (build) {
            Game game = new Game(deque);
            int gameScore = 0;
            try {
                gameScore = game.getScore();
                gameValid = true;
            } catch (Exception e) {
                gameValid = false;
            }
            assertEquals(valid, gameValid);
            if (gameValid) {
                assertEquals(score, gameScore);
            }
        }

    }

}