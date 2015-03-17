package dcll.kelt.state;

/**
 * Created by kelto on 14/03/15.
 */
public class LastStrikeState extends BowlingState{

    private static LastStrikeState state = null;

    public static LastStrikeState state() {
        if(state == null)
            state = new LastStrikeState();
        return state;
    }

    @Override
    public void init(BowlingContext context) {

    }

    @Override
    public void lancer(BowlingContext context) {

    }

    @Override
    public void strike(BowlingContext context) {

    }

    @Override
    public void spare(BowlingContext context) {

    }


}
