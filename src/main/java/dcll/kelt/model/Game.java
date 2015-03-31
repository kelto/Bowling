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
     * @param queue a queue of Character representing all the launches
     * @throws Exception if the frame is invalid
     */
    private void initFrames(Queue<Character> queue) throws Exception {

        //Frame uneFrame = new Frame(stack.poll(), null, null);
        Frame uneFrame = createFrame(queue);

        if (!uneFrame.isValid()) {
            throw new Exception("Unvalid frame");
        }

        if (!listFrame.isEmpty()) {
            uneFrame.setBefore(listFrame.get(listFrame.size() - 1));
        } else {
            uneFrame.setBefore(Type.NORMAL);
        }

        listFrame.add(uneFrame);
    }

    private Frame createFrame(Queue<Character> queue) throws Exception {
        char first, second, separator;
        first = queue.poll();
        second = queue.poll();
        separator = queue.poll();
        if(separator != '-') {
            throw new Exception("Wrong syntax for Game description");
        }

        return new Frame(first,second,null);
    }

    /**
     * Method which initializes all the frames of the game
     * @param queue a queue of Character representing all the launches
     * @throws Exception if the game is invalid
     */
    public void doAllFrames(Queue<Character> queue) throws Exception {

        if (queue.size() > 33)
            throw new Exception("Too much launches, invalid game");

        while (!queue.isEmpty()) {
            initFrames(queue);
        }
        // Should be called only if more than 10 frame !
        if(listFrame.size() < 10) {
            throw new Exception("Not enough Frames, invalid game: "+listFrame.size());
        } else if(listFrame.size()> 10) {
            Type type = listFrame.get(listFrame.size()-2).getType();
            switch (type) {
                case STRIKE:
                    listFrame = setLastFrame();
                    break;
                case SPARE:
                    testLastSpare();
                    listFrame = setLastFrame();
                    break;
                case NORMAL:
                    throw new Exception("Can't have more than 10 frame with no Spare or Strike on last Frame.");
            }

        }

    }

    private void testLastSpare() throws Exception {
        if(listFrame.get(listFrame.size()-1).getSecondLaunch() != Frame.ZERO) {
            throw new Exception("The last frame after a launch can't have two launch.");
        }
    }


    /**
     * Method which detects if the end of the game was an exceptional frame (spare or strike)
     * which allows 1 or 2 more launches respectively and thus implies an alternative calculation
     * of the score
     * @return the list of frame
     */
    public List<Frame> setLastFrame () {

        if (listFrame.get(listFrame.size() - 2).getFirstLaunch() == 'X') {
            listFrame.get(listFrame.size() - 1).lastFrame();
        }
        else if (listFrame.get(listFrame.size() -2).getSecondLaunch() == '/') {
            listFrame.get(listFrame.size() - 1).lastFrame();
        }

        return  listFrame;
    }

    public int getScore() {
        int score = 0;
        for(Frame f: listFrame) {
            try {
                score += f.getScore();
            } catch (Exception e) {
                return 0;
            }
        }
        return score;
    }
}

