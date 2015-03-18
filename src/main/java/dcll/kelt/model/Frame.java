package dcll.kelt.model;

/**
 * Created by kelto on 15/03/15.
 */

public class Frame {
    /**
     * Character representing special launch.
     */
    private static final char ZERO = '_',
            STRIKE = 'X',
            SPARE = '/';
    /**
     * Max Value of a frame without taking in account the multiplicator factor.
     */
    private static final int MAX_VALUE = 10;
    /**
     * Type of the previous Frame.
     */
    private Type before;
    /**
     * Score of the first launch.
     */
    private Character first;
    /**
     * Score of the second launch if exist.
     */
    private Character second;

    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     * @param previousType Type of the previous frame
     */
    public Frame(final char firstLaunch, final Character secondLaunch,
                 final Type previousType) {
        this.first = firstLaunch;
        this.second = secondLaunch;
        this.before = previousType;
    }

    /**
     * method to calculate the score of the frame.
     * Should be called after isValid() is called.
     *
     * @return int
     * @throws Exception if the frame is invalid.
     */
    public final int getScore() throws Exception {
        int val1, val2;
        try {
            val1 = getValue(first);
            val2 = getValue(second);
        } catch (Exception e) {
            // Should not be thrown if isValid() is asked.
            throw new Exception("Unvalid frame.");
        }

        if (before == Type.STRIKE) {
            return (val1 + val2) * 2;
        } else if (before == Type.SPARE) {
            return val1 * 2 + val2;
        } else {
            return val1 + val2;
        }
    }

    /**
     * Test the validity of the frame.
     *
     * @return boolean
     */
    public final boolean isValid() {
        boolean valid = true;
        if (!exist(first) || !exist(second)) {
            valid = false;
        }
        if (first == STRIKE && second != null) {
            valid = false;
        }

        return valid;
    }

    /**
     * Test if the char defining a launch is valid.
     *
     * @param launch the character representing the launch.
     * @return boolean
     */
    private boolean exist(final char launch) {
        return Character.isDigit(launch)
                || launch == ZERO
                || launch == STRIKE
                || launch == SPARE;
    }

    /**
     * get the value of the char defining a launch.
     *
     * @param launch the character representing the launch.
     * @return int
     * @throws Exception will be launch if the character defining the launch
     * can't be recognize.
     */
    private int getValue(final char launch) throws Exception {
        if (Character.isDigit(launch)) {
            return Integer.parseInt("" + launch);
        }
        switch (launch) {

            case STRIKE:
                return MAX_VALUE;

            case SPARE:
                return MAX_VALUE - getValue(first);

            case ZERO:
                return 0;

            default:
                throw new Exception("can't recognize token.");
        }

    }


}
