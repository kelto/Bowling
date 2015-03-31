package dcll.kelt.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by kelto on 30/03/15.
 */
@RunWith(Parameterized.class)
public class GameTest {

    @Parameterized.Parameter
    public LinkedList<Character>list;
    @Parameterized.Parameter(value=1)
    public boolean valid;
    @Parameterized.Parameter(value=2)
    public int score;

    @Parameterized.Parameters
    public static Object[][] data() {
        Character q0[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
        '5','_','-'};
        // Should fail because no Strike or Spare on the 10th Frame
        // so no 11th frame allowed
        Character q1[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','3','-','7','/','-',
                '5','_','-','_','3','-'};
        Character q2[] = {'3','6','a','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','3','-','7','/','-',
                '5','_','6','_','-'};
        Character q3[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                '5','/','-','5','_','-'};
        Character q4[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                'X','_','-','5','4','-'};
        // Should fail because on the last frame, there should be only
        // one launch, so instead of 4, should be _
        Character q5[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                '5','/','-','5','4','-'};
        Character q6[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                '5','/','-','5','_','-','4','_','-'};
        return new Object[][] {

                {new LinkedList<Character>(Arrays.<Character>asList(q0)), true,133},
                {new LinkedList<Character>(Arrays.<Character>asList(q1)), false,0},
                {new LinkedList<Character>(Arrays.<Character>asList(q2)), false,0},
                {new LinkedList<Character>(Arrays.<Character>asList(q3)), true,143},
                {new LinkedList<Character>(Arrays.<Character>asList(q4)), true,152},
                {new LinkedList<Character>(Arrays.<Character>asList(q5)), false,0},
                {new LinkedList<Character>(Arrays.<Character>asList(q6)), false,0}
        };
    }
/*
    @Test
    public void testInitFrames() throws Exception {

        for(Character a : list) {
            System.out.print(a);
        }
        System.out.println("next");


        Game game = new Game();
        boolean initValid;
        try {
            game.initFrames(list);
            initValid = true;
        } catch (Exception e) {
            initValid = false;
        }
        assertEquals(valid,initValid);


    }
    */

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
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assertEquals(valid,initValid);
    }

    @Test
    public void testSetLastFrame() throws Exception {

    }

    @Test
    public void testGetScore() throws Exception {
        Game game = new Game();
        boolean initValid;
        try {
            //Have to clone it, if not, the list will be empty for other test
            game.doAllFrames((Queue)list.clone());
            initValid = true;
        } catch (Exception e) {
            initValid = false;
        }
        if(initValid) {
            assertEquals(score, game.getScore());
        } else {
            assertEquals(score,0);
        }

    }
}