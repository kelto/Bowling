package dcll.kelt.model;

import dcll.kelt.model.Frame.Frame;
import dcll.kelt.model.Frame.NormalFrame;
import dcll.kelt.model.Frame.SpareFrame;
import dcll.kelt.model.Frame.StrikeFrame;

import java.util.*;

/**
 * Created by kelto on 18/03/15.
 */
public class Game {
    private ArrayList<Frame> listFrame;


    public Game(ArrayList<Frame> deque) {
        this.listFrame = deque;
    }


    private boolean isValid() {
        boolean valid = listFrame.size() < 13 && listFrame.size() > 9;
        for (Frame f : listFrame) {
            valid &= f.isValid();
        }
        // two possibilities, either the 10th frame is a spare, then only one launch
        // in the 11th frame.
        // Or the 10th is a Strike, and the 11th is Either a Normal or a Spare.
        if (listFrame.size() == 11) {
            Frame frame = listFrame.get(10);
            Frame eleventh = listFrame.get(listFrame.size() - 1);
            // 10th Frame is normal, not valid.
            if (!isSpecialFrame(frame)) {
                valid = false;
            } else if (isSpare(frame) && !eleventh.getSecond().isZero()) {
                valid = false;
            } else if(isStrike(frame) && isStrike(eleventh)) {
                valid = false;
            }
        } else if(listFrame.size() == 12) {
            //only possibility the last 3 frames are all strike.
            Frame tenth = listFrame.get(9);
            Frame eleventh = listFrame.get(10);
            Frame twelve = listFrame.get(11);
            if(!isStrike(tenth) && !isStrike(eleventh) && !isStrike(twelve) ) {
                valid = false;
            }
        }

        else {
            // only possibility is 10 frames in the stack.
            // can't have only 10 frames and the last one is
            // a Strike or a Spare.
            if (isSpecialFrame(listFrame.get(listFrame.size() - 1))) {
                valid = false;
            }
        }
        return valid;
    }

    private boolean lastValidSpare() {
        return listFrame.get(11).secondIsZero();
    }

    private boolean isSpecialFrame(Frame frame) {
        return frame.getClass() != NormalFrame.class;
    }

    private boolean isStrike(Frame frame) {
        return frame.getClass() == StrikeFrame.class;
    }

    private boolean isSpare(Frame frame) {
        return frame.getClass() == SpareFrame.class;
    }


    public int getScore() throws Exception {
        if (!isValid()) {
            throw new Exception("Unvalid Game.");
        }
        int score = 0;
        // If more than 11 frame, the 11th will only be used by the 10th
        // the last attribute has been filed by the isValid() method if 11 frames
        // are in the Stack. If not, null attribute. Might be goo
        //Frame previous = last;
        for (int i = 0; i < 10; i++) {

            score += listFrame.get(i).getScore();
        }
        return score;
    }


}

