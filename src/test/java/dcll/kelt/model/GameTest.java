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
    public Queue<Character>list;
    @Parameterized.Parameter(value=1)
    public boolean valid;

    @Parameterized.Parameters
    public static Object[][] data() {
        Character q[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
        '5','_','-'};
        Character q2[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','3','-','7','/','-',
                '5','_','-','_','3','-'};
        Character q3[] = {'3','6','a','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','3','-','7','/','-',
                '5','_','6','_','-'};
        Character q4[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                '5','/','-','5','_','-'};
        Character q5[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                'X','_','-','5','4','-'};
        Character q6[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                '5','/','-','5','4','-'};
        Character q7[] = {'3','6','-','X','_','-','7','/', '-',
                '3','6','-','X','_','-','7','/','-',
                '3','6','-','X','_','-','7','/','-',
                '5','/','-','5','_','-','4','_','-'};
        return new Object[][] {

                {new LinkedList<Character>(Arrays.<Character>asList(q)), true},
                {new LinkedList<Character>(Arrays.<Character>asList(q2)), false},
                {new LinkedList<Character>(Arrays.<Character>asList(q3)), false},
                {new LinkedList<Character>(Arrays.<Character>asList(q4)), true},
                {new LinkedList<Character>(Arrays.<Character>asList(q5)), true},
                {new LinkedList<Character>(Arrays.<Character>asList(q6)), false},
                {new LinkedList<Character>(Arrays.<Character>asList(q7)), false}
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
            game.doAllFrames(list);
            initValid = true;
        } catch (Exception e) {
            initValid = false;
        }
        assertEquals(valid,initValid);
    }

    @Test
    public void testSetLastFrame() throws Exception {

    }
}