package dcll.kelt.model;

/**
 * Created by kelto on 15/03/15.
 */

public class Frame {
    /**
     * Character representing special launch.
     */
    public static final char ZERO = '_',
            STRIKE = 'X',
            SPARE = '/';
    /**
     * Max Value of a frame without taking in account the multiplicator factor.
     */
    private static final int MAX_VALUE = 10;
    /**
     * Type of the Frame.
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
     * Value to see if the frame is exceptional
     * used for exceptional calculation of score
     */
    private boolean lastFrame;


    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     * @param previousType Type of the previous frame
     */
    public Frame(final Character firstLaunch, final Character secondLaunch,
                 final Type previousType) {
        this.first = firstLaunch;
        this.second = secondLaunch;
        this.before = previousType;
        this.lastFrame = false;
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

        if (before == Type.STRIKE && !lastFrame) {
            return (val1 + val2) * 2;
        } else if (before == Type.SPARE && !lastFrame) {
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
        if (first == STRIKE && second != ZERO) {
            System.out.println("first is strike and second not null");
            valid = false;
        }

        if (Character.isDigit(first) && second == STRIKE) {
            valid = false;
        }

        if (first == SPARE) {
            valid = false;
        }

        try {
            int total = getValue(first) + getValue(second);
            if (first != STRIKE && second != SPARE &&  total > 9) {
                valid = false;
            }


        } catch (Exception e) {
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
    private boolean exist(final Character launch) {
        return launch != null && validChar(launch);
    }

    private boolean validChar(final char launch) {
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
                // Must be done in case of unvalid Frame with Spare as first launch
                if(first == SPARE) {
                    return 0;
                } else {
                    return MAX_VALUE - getValue(first);
                }

            case ZERO:
                return 0;

            default:
                throw new Exception("can't recognize token.");
        }

    }

    /**
     * Getter for the first launch of a frame
     *
     * @return Character
     */
    public Character getFirstLaunch() {
        return this.first;
    }

    /**
     * Setter for the second launch of a frame
     * @param x the future value of the second launch
     */
    public void setSecond(Character x) {
        this.second = x;
    }

    /**
     * Setter for the type of the previous frame
     * @param uneFrame the previous frame of this current one
     */
    public void setBefore(Frame uneFrame) {

        this.before = Type.NORMAL;


    }

    public Type getType() {
        if (this.first == 'X') {
            return Type.STRIKE;
        } else if(this.second == '/') {
            return Type.SPARE;
        } else {
            return Type.NORMAL;
        }
    }

    /**
     * Setter for the type of the previous frame
     * @param type the type of the previous frame of this current one
     */
    public void setBefore(Type type) {

        this.before = type;
    }

    /**
     * Method to make the frame exceptional for alternative calculation of score
     */
    public void lastFrame() {
        this.lastFrame = true;
    }

    /**
     * Getter for the second launch of the frame
     * @return Character
     */
    public Character getSecondLaunch() {
        return this.second;
    }

    public boolean isType(Type type) { return type == getType(); }
}
