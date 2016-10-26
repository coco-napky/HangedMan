package hanged;

import java.util.List;

class Game {
    private RoundRobin roundRobin;
    private List<Keyword> keywords;
    private Display display;
    private Player currentPlayer;
    private Keyword currentKeyword;
    private int chances;
    private boolean success;
    
    public int getChances() {
        return chances;
    }
    
    public Game( RoundRobin<Player> roundRobin,
                 List<Keyword> keywords, Display display)
           throws IllegalConfigurationException {
        
        this.roundRobin = roundRobin;
        this.keywords = keywords;
        this.display = display;
        this.currentPlayer = (Player) this.roundRobin.getCurrent();
        this.chances = 3;
        
        if(keywords.isEmpty())
            throw new IllegalConfigurationException("Empty keywords list");
        
        if(roundRobin.isEmpty())
            throw new IllegalConfigurationException("Empty players list");
        
        setCurrentKeyword();
    }

    boolean isGameover() {
        return chances == 0 || currentKeyword.isMatched();
    }

    void play(PlayerInput input) throws Exception{
        
        if(isGameover())
           throw new GameoverException("Game is over");
        
        if(!isValidInput(input))
            throw new InvalidInputException(input);
        
        int failures = currentKeyword.matchLetters(input);
        
        if(currentKeyword.isMatched())
            success=true;
        chances -= failures;
    }
    
    public boolean isSuccess() {
        return success;
    }
    //ToDo: Random or picked by other player?
    private void setCurrentKeyword() {
        int maximum = keywords.size() - 1;
        currentKeyword = keywords.get(Utils.getRandomInteger(0, maximum));
    }

    private boolean isValidInput(PlayerInput input) {
        return input.getWord().length() > 0;
    }

    public String getMatchedLetters() {
        return this.currentKeyword.getMatchedLetters();
    }
}
