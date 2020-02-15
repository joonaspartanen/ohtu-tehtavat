package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        Player player = findPlayer(playerName);
        player.addPoint();
    }

    public String getScore() {
        if (tied()) {
            return getTiedScore();
        }
        if (advantageScoring()) {
            return handleAdvantageScoring();
        }
        return translateScore(player1.getScore()) + "-" + translateScore(player2.getScore());
    }

    private Player findPlayer(String name) {
        if (player1.getName() == name) {
            return player1;
        } else if (player2.getName() == name) {
            return player2;
        }
        return null;
    }

    private boolean tied() {
        return player1.getScore() == player2.getScore();
    }

    private String getTiedScore() {
        if (deuceReached()) {
            return "Deuce";
        }
        return translateScore(player1.getScore()) + "-" + "All";
    }

    private boolean deuceReached() {
        return player1.getScore() >= 4 && player2.getScore() >= 4;
    }

    private boolean advantageScoring() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private Player hasAdvantage() {
        if (player1.getScore() > player2.getScore()) {
            return player1;
        }
        return player2;
    }

    private Player isWinning() {
        if (player1.getScore() > player2.getScore()) {
            return player1;
        }
        return player2;
    }

    private int getDifference() {
        int difference = player1.getScore() - player2.getScore();
        return Math.abs(difference);
    }

    private String handleAdvantageScoring() {
        if (getDifference() == 1) {
            Player player = hasAdvantage();
            return "Advantage " + player.getName();
        } else {
            Player player = isWinning();
            return "Win for " + player.getName();
        }
    }

    private String translateScore(int score) {
        switch (score) {
        case 0:
            return "Love";
        case 1:
            return "Fifteen";
        case 2:
            return "Thirty";
        case 3:
            return "Forty";
        default:
            return null;
        }
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public void addPoint() {
        this.score++;
    }
}