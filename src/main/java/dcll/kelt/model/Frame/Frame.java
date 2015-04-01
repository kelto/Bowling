package dcll.kelt.model.Frame;


/**
 * Created by kelto on 15/03/15.
 */

public abstract class Frame {

    /**
     * Max Value of a frame without taking in account the multiplicator factor.
     */
    protected static final int MAX_VALUE = 10;
    /**
     * Score of the first launch if exist.
     */
    private Launch first;


    /**
     * Score of the second launch if exist.
     */
    private Launch second;


    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     */
    public Frame(final Launch firstLaunch, final Launch secondLaunch) {
        this.first = firstLaunch;
        this.second = secondLaunch;
    }

    public Launch getFirst() {
        return first;
    }

    public Launch getSecond() {
        return second;
    }

    /**
     * method to calculate the score of the frame.
     * Should be called after isValid() is called.
     *
     * @return int
     */
    public abstract int getScore();

    /**
     * Test the validity of the frame.
     *
     * @return boolean
     */
    public abstract boolean isValid();

}
