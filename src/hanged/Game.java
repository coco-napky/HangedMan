package hanged;

class Game {
    private boolean gameover;
    private RoundRobin roundRobin;
    private KeywordReader keywordReader;
    private Display display;
    
    public Game( RoundRobin<Player> roundRobin,
                 KeywordReader keywordReader, Display display) {
        this.gameover = false;
        this.roundRobin = roundRobin;
        this.keywordReader = keywordReader;
        this.display = display;
    }

    boolean isGameover() {
        return this.gameover;
    }

    void play() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
