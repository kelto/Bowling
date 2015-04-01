package dcll.kelt.model.Frame;

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

        Launch next = getFirst().getNext();
        Launch secondNext = next.getNext();
        if (secondNext.isSpare()) {
            return MAX_VALUE + secondNext.getValue();
        } else {
            return MAX_VALUE + next.getValue() + secondNext.getValue();
        }


    }

    @Override
    public boolean isValid() {
        return getFirst().isStrike() && getSecond().isZero();
    }
}
