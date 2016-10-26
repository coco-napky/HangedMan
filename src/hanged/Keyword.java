package hanged;

import java.util.ArrayList;
import javafx.util.Pair;

final class Keyword {
    ArrayList<Pair<Character, Boolean>> word;
    private char hiddenCharacter;
    Keyword(String word) {
        hiddenCharacter = '#';
        this.word = new ArrayList<>();
        setWord(word);
    }
    
    public ArrayList<Pair<Character, Boolean>> getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "Keyword{" + "word=" + getUnmatchedLetters() + '}';
    }
    
    public void setWord(String word) {
        for (int i = 0; i < word.length(); i++) 
            this.word.add(new Pair<>(word.charAt(i), false));
    }
    
    private char getLetter(int index, boolean hidden){
        Pair pair = this.word.get(index);
        boolean matched = (boolean) pair.getValue();
        char c = (Character) pair.getKey();        
        return hidden && !matched ? this.hiddenCharacter : c;
    }
    
    private String getLetters(boolean hidden) {
        String letters = "";
        for (int i = 0; i < this.word.size(); i++)
            letters += getLetter(i, hidden);
        return letters;
    }
    
    private String getUnmatchedLetters() {
        return getLetters(false);
    }
    
    public String getMatchedLetters() {
        return getLetters(true);
    }
    
    boolean isLetterMatch(char letter) {
        for (int i = 0; i < this.word.size(); i++){
            
            if(!isLetterHidden(i))
                continue;
            
            char c = getLetter(i, false);  
            if(c == letter)
                return true;
        }
        return false;
    }
    

    int matchLetters(PlayerInput input) {
        String word = input.getWord();
        int failures = 0;
        for (int i = 0; i < word.length(); i++) 
            if(!isLetterMatch(word.charAt(i)))
               ++failures;
            else
                matchLetter(word.charAt(i));
        return failures;
    }

    private void matchLetter(char letter) {
        for (int i = 0; i < this.word.size(); i++){
          if(!isLetterHidden(i))
              continue;
          
          char c = getLetter(i, false);  

          if(c == letter)
             this.word.set(i, new Pair<>(c, true));
        }
    }

    private boolean isLetterHidden(int index) {
        return getLetter(index, true) == this.hiddenCharacter;  
    }
    
    //all letters matched?
    //Todo: better name?
    boolean isMatched() {
        for (int i = 0; i < this.word.size(); i++)
          if(isLetterHidden(i))
              return false;
        return true;
    }
    
    
}
