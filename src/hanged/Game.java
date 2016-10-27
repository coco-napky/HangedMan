package hanged;

import java.util.List;

class Game {
    private RoundRobin<Player> roundRobin;
    private List<Keyword> keywords;
    private Display display;
    private Player currentPlayer;
    private Keyword currentKeyword;
    private int chances;
    private boolean success;
    private Input input;
    
    public int getChances() {
        return chances;
    }
    
    public Game( RoundRobin<Player> roundRobin,
                 List<Keyword> keywords, Display display, Input input)
           throws IllegalConfigurationException, InputException {
        
        this.roundRobin = roundRobin;
        this.keywords = keywords;
        this.display = display;
        this.currentPlayer =  this.roundRobin.getCurrent();
        this.chances = 3;
        this.input = input;
        
        if(keywords.isEmpty())
            throw new IllegalConfigurationException("Empty keywords list");
        
        if(roundRobin.isEmpty())
            throw new IllegalConfigurationException("Empty players list");
        
        setCurrentKeyword();
    }

    boolean isRoundOver() {
        return chances <= 0 || currentKeyword.isMatched();
    }

    boolean isGameOver() {
        for (Player player : roundRobin)
            return player.score == 5;
        
        return false;
    }
    
    void play(PlayerInput input) throws Exception{
        
        if(isGameOver())
           throw new GameoverException("Game is over");

        if(!isValidInput(input))
            throw new InvalidInputException(input);

        int failures = currentKeyword.matchLetters(input);

        if(currentKeyword.isMatched()) {
            success = true;
            currentPlayer.score++;
        }
        chances -= failures;
            
    }

    public boolean checkResetRound() throws InputException{        
        if(isRoundOver())
        {
            chances = 3;
            currentKeyword = null;
            setCurrentKeyword();
            currentPlayer = roundRobin.next();
            success = false;
            return true;
        }
        return false;
    }
    
    public boolean isSuccess() {
        return success;
    }
    private void setCurrentKeyword() throws InputException{
      if(currentKeyword == null) {
        if(roundRobin.size() == 1)
            setRandomKeyword();
        else
            setPlayerKeyword();
      }
        
    }

    private void setPlayerKeyword() throws InputException {
        String keyword = input.getPlayerInput().getWord();
        currentKeyword = new Keyword(keyword);
    }

    private void setRandomKeyword() {
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
