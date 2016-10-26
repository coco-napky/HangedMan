package hanged;

import java.util.List;

class Game {
    private boolean gameover;
    private RoundRobin roundRobin;
    private List<Keyword> keywords;
    private Display display;
    
    public Game( RoundRobin<Player> roundRobin,
                 List<Keyword> keywords, Display display) {
        this.gameover = false;
        this.roundRobin = roundRobin;
        this.keywords = keywords;
        this.display = display;
    }

    boolean isGameover() {
        return this.gameover;
    }

    void play() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
