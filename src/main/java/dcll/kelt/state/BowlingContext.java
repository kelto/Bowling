package dcll.kelt.state;

/**
 * Created by kelto on 14/03/15.
 */
public abstract class BowlingContext {

    private BowlingState state;
    private int score;
    private int nbFrame;
    private int lancer;
    private int scoreFrame;

    private String erreur;

    public BowlingContext()
    {
        this.state = InitState.state();
        this.lancer = 0;
        this.score = 0;
        this.scoreFrame = 0;
        this.nbFrame = 0;
        erreur = "";
    }

    public void setState(BowlingState state)
    {
        this.state = state;
    }

    public int getLancer()
    {
        return lancer;
    }

    public void newLancer()
    {
        lancer++;
    }

    public int getScoreFrame()
    {
        return scoreFrame;
    }

    public int getScore()
    {
        return score;
    }

    public boolean lancer(int val)
    {
        this.scoreFrame += val;
        try {
            this.state.lancer(this);
            return true;
        } catch (Exception e) {
            erreur = e.getMessage();
            return false;
        }
    }

    public boolean spare()
    {
        try {
            this.state.spare(this);
            return true;
        } catch (Exception e) {
            erreur = e.getMessage();
            return false;
        }
    }

    public boolean strike()
    {
        try {
            this.state.strike(this);
            return true;
        } catch (Exception e) {
            erreur = e.getMessage();
            return false;
        }
    }

    public int getNbFrame()
    {
        return nbFrame;
    }

    public void newFrame() {
        nbFrame++;
        lancer = 0;
        scoreFrame = 0;
    }

    public void addScore(int score) {
        this.score += score;
    }
}
