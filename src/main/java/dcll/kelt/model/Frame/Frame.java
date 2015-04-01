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
     * @return the second launch
     */
    private Launch second;

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
     * Method to calculate the score of the frame.
     * Should be called after isValid() is called.
     * @param frame the Frame with which to calculate
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
