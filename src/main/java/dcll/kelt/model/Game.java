package dcll.kelt.model;

import dcll.kelt.model.Frame.Frame;
import dcll.kelt.model.Frame.SpareFrame;
import dcll.kelt.model.Frame.StrikeFrame;

import java.util.*;

/**
 * Created by kelto on 18/03/15.
 */
public class Game {
    private Deque<Frame> listFrame;
    private Frame last;


    public Game(Deque<Frame> deque) {
        this.listFrame = deque;
        last = null;
    }


    private boolean isValid() {
        boolean valid = listFrame.size() < 12 && listFrame.size() > 9 ;
        for(Frame f : listFrame) {
            valid &= f.isValid();
        }
        if(listFrame.size() == 11) {
            last = listFrame.poll();
            Frame frame = listFrame.peek();
            if(!isSpecialFrame(frame)) {
                valid = false;
            } else if(isSpare(frame) && !lastValidSpare()) {
                valid = false;
            }
        } else {
            // only possibility is 10 frames in the stack.
            // can't have only 10 frames and the last one is
            // a Strike or a Spare.
            if(isSpecialFrame(listFrame.peek())) {
                valid = false;
            }
        }
        return valid;
    }

    private boolean lastValidSpare() {
        return last.secondIsZero();
    }

    private boolean isSpecialFrame(Frame frame) {
        return  isStrike(frame) || isSpare(frame);
    }

    private boolean isStrike(Frame frame) {
        return frame.getClass() == StrikeFrame.class;
    }

    private boolean isSpare(Frame frame) {
        return frame.getClass() == SpareFrame.class;
    }

    public int getScore() throws Exception {
        if(!isValid()) {
            throw new Exception("Unvalid Game.");
        }
        int score = 0;
        // If more than 11 frame, the 11th will only be used by the 10th
        // the last attribute has been filed by the isValid() method if 11 frames
        // are in the Stack. If not, null attribute. Might be goo
        Frame previous = last;

        for(Frame f: listFrame) {
            score += f.getScore(previous);
            previous = f;
        }
        return score;
    }


}

