package hanged;

class PlayerInput {

    private final String word;
    
    PlayerInput(String word) {
        this.word = word;
    }

    String getWord() {
        return this.word;
    }

    @Override
    public String toString() {
        return "PlayerInput{" + "word=" + word + '}';
    }
    
}
