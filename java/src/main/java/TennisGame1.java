public class TennisGame1 implements TennisGame {

    public static final int POINT_VALUE = 1;
    public static final String ZERO_POINTS_STRING = "Love";
    public static final String ONE_POINT_STRING = "Fifteen";
    public static final String TWO_POINTS_STRING = "Thirty";
    public static final String THREE_POINTS_STRING = "Forty";
    public static final String DEUCE_STRING = "Deuce";
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ((playerName.equals(player1Name)))
            addPointToPlayer1();
        else
            addPointToPlayer2();
    }

    private void addPointToPlayer2() {
        m_score2 += POINT_VALUE;
    }

    private void addPointToPlayer1() {
        m_score1 += POINT_VALUE;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore=0;
        if (isATie())
        {
            switch (m_score1)
            {
                case 0:
                        score = new StringBuilder("Love-All");
                    break;
                case 1:
                        score = new StringBuilder("Fifteen-All");
                    break;
                case 2:
                        score = new StringBuilder("Thirty-All");
                    break;
                default:
                        score = new StringBuilder(DEUCE_STRING);
                    break;

            }
        }
        else if (isAdvantageGame())
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score = new StringBuilder("Advantage player1");
            else if (minusResult ==-1) score = new StringBuilder("Advantage player2");
            else if (minusResult>=2) score = new StringBuilder("Win for player1");
            else score = new StringBuilder("Win for player2");
        }
        else
        {
            score.append(getPointString(m_score1)).append("-").append(getPointString(m_score2));
        }
        return score.toString();
    }

    private String getPointString(int tempScore ) {
        return switch (tempScore) {
            case 0 -> ZERO_POINTS_STRING;
            case 1 -> ONE_POINT_STRING;
            case 2 -> TWO_POINTS_STRING;
            case 3 -> THREE_POINTS_STRING;
            default -> "";
        };
    }

    private boolean isAdvantageGame() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private boolean isATie() {
        return m_score1 == m_score2;
    }
}
