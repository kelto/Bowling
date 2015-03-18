package dcll.kelt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kelto on 18/03/15.
 */
public class Game {
    private List<Frame> listFrame;
    private int score;
    private boolean valid;
    private String error;

    public Game() {
        this.listFrame = new ArrayList<Frame>();
    }

    /**
     * Methode which initializes a frame with its right instance variable
     * @param stack a queue of Character representing all the launches
     * @throws Exception if the frame is invalid
     */
    public void initFrames(Queue<Character> stack) throws Exception {

        Frame uneFrame = new Frame(stack.poll(), null, null);

        if (uneFrame.getFirstLaunch() != 'X')
            uneFrame.setSecond(stack.poll());

        if (!uneFrame.isValid())
            throw new Exception("Unvalid frame");

        if (!listFrame.isEmpty())
            uneFrame.setBefore(listFrame.get(listFrame.size() - 1));
        else
            uneFrame.setBefore(uneFrame);

        listFrame.add(uneFrame);
    }

    /**
     * Method which initializes all the frames of the game
     * @param stack a queue of Character representing all the launches
     * @throws Exception if the game is invalid
     */
    public void doAllFrames(Queue<Character> stack) throws Exception {

        if (stack.size() > 21)
            throw new Exception("Too much launches, invalid game");

        while (!stack.isEmpty()) {
            initFrames(stack);
        }

        listFrame = setLastFrame();
    }


    /**
     * Method which detects if the end of the game was an exceptional frame (spare or strike)
     * which allows 1 or 2 more launches respectively and thus implies an alternative calculation
     * of the score
     * @return the list of frame
     */
    public List<Frame> setLastFrame () {

        if (listFrame.get(listFrame.size() - 3).getFirstLaunch() == 'X') {
            listFrame.get(listFrame.size() - 2).lastFrame();
            listFrame.get(listFrame.size() - 1).lastFrame();
        }
        else if (listFrame.get(listFrame.size() -2).getSecondLaunch() == '/') {
            listFrame.get(listFrame.size() - 1).lastFrame();
        }

        return  listFrame;
    }
}

