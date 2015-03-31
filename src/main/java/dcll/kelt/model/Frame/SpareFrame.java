package dcll.kelt.model.Frame;

/**
 * Created by kelto on 31/03/15.
 */
public class SpareFrame extends Frame {
    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     */
    public SpareFrame(Character firstLaunch, Character secondLaunch) {
        super(firstLaunch, secondLaunch);
    }

    @Override
    public int getScore(Frame frame) {
        if (!isValid()) {
            return 0;
        }
        try {
            return MAX_VALUE + frame.getFirstValue();
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
        return Character.isDigit(first) && second == SPARE;
    }
}
