package dcll.kelt;

import java.util.Queue;

/**
 * Created by kelto on 11/03/15.
 */
public class ScoreChecker {

    private Queue<Character> scoreLancer;
    private Etat state;
    private int nbFrame;
    // maybe useless
    private int nbLancer;
    private int frameScore;
    private int score;


    public ScoreChecker(Queue<Character> queue)
    {
        this.scoreLancer = queue;
        state = Etat.INIT;
        nbFrame = 0;
        nbLancer = 0;
        frameScore = 0;
        score = 0;
    }

    public int getScore()
    {
        runSimulation();
        return this.score;
    }

    private void runSimulation()
    {
        init();
    }

    private void init()
    {
        switch (this.state)
        {
            case INIT:
                Character c = scoreLancer.poll();
                Type type = getType(c);
                if(type == Type.STRIKE)
                {
                    strike();
                }
                    break;
            case LANCER:
                break;
            case SPARE:
                break;
            case STRIKE:
                break;
            case LAST_SPARE:
                break;
            case LAST_STRIKE:
                break;
            case END:
                break;
        }

    }

    private void strike()
    {

    }
    private Type getType(Character c)
    {
        Type type;
        if(Character.isDigit(c))
        {
            type = Type.NORMAL;
        }
        else
        {
            switch (c)
            {
                case '/':
                    type = Type.SPARE;
                    break;
                case 'X':
                    type = Type.STRIKE;
                    break;
                case '_':
                    type = Type.EMPTY;
                    break;
                default:
                    throw new RuntimeException("Wrong input for score");
            }
        }

        return type;

    }

    private boolean validateType(Type type)
    {
        return false;
    }

    private int getValue(Character c)
    {
        Type type = getType(c);
        switch (type)
        {
            case NORMAL:
        }
        return 0;
    }
}
