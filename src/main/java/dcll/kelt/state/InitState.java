package dcll.kelt.state;

/**
 * Created by kelto on 14/03/15.
 */
public class InitState extends BowlingState {

    private static InitState state = null;

    public static InitState state()
    {
        if(state == null)
            state = new InitState();
        return state;
    }


    @Override
    public void lancer(BowlingContext context) {
        context.setState(LaunchState.state());

    }

    @Override
    public void strike(BowlingContext context) {
        context.newFrame();
        if(context.getScoreFrame() == 10)
            context.setState(StrikeState.state());
    }

    @Override
    public void last_strike(BowlingContext context) {
        context.setState(LastStrikeState.state());
    }
}
