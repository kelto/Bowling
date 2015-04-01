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

    public Launch(char launch) {
        this.launch = launch;
        next = null;
    }


    public Launch getNext() {
        return next;
    }

    public void setNext(Launch next) {
        this.next = next;
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
        if (isStrike()) {
            return Frame.MAX_VALUE;
        } else if (isSpare()) {
            // might be good to take into account the previous
            // launch, but not necessary.
            return Frame.MAX_VALUE;
        } else if (isDigit()) {
            return Integer.parseInt("" + launch);
        } else {
            return 0;
        }
    }

}
