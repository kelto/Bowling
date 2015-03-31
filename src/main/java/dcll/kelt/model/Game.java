package dcll.kelt.model;

import dcll.kelt.model.Frame.Frame;

import java.util.*;

/**
 * Created by kelto on 18/03/15.
 */
public class Game {
    private Deque<Frame> listFrame;
    private int score;
    private boolean valid;
    private String error;

    public Game() {
        this.listFrame = new ArrayDeque<Frame>();
    }

    /**
     * Methode which initializes a frame with its right instance variable
     * @param queue a queue of Character representing all the launches
     * @throws Exception if the frame is invalid
     */
    private void initFrames(Queue<Character> queue) throws Exception {

        /*
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
        */
    }

    private Frame createFrame(Queue<Character> queue) throws Exception {
        /*
        char first, second, separator;
        first = queue.poll();
        second = queue.poll();
        separator = queue.poll();
        if(separator != '-') {
            throw new Exception("Wrong syntax for Game description");
        }

        return new Frame(first,second);
        */
        return null;
    }

    /**
     * Method which initializes all the frames of the game
     * @param queue a queue of Character representing all the launches
     * @throws Exception if the game is invalid
     */
    public void doAllFrames(Queue<Character> queue) throws Exception {
    /*
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
                    setLastFrame();
                    break;
                case SPARE:
                    testLastSpare();
                    listFrame = setLastFrame();
                    break;
                case NORMAL:
                    throw new Exception("Can't have more than 10 frame with no Spare or Strike on last Frame.");
            }

        }
        */

    }
/*
    private void testLastSpare() throws Exception {
        if(listFrame.get(listFrame.size()-1).getSecondLaunch() != Frame.ZERO) {
            throw new Exception("The last frame after a launch can't have two launch.");
        }
    }

*/
    public int getScore() {
        Frame previous = null;
        int score = 0;
        // If more than 11 frame, the 11th will only be used by the 10th
        if(listFrame.size() == 11) {
            previous = listFrame.poll();
        }

        for(Frame f: listFrame) {
            score += f.getScore(previous);
        }
        return 0;
    }


}

