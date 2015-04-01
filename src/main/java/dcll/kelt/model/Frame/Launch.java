package dcll.kelt.model.Frame;

/**
 * Created by kelto on 01/04/15.
 */
public class Launch {

    /**
     * Character representing special launch.
     */
    public static final char ZERO = '_',
            STRIKE = 'X',
            SPARE = '/';

    private char launch;

    private Launch next;
    private Launch previous;
    private boolean isSet;

    public Launch(char launch) {
        this.launch = launch;
        next = null;
        this.isSet = true;
    }


    public char getLaunch() {
        return launch;
    }
    public Launch getNext() {
        return next;
    }

    public void setNext(Launch next) {
        this.next = next;
    }

    public Launch getprevious() {
        return previous;
    }

    public void setprevious(Launch previous) {
        this.previous = previous;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean isStrike() {
        return launch == STRIKE;
    }

    public boolean isSpare() {
        return launch == SPARE;
    }

    public boolean isZero() {
        return launch == ZERO;
    }

    public boolean isDigit() {
        // A 0 should be stored as ZERO.
        return Character.isDigit(launch) && launch != '0';
    }

    public boolean isValid() {
        return isDigit() || isZero() || isSpare() || isStrike();
    }

    public int getValue() {
        if(isStrike()) {
            return Frame.MAX_VALUE;
        } else if (isSpare()) {
            return Frame.MAX_VALUE - previous.getValue();
        } else if(isDigit()) {
            return Integer.parseInt(""+launch);
        } else {
            return 0;
        }
    }

    public boolean isSet() {
        return isSet;
    }

    public void unset() {
        isSet = false;
    }

}
