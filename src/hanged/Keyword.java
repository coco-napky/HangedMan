package hanged;

class Keyword {
    String word;
    
    Keyword(String word) {
        this.word = word;
    }
    
    public String getWord() {
        return word;
    }
    
    @Override
    public String toString(){
        return this.word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
}
