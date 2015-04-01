package dcll.kelt.model.Frame;

import java.util.ListIterator;

/**
 * Created by kelto on 31/03/15.
 */
public class StrikeFrame extends Frame {


    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     */
    public StrikeFrame(Launch firstLaunch, Launch secondLaunch) {
        super(firstLaunch, secondLaunch);
    }

    @Override
    public int getScore() {
        if (!isValid()) {
            return 0;
        }

        try {
            Launch next = getFirst().getNext();
            Launch secondNext = next.getNext();
            if(secondNext.isSpare()) {
                return MAX_VALUE * 2;
            } else {
                return MAX_VALUE + next.getValue() + secondNext.getValue();
            }

        } catch (Exception e) {
            return 0;
        }


    }

    @Override
    protected int getBasicValue() {
        return MAX_VALUE;
    }

    @Override
    public boolean isValid() {
        return getFirst().isStrike() && getSecond().isZero();
    }
}
