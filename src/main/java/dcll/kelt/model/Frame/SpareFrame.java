package dcll.kelt.model.Frame;

import java.util.ListIterator;

/**
 * Created by kelto on 31/03/15.
 */
public class SpareFrame extends Frame {
    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     */
    public SpareFrame(Launch firstLaunch, Launch secondLaunch) {
        super(firstLaunch, secondLaunch);
    }

    @Override
    public int getScore() {
        if (!isValid()) {
            return 0;
        }
        try {
            return MAX_VALUE + getSecond().getNext().getValue();
        } catch (Exception e) {
            return 0;
        }
    }


    @Override
    public boolean isValid() {
        return (getFirst().isDigit() || getFirst().isZero()) && getSecond().isSpare();
    }
}
