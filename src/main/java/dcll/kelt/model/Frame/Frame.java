package dcll.kelt.model.Frame;


/**
 * Created by kelto on 15/03/15.
 */

public abstract class Frame {
    /**
     * Character representing special launch.
     */
    public static final char ZERO = '_',
            STRIKE = 'X',
            SPARE = '/';
    /**
     * Max Value of a frame without taking in account the multiplicator factor.
     */
    protected static final int MAX_VALUE = 10;
    /**
     * Score of the first launch if exist.
     */
    private Character first;

    /**
     * @return the second launch
     */
    public final Character getSecond() {
        return second;
    }

    /**
     * Score of the second launch if exist.
     */
    private Character second;

    /**
     * @return the first launch
     */
    public final Character getFirst() {
        return first;
    }

    /**
     * @param firstLaunch  score of the first launch
     * @param secondLaunch score of the second launch.
     */

    public Frame(final Character firstLaunch, final Character secondLaunch) {
        this.first = firstLaunch;
        this.second = secondLaunch;
    }

    /**
     * Method to calculate the score of the frame.
     * Should be called after isValid() is called.
     * @param frame the Frame with which to calculate
     * @return int
     */
    public abstract int getScore(Frame frame);

    /**
     * Method to return the basic score of a frame.
     * @throws Exception
     * @return int the score
     */
    protected abstract int getBasicValue() throws Exception;

    /**
     * Test the validity of the frame.
     *
     * @return boolean
     */
    public abstract boolean isValid();

    /**
     * Test if the char defining a launch is valid.
     * @param launch the character representing the launch,
     * @return boolean
     */


    /**
     * Getter for the first launch of a frame.
     * @throws Exception
     * @return Character
     */
    protected final int getFirstValue() throws Exception {
        if (!this.isValid()) {
            throw new Exception("Unvalid Frame.");
        }
        int value = 0;
        if (Character.isDigit(first)) {
            value = Integer.parseInt("" + first);
        } else if (first == STRIKE) {
            // Since the first digit can be either a number, a Strike or Zero
            value = MAX_VALUE;
        }
        // No need to check otherwise, the value must be 0 if it hasn't changed.
        return value;
    }

    /**
     * Method to check if the second launch is null.
     * @return boolean value
     */
    public final boolean secondIsZero() {
        return second == ZERO;
    }
}
